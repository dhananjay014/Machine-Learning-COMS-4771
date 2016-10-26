public class HsortPrac{
	int [] pq;
	int N;
	int Nreal;
	
	public HsortPrac(int capacity) {
		pq = new int[capacity+1];
		N = 0;
		Nreal = 0;
	}
	
	public void insert(int k) {
		pq[++N] = k;
		++Nreal;
	}
	
	public void heapbuild() {
		for (int k = N/2; k>=1; k--)
			sink(k,N);
	}
	
	public void sort() {
		while (N>1) {
			exch(1,N--);
			sink(1,N);
		}
	}
	
	public void display() {
		System.out.println("HIII");
		for (int k = 1; k <= Nreal; k++) {
			System.out.println("pq"+k+" is "+ pq[k]);
		}
	}
	
	public void sink(int k, int N) {
		int j;
		while (2*k<=N) {
			if (((2*k)<N) && less(2*k,2*k+1))	j = 2*k+1;
			else 								j = 2*k;
			if (!less(k,j))		break;
			exch(k,j);
			k = j;
		}
	}
	
	public boolean less(int i, int j) {
		return pq[i] < pq[j];
	}
	
	public void exch(int i, int j) {
		int swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
	
	public static void main (String[] args) {
		long starttime = System.currentTimeMillis();
		HsortPrac Hsort1 = new HsortPrac(10);
		System.out.println("Inserting 10");
		Hsort1.insert(30);
		System.out.println("Inserting 20");
		Hsort1.insert(20);
		System.out.println("Inserting 30");
		Hsort1.insert(10);
		System.out.println("Inserting 40");
		Hsort1.insert(50);
		System.out.println("Inserting 50");
		Hsort1.insert(40);
		System.out.println("Building heap");
		Hsort1.heapbuild();
		System.out.println("Sorting heap");
		Hsort1.sort();
		System.out.println("Displaying heap");
		Hsort1.display();
		long endtime = System.currentTimeMillis();
		long totaltime = endtime - starttime;
		System.out.println("The total time is " + totaltime);
	}
}