public class QuickSort3way {
	public static void sort(Comparable[] a,int lo, int hi) {
		
		if (hi<=lo) return;
		Comparable v = a[lo];
		int lt = lo;
		int gt = hi;
		//int i = lo;
		for (int i = lo; i <= gt;) {
			if (less(a[i],v))	   exch(a,lt++,i++);
			else if (less(v,a[i])) exch(a,gt--,i);
			else 				       i++;
		}
		
		sort (a,lo,lt-1);
		sort (a,gt+1,hi);
	}
	
	public static void sort (Comparable[] a){
		sort (a,0,a.length-1);
	}
	
	private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
	
	private static boolean less (Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    public static void main (String[] args){
        int N = Integer.parseInt(args[0]);
        Date [] arr = new Date [N];
        int y,m,d;
        for (int k = 0;k < N-2; k++) {
            y = 1000 +(int) ((StdRandom.uniform()*10000)%1000);
            m = 1 + (int) ((StdRandom.uniform()*100)%12);
            d = 1 + (int) ((StdRandom.uniform()*100)%30);
            arr[k] = new Date(m,d,y);
        }
        y = 1000 +(int) ((StdRandom.uniform()*10000)%1000);
        m = 1 + (int) ((StdRandom.uniform()*100)%12);
        d = 1 + (int) ((StdRandom.uniform()*100)%30);
        arr[N-2] = new Date(m,d,y);
        arr[N-1] = new Date(m,d,y);
        sort(arr);
        for (int l = 0; l < N; l++) {
            StdOut.println(arr[l].day+"-"+arr[l].month+"-"+arr[l].year);
        }
    }
 
}