public class CTCI_P2_2 {
	public static void main(String[] args) {
		CTCI_LL LL1 = new CTCI_LL();
		
		LL1.add(10);
		LL1.add(20);
		LL1.add(30);
		LL1.add(40);
		LL1.add(50);
		LL1.add(60);
		int count = 0;
		int k = 4;
		
		for (Node n = LL1.head; n!=null; n=n.next) {
			count++;
		}
		
		System.out.println("Count is ");
		System.out.println(count);
		System.out.println("Count - k is ");
		System.out.println(count-k);
		
		System.out.println("The link list is");
		for (Node n = LL1.head; n!=null; n = n.next) {
			System.out.println(n.data);
		}
		System.out.println("The link list ends");
		String s1 = new String("hello");
		String s2 = new String(s1);
		int i;
		Node n;
		for (n=LL1.head,i=0; n!=null && i<count ; i++,n=n.next) {
			//System.out.println(i);
			if(i == count-k-1) {
				System.out.println(n.data);
			}
		}
		
		CTCI_P2_2 I1 = new CTCI_P2_2();
		System.out.println("This is D");
		int d = I1.find(LL1.head,count-k-1);
		System.out.println(d);
	}
	
	int find(Node n, int k) {
		if (k==0) return n.data;
		return find(n.next,k-1);
	}
}