public class CTCI_P2_6 {
	public static void main(String[] args) {
		CTCI_LL L1 = new CTCI_LL();
		L1.add(1);
		L1.add(2);
		L1.add(1);
		L1.add(2);
		//L1.add(1);
		CTCI_P2_6 I1 = new CTCI_P2_6();
		boolean palin = I1.palindromeLL(L1);
		System.out.println(palin);
	}	
	
	public boolean palindromeLL(CTCI_LL L1) {
		Node n1 = L1.head;
		Node n2 = L1.head;	
		while (n2!=null) {
			n1 = n1.next;
			if (n2.next == null) {n1 = n1.next; break;}
			else {n2 = n2.next.next;}
		}
		Node new_n1 = L1.head;
		Node new_n2 = n1;
		while (new_n1!=null && new_n2!=null) {
			if(new_n1.data!=new_n2.data) return false;
			else  {
				new_n1 = new_n1.next;
				new_n2 = new_n2.next;
			}
		}
		return true;
	}
}