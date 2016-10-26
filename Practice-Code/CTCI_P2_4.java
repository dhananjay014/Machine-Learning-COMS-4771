public class CTCI_P2_4 {
	public static void main(String[] args) {
		CTCI_LL L1 = new CTCI_LL();
		CTCI_LL L2 = new CTCI_LL();
		L1.add(1);
		L1.add(2);
		L1.add(10);
		L1.add(5);
		L1.add(8);
		L1.add(5);
		L1.add(3);
		int p = 8;
		for (Node n1 = L1.head; n1 != null;) {
			if (n1.data >= p) {
				int data = n1.data; 
				L2.add(data);
				n1 = n1.next;
				L1.deleteNode(data);
			} else {
				n1 = n1.next;
			}
		}
		
		Node n2 = L1.head;
		while(n2.next!=null) {
			n2 = n2.next;
		}
		n2.next = L2.head;
		L1.show();
	}
}