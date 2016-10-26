public class QuickSort{
	public static void sort(Comparable[] a){
		sort(a,0,a.length-1);
	}
	
	private static int partition (Comparable[] a, int lo, int hi){
		int i = lo;
		int j = hi+1;
		while (true) {
			while (less(a[++i],a[lo]))
			
			if (i==hi) break;
			
			while (less(a[lo],a[--j]))
				
			if (j==lo) break;
			
			if (i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (lo>=hi) return;
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	private static boolean less (Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
	
    public static void main (String[] args){
        int N = Integer.parseInt(args[0]);
        Date [] arr = new Date [N];
        for (int k = 0;k < N; k++) {
            int y = 1000 + (int) ((StdRandom.uniform()*10000)%1000);
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