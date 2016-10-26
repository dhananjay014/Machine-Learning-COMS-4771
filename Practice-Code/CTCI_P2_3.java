public class CTCI_P2_3 {
	public static void main(String[] args) {
		System.out.println("Start of program");
		CTCI_LL LL1 = new CTCI_LL();
		LL1.add(10);
		LL1.add(20);
		LL1.add(30);
		LL1.add(40);
		LL1.add(50);
		
		System.out.println("Before the delete");
		LL1.show();
		
		int i = 0;
		CTCI_P2_3 I1 = new CTCI_P2_3();
		for (Node n=LL1.head; n!=null; n=n.next) {
			i++;
			if (i==4) {
				//System.out.println(n.data);
				I1.deletemiddle(n);
				break;
			}
		}
		System.out.println("After Delete node");
		LL1.show();
	}
	
	public void deletemiddle(Node n1) {
		Node n = n1;
		while(n.next!=null) {
			n.data = n.next.data;
			if (n.next.next == null)	n.next=null;
			else n = n.next;
		}
		n.next=null;
		return;
	}
}