public class HeapSort {
    //public Key[] pq;
    
    public static void sort(Comparable[] pq) {
        int N = pq.length;
        //System.out.println("In sort the size is " + N);
        for (int k = N/2; k >= 1; k--)
        {
        //    System.out.println("The value of k in this iteration is " + k);
            sink(pq,k,N);
        }
        while (N>1) {
            exch(pq,1,N--);
            sink(pq,1,N);
        }
    }
    
    public static void show(Comparable[] pq) {
        int N = pq.length;
        for (int k = 1; k <=N ; k++)
        	{System.out.println("haha");
            System.out.println(pq[k-1]);}
    }
    
    private static void sink (Comparable[] pq, int k, int N) {
        //int l;
        //System.out.println("Start of sink");
        //System.out.println("Value of k is " + k + " And N is " + N);
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less (pq,j,j+1))    j++;
            if (!less(pq,k,j))              break;
            exch(pq,k,j);
            k = j;
            //if (less(pq,2*k, 2*k+1)) {l = 2*k+1;}
            //else                     {l = 2*k;}
            //if (less(pq,l,k))        { break;}       
            //exch(pq,k,l);
            //k = l;
        }
    }
    
    private static void exch (Comparable[] pq, int i, int j) {
        Comparable swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
    
    //public static void insert (Comparable[] pq, Comparable x) {
    //    int N = pq.length;
    //    pq[++N] = x;
    //}
    
    public static boolean less (Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }
    
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        //System.out.println("The array size is " + a.length);
        sort(a);
        show(a);
    }
}