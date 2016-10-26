public class SeqSearST<Key, Value> {
	
	Node root;
	
	public SeqSearST () {
		root = null;
	}
	
	public class Node {
		private Key key;
		private Value val;
		private Node next;
		
		public Node(Key key, Value val, Node x) {
			this.key = key;
			this.val = val;
			this.next = x;
		}
		
	}
}