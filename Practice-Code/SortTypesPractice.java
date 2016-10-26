public class SortTypesPractice {
	public static void main (String[] args) {
		long startTime = System.currentTimeMillis();
		int N = Integer.parseInt(args[0]);
		Date[] dateString = new Date[N];
		int[] intString = new int[N];
		for (int i = 0; i < N; i++) {
			//Date randomization
			int y = 1000 +(int) ((StdRandom.uniform()*10000)%1000);
            int m = 1 + (int) ((StdRandom.uniform()*100)%12);
            int d = 1 + (int) ((StdRandom.uniform()*100)%30);
            dateString[i] = new Date(m,d,y);
            if (i==2)
            	dateString[++i] = new Date(m,d,y);
            //intString[i] = (int) (StdRandom.uniform()*100)%10;
		}
		
		//selsort(dateString);
		//inssort(dateString);
		//mergesort(dateString);
		//qsort(dateString);
		way3qsort(dateString);
		
		for (int m = 0; m < N; m++) {
			System.out.println(dateString[m].day + "-" + dateString[m].month + "-" + dateString[m].year);
		}
		
		//for (int m = 0; m < N; m++) {
		//	System.out.println(intString[m]);
		//}
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time is "+totalTime);
	}
	
	public static void selsort(Comparable[] a){
		int N = a.length; 
		int index;
		for (int i = 0; i < N; i++) {
			Comparable small = a[i];
			index = i;
			for (int j = i; j < N; j++) {
				if (less(a[j],small)) {
					small = a[j];
					index = j;
				}			
			}
		exch(a,i,index);
		}
	}

	public static void inssort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j],a[j-1])) {
					exch(a,j-1,j);
				}
			}
		}
	}
	
	public static void mergesort (Comparable[] a) {
		Comparable[] aux  = new Comparable[a.length];
		//for (int l = 0; l < a.length; l++) {
		//	aux[l] = a[l];
		//}
		mergesort(a,aux,0,a.length-1);
	}
	
	public static void mergesort (Comparable[] a, Comparable[] aux, int lo, int hi) {
		//System.out.println("Calling mergesort");
		//int mid = lo + (hi-lo)/2;
		//Comparable[] aux = new Comparable[a.length];
		if (hi<=lo)		return;
		int mid  = lo+(hi-lo)/2;
		
		mergesort(a,aux,lo,mid);
		mergesort(a,aux,mid+1,hi);
		merge(a,aux,lo,hi,mid);
	}
	
	public static void merge (Comparable[] a,Comparable[] aux, int lo, int hi, int mid) {
		//Comparable[] aux = new Comparable[a.length];
		//for (int l = 0; l < a.length; l++) {
		//	aux[l] = a[l];
		//}
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		int i = lo;
		int j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if (i>mid)				      a[k] = aux[j++];
			else if (j>hi)			  	  a[k] = aux[i++];
			else if (less(aux[i],aux[j])) a[k] = aux[i++];
			else 					      a[k] = aux[j++];
		}
	}
	
	public static int partition (Comparable[] a, int lo, int hi) {
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
		exch (a,lo,j);
		return j;
	}
	
	public static void qsort(Comparable[] a, int lo, int hi) {
		if (hi<=lo)		return;
		int j = partition(a,lo,hi);
		qsort(a,lo,j-1);
		qsort(a,j+1,hi);
	}
	
	public static void qsort(Comparable[] a) {
		StdRandom.shuffle(a);
		qsort(a,0,a.length-1);
	}
	
	public static Comparable select(Date[] a, int k) {
		StdRandom.shuffle(a);
		int lo = 0;
		int hi = a.length-1;
		while (hi>lo) {
			int j = partition (a,lo,hi);
			if (j < k)		lo = j+1;
			if (j > k) 		hi = j-1;
			else return a[k];
		}
		return a[k];
	}
	
	public static void way3qsort(Comparable[] a, int lo, int hi) {
		if (hi<=lo)		return;
		int lt = lo;
		Comparable v = a[lo];
		int gt = hi;
		int i = lo;
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp<0)			exch(a,lt++,i++);
			else if (cmp>0)		exch(a,i,gt--);
			else			i++;
		}	
		way3qsort(a,lo,lt-1);
		way3qsort(a,gt+1,hi);
	}
	
	public static void way3qsort(Comparable[] a) {
		StdRandom.shuffle(a);
		way3qsort(a,0,a.length-1);
	}
		
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap_holder = a[i];
		a[i] = a[j];
		a[j] = swap_holder;
	}
	
}