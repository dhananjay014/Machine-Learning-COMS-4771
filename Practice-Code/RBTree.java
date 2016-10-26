public class RBTree<Key extends Comparable<Key>, Value> {
	public static final boolean RED = true;
	public static final boolean BLACK = false;
	
	private class Node {
		private Key key;
		private Value val;
		private Node left;
		private Node right;
		private int size;
		private boolean color;
		public Node (Key key, Value val, int size, boolean color) {
			this.key = key;
			this.val = val;
			this.size = size;
			this.color = color;
		}
	}
	
	private Node root;
	
	private boolean isRed(Node x) {
		if (x==null)		return false;
		return x.color == RED;
	}
	
	private Node RotateLeft(Node x) {
		Node y = x.right;
		x.right = y.left;
		y.left = x;
		y.color = x.color;
		x.color = RED;
		return y;
	}
	
	private Node RotateRight(Node x) {
		Node y = x.left;
		x.left = y.right;
		y.right = x;
		y.color = x.color;
		x.color = RED;
		return y;
	}
	
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	public RBTree() {		//TESTED
		root = null;
	}
	
	private boolean isEmpty() {		//TESTED
		return root == null;
	}
	
	private void put(Key key, Value val) {		//TESTED
		root = put(root,key,val);
	}
	
	private Node put(Node x, Key key, Value val) {		//TESTED
		if (x==null)	return new Node (key,val,1,RED);
		int cmp = key.compareTo(x.key);
		if (cmp>0)			x.right = put(x.right,key,val);
		else if (cmp<0)		x.left  = put(x.left,key,val);
		else				x.val = val;
		
		if(isRed(x.right) && !isRed(x.left))	   x = RotateLeft(x);
		if(isRed(x.left)  && isRed(x.left.left))   x = RotateRight(x);
		if(isRed(x.right) && isRed(x.left))		   flipColors(x);
		
		x.size = 1+size(x.left)+size(x.right);
		return x;
	}
	
	private Value get(Key key) {		//TESTED
		Node x = root;
		while (x!=null) {
			int cmp = key.compareTo(x.key);
			if (cmp>0)		x = x.right;
			else if (cmp<0)		x = x.left;
			else 			return x.val;
		}
		return null;
	}
	
	private int size(Node x) {
		if (x==null)		return 0;
		else 				return x.size;
	}
	
	private Value min() {		//TESTED
		Node x = min(root);
		return x.val;
	}
	
	private Node min(Node x) {		//TESTED
		if (x.left==null)		return x;
		else 					return min(x.left);
	}
	
	private Value max() {			//TESTED
		Node x = max(root);
		return x.val;
	}
	
	private Node max(Node x) {		//TESTED
		if (x.right == null)	return x;
		else					return max(x.right);
	}
	
	private void deleteMin() {		//TESTED
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x) {		//TESTED
		if (x.left==null)	return x.right;
		x.left = deleteMin(x.left);
		x.size = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	private Value floor(Key key) {			//TESTED
		Node x = floor(root,key);
		if (x==null)		return null;
		else return x.val;
	}
	
	private Node floor(Node x,Key key) {	//TESTED
		if (x==null)		return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0)		return x;
		else if (cmp < 0)	return floor(x.left,key);
		Node t = floor(x.right,key);
		if (t!=null)		return t;
		else 				return x;
	}
	
	private Value ceiling(Key key) {		//TESTED
		Node x = ceiling(root,key);
		if (x==null)		return null;
		return x.val;
	}
	
	private Node ceiling(Node x,Key key) {	//TESTED
		if (x==null)		return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0)		return x;
		else if (cmp > 0)	return ceiling(x.right,key);
		Node t = ceiling(x.left,key);
		if (t!=null)		return t;
		else 				return x;
	}
	
	private int rank(Key key) {
		return rank(root,key);
	}
	
	private int rank(Node x, Key key) {
		if (x==null)		return 0;
		int cmp = key.compareTo(x.key);
		//if (cmp == 0)		return size(x.left);
		//else if (cmp > 0)	return 1+size(x.left) + rank(x.right,key);
		//else				return rank(x.left,key);
		if      (cmp < 0)		return rank(x.left,key);
		else if (cmp > 0)		return 1+size(x.left)+rank(x.right,key);
		else					return size(x.left);
	}
	
//	private void delete (Key key) {
//		root  = delete(root,key);	
//	}
	
//	private Node delete(Node x, Key key) {		//TESTED
//		if (x==null)		return null;
//		int cmp = key.compareTo(x.key);
//		if (cmp>0)	x.right = delete(x.right,key);
//		else if (cmp<0)	x.left = delete(x.left,key);
//		else {
//			if (x.right == null)		return x.left;
//			Node t = x;
//			x = min(t.right);
//			x.right = deleteMin(t.right);
//			x.left = t.left;
//		}	
//		x.size = 1+size(x.left) + size(x.right);
//		return x;
//	}
	
	public static void main(String[] args) {
		long StartTime = System.currentTimeMillis();
		System.out.println("Start of program");
		RBTree<String,String> BST1 = new RBTree<String,String>();
		System.out.println("The tree is empty or not is " + BST1.isEmpty());
		BST1.put("P","//Line number associated with P//");
		System.out.println("The tree is empty or not is " + BST1.isEmpty());
		System.out.println("The value at P is " + BST1.get("P"));
		BST1.put("L", "//Line number associated with L//");
		BST1.put("Z", "//Line number associated with Z//");
		BST1.put("O", "//Line number associated with O//");
		BST1.put("L", "//Line number associated with L again//");
		BST1.put("B", "//Line number associated with B//");
		BST1.put("A", "//Line number associated with A//");
		BST1.put("R", "//Line number associated with R//");
		BST1.put("E", "//Line number associated with E//");
		BST1.put("F", "//Line number associated with F//");
		for (int i = 0; i < 1000000; i++) {
			//String s1 = i;
			BST1.put(Integer.toString(i),"Line number associated with " + Integer.toString(i));
		}
		//System.out.println("The value at B is " + BST1.get("B"));
		//System.out.println("The value at P is " + BST1.get("P"));
		//System.out.println("The value at A is " + BST1.get("A"));
		System.out.println("The maximum value is " + BST1.max());
		System.out.println("The minimum value is " + BST1.min());
		//BST1.deleteMin();
		//System.out.println("The floor of C is " + BST1.floor("C"));
		//System.out.println("The ceiling of C is " + BST1.ceiling("C"));
		System.out.println("The minimum value is " + BST1.min());
		//System.out.println("Deleting E");
		//BST1.delete("E");
		//System.out.println("The ceiling of C is " + BST1.ceiling("C"));
		//System.out.println("Calculating rank for F");
		//System.out.println("The rank for F is " + BST1.rank("F"));
		long EndTime = System.currentTimeMillis();
		long TotalTime = EndTime - StartTime;
		System.out.println("The total time is " + TotalTime);
	}
}