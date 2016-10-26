import java.util.HashMap;

public class LLTest{
	public static void main(String[] args) {
		System.out.println("Start");
		CTCI_LL I1 = new CTCI_LL();
		I1.add(5);
		I1.add(10);
		I1.add(15);
		I1.add(15);
		I1.add(15);
		I1.add(10);
		I1.add(10);
		I1.add(20);
		I1.add(15);
		I1.add(5);
		I1.add(40);
		I1.add(10);
		I1.add(40);
		I1.add(80);
		I1.add(80);
		I1.add(40);
		I1.add(30);
		
		
//		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//		for (Node n = I1.head; n!=null; n=n.next) {
//			if (!map.containsKey(n.data))	map.put(n.data,n.data);
//			else	I1.deleteNode(n.data);
//		}
		
		Node current = I1.head;
		while(current!=null) {
			Node runner = current;
			while (runner.next!=null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
		
		I1.show();
		System.out.println("End");
		
	}
	
	
}