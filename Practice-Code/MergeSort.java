public class MergeSort {
    private static void merge (Comparable[] a, Comparable[] aux, int hi, int lo, int mid) {
        assert isSorted(a,lo,mid);
        assert isSorted(a,mid+1,hi);
        int i = lo;
        int j = mid+1;
        
        for (int k = 0; k < a.length; k++) {
            aux[k]
        }
        
        for (int k = lo; k < hi; k++) {
            if (i>mid)                          a[k] = aux[j++];
            else if(j>hi)                       a[k] = aux[i++];
            else if (less(aux[i],aux[j]))       a[k] = aux[i++];
            else                                a[k] = aux[j++];
        }
        assert isSorted(a,lo,hi);
    }
    
    private static void sort (Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi<=lo)     return;
        int mid  = lo+ (hi-lo)/2;
        
        sort (a,aux,lo,mid);
        sort (a,aux,mid+1,hi);
        merge(a,aux,hi,lo,mid);
    }
    
    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux  = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }
        
        sort (a,aux,0,a.length-1);
    }
    
    public static boolean isSorted(Comparable[] a, int i, int j) {
        for (int k = i+1; k < j; k++) {
            if (less(a[i],a[i-1])) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean less (Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    public static void main (String[] args){
        int N = Integer.parseInt(args[0]);
        Date [] arr = new Date [N];
        for (int k = 0;k < N; k++) {
            int y = 1000 +(int) ((StdRandom.uniform()*10000)%1000);
            int m = 1 + (int) ((StdRandom.uniform()*100)%12);
            int d = 1 + (int) ((StdRandom.uniform()*100)%30);
            arr[k] = new Date (m,d,y);
        }
        sort(arr);
        for (int l = 0; l < N; l++) {
            StdOut.println(arr[l].day+"-"+arr[l].month+"-"+arr[l].year);
        }
    }
    
    
}