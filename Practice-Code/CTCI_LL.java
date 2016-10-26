public class CTCI_LL {
	Node head = null;
//	public class Node {
//		public int data;
//		public Node next;
//		public Node(int d) {
//			this.data = d;
//		}
//	}
//	
	public void add(int d) {
		Node n = new Node(d);
		n.next = head;
		head = n;
	}
	
	public Node deleteNode1 (int d) {
		Node n = head;
		if (n.data == d) {
			return head.next;
		}
		
		while(n.next!=null) {
			if(n.next.data == d){
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	
	public void deleteNode (int d) {
		Node n = head;
		if (n.data == d) {
			head = head.next;
			return;
		}
		
		while(n.next!=null) {
			if(n.next.data == d){
				n.next = n.next.next;
				return;
			}
			n = n.next;
		}
	}
	
	public void show() {
		Node n = head;
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public void show_fancy() {
		Node n = head;
		while(n != null) {
			if (n.next!=null) System.out.print(n.data + "-->");
			else System.out.println(n.data);
			n = n.next;
		}
	}
}