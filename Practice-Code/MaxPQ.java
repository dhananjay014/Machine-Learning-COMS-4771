public class MaxPQ <Key extends Comparable<Key>> {
    public Key[] pq;
    public int N = 0;
    public MaxPQ (int capacity) {
        pq = (Key[]) new Comparable [capacity+1];
    }
    
    public void insert (Key x) {
        pq[++N] = x;
        swim(N);
    }
    
    public void swim (int k) {
        while (k > 1 && less(k/2,k)) {
            exch(k/2,k);
            k = k/2;
        }
    }
    
    public void sink (int k) {
        int l;
        while (2*k <= N) {
            if (less(2*k+1,2*k)){
                l = 2*k;
            }
            else{
                l = 2*k+1;
            }
            if (!less(k,l))  break;
            exch(k,l);
            k = l;
        }
    }
    
    public boolean isEmpty() {
        return N==0;
    }
    
    public Key max() {
        return pq[1];
    }
    
    public int size() {
        return pq.length-1;
    }
    
    public Key deleteMax() {
        Key max = pq[1];
        exch(1,N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }
    
    public void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    
    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
        
    public static void main (String[] args) {
        int Size = Integer.parseInt(args[0]);
        MaxPQ PQ = new MaxPQ(Size);
        PQ.insert(10);
        PQ.insert(20);
        PQ.insert(40);
        PQ.insert(30);
        PQ.insert(50);
        System.out.println("The maximum element is " + PQ.max());
        System.out.println("The size of the priority queue is " + PQ.size());
        Comparable j = PQ.deleteMax();
        System.out.println("New maximum is " + PQ.max());
    }
}