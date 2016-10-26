public class LinkedListST<Key,Value> {
	private Node root;
	
	private class Node {
		private Key key;
		private Value val;
		private Node next;
		
		public Node (Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public LinkedListST() {
		//System.out.println("DJ1");
		root = null;
	}
	
	public boolean isEmpty() {
		return root==null;
	}
	
	public void put(Key key, Value val) {
		Node x = root;
		while (x!=null) {
			if (key.equals(x.key))	{x.val = val; return;}
			else 					x = x.next;
		}
		root = new Node (key,val,root);				// INSERTING IN THE FRONT
	}
	
	public Value get(Key key) {
		Node x = root;
		while (x!=null) {
			if (key.equals(x.key))		return x.val;
			else 						x = x.next;
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("Start of program");
		LinkedListST<String,String> LLST1 = new LinkedListST();
		LLST1.put("A", "Value for A");
		LLST1.put("B", "Value for B");
		LLST1.put("C", "Value for C");
		
		System.out.println("Value of A is " + LLST1.get("A"));
		System.out.println("Value of B is " + LLST1.get("B"));
		System.out.println("Value of C is " + LLST1.get("C"));
		
	}
}