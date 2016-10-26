public class MaxPQPrac<Key extends Comparable<Key>> {
	public Key[] pq;
	private int N = 0;
	
	public MaxPQPrac(int capacity) {
		pq = (Key[]) new Comparable [capacity+1];
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public void insert(Key k) {
		pq[++N] = k;
		swim(N);
	}
	
	public void swim(int k) {
		while (k>1 && less(k/2,k)) {
			exch(k/2,k);
			k = k/2;
		}
	}
	
//	public void sink(int k) {
//		int j;
//		while (2*k<=N) {
//			j = 2*k;
//			if (j<N && less (j,j+1)) j++;
//			exch(k,j);
//			k = j;
//		}
//	}
	
	public void sink(int k) {
		int j;
		while (2*k<=N) {
			if (((2*k)<N) && less(2*k,2*k+1))	j = 2*k+1;
			else 								j = 2*k;
			if (!less(k,j))		break;
			exch(k,j);
			k = j;
		}
	}
	
	public Key delMax() {
		Key max = pq[1];
		exch(1,N--);
		sink(1);
		pq[N+1] = null;
		return max;
	}
	
	public Key max(){
		return pq[1];
	}
	
	public boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	public void exch(int i, int j) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
	
	public static void main(String[] args) {
		MaxPQPrac PQPrac = new MaxPQPrac(10);
		PQPrac.insert(10);
		PQPrac.insert(50);
		PQPrac.insert(100);
		System.out.println("The maximum element in the PQ is " + PQPrac.max());
		Comparable j = PQPrac.delMax();
		System.out.println("The maximum element in the PQ is " + PQPrac.max());
		j = PQPrac.delMax();
		System.out.println("The maximum element in the PQ is " + PQPrac.max());
	}
}
