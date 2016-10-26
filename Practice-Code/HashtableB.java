import java.util.*;
import java.lang.reflect.Array;

// A linear-probing hash table implementation
public class HashtableB<Key extends Comparable Key, Value> implements ST<Key extends Comparable Key, Value> {
    private static final int MIN_CAP = 11; // The minimum size of the array; when smaller than this, no down-sizing will occur.

    private Pair[] arr; // The array holding all the key/value pairs
    private int size; // The current number of elements.
    private int cap; // Current capacity of the array.

    private double max; // determines how full the array can get before resizing occurs; default 1/2
    private double min; // determines how empty the array can get before resizing occurs; default 3/4
    private double set; // determines how full the array should be made when resizing; default 1/4

    // Primary constructor.
    // Set determines how full the array should be made when resizing
    // Maximum determines how full the array can get before resizing occurs
    // Minimum determines how empty the array can get before resizing occurs
    public HashtableB(double maximum, double minimum, double set){
        assert set < maximum && maximum < 1;
        assert 0 < minimum && minimum < set;
        size = 0;
        cap = MIN_CAP;
        max = maximum;
        min = minimum;
        this.set = set;

        arr = (Pair[]) Array.newInstance(Pair.class, cap); // Make the new array;
    }

    // Default the set-size ratio to 1/2
    public HashtableB(double maximum, double minimum){
        this(maximum, minimum, 0.5);
    }

    // Default the max-size ratio to 3/4 and the min-size ratio to 1/4.
    public HashtableB(){
        this(0.75, 0.25);
    }

    // Get the given key.
    public V get(K key){
        assert key != null;

        // Find the key.
        int i = hash(key) % cap;
        while(!key.equals(arr[i].k)){
            i = (i+1) % cap;
        }
        return arr[i]==null? null : arr[i].v; // If there's nothing there, return null. Otherwise, return the value.
    }

    // Sets the given key to the given value.
    public void put(K key, V val){
        assert key != null;
        int i = hash(key) % cap;
        while (arr[i]!=null && !key.equals(arr[i].k)) {
            i = (i+1) % cap;
        }
        if(arr[i] == null) // If we are putting a new key in, increase the size.
            size++;
        arr[i] = new Pair(key, val);

        resize(); // If we need to resize, do so.
    }

    // A hash of the key. I used the absolute value of the key's hashcode so that I didn't get weird negative indices.
    private int hash(K key){
        return Math.abs(key.hashCode());
    }

    // Resize the array if necessary.
    private void resize(){
        if(!((size<cap*min && cap>MIN_CAP) || size>cap*max)){
            return;
        }
        int newcap = (int) (size/set); // The size of the new array

        @SuppressWarnings("unchecked")
        Pair[] a = (Pair[]) Array.newInstance(Pair.class, newcap); // Make the new array

        for(int j=0; j<cap; j++){
            Pair q = arr[j];
            if(q==null)
                continue;

            int i = hash(q.k) % newcap;
            while (a[i]!=null && !q.k.equals(a[i].k)) {
                i = (i+1) % newcap; // get next index
            }
            a[i] = q;
        }
        this.arr = a;
        this.cap = newcap;
    }

    // In here for development purposes only.
    public boolean checkSize(){
        int x = 0;
        for(int i=0; i<cap; i++){
            if(arr[i] != null)
                x++;
        }
        return x == size;
    }

    // Return the number of elements currently contained in this hashtable.
    public int size(){
        return size;
    }

    // Return a list of all the keys currently contained in this hashtable.
    public Set<K> getAll(){
        Set<K> set = new HashSet<K>(size);
        for(Pair p : arr)
            if(p != null)
                set.add(p.k);
        return set;
    }

    // Remove the given key from the hashtable.   
    public void delete(K key){
        assert key != null;
        List<Pair> pairs = new ArrayList<Pair>();

        // Find our key.
        int i = hash(key) % cap;
        while(arr[i]!=null && !key.equals(arr[i].k)){
            i = (i+1) % cap;
            if(arr[i] == null)
                System.out.printf("Delete could not find key %s %n", key.toString());
        }

        // Remove all the keys that could have been "forced over" by this key.
        while(arr[i] != null){
            pairs.add(arr[i]);
            arr[i] = null;
            size--;
            i = (i+1) % cap;
        }

        pairs.remove(0); // Remove the key we're deleting.

        for(Pair p : pairs)
            this.put(p.k, p.v); // Put the rest back in the hashtable.
    }

    public String toString(){
        return String.format("Hashtable(%.2f, %.2f, %.2f)", max, min, set);
    }

    // A key-value pair.
    class Pair{
        K k;
        V v;

        public Pair(K key, V val){
            k = key;
            v = val;
        }
    }
}s