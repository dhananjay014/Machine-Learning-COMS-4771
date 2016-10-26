public class SCHashTable<Key, Value> {
	private int M = 97;
	private LinkedListST<Key,Value>[] ST;
	
	public SCHashTable() {
		ST = new LinkedListST[M];
		for (int i = 0; i < M; i++) {
			ST[i] = new LinkedListST();
		}
	}
	
	public int hash(Key key) {
		return key.hashCode() & 0x7fffffff % M;
	}
	
	public void put(Key key, Value val) {
		int i = hash(key);
		System.out.println("The hash for " + key + " is " + hash(key));
		ST[i].put(key,val);
	}
	
	public Value get (Key key) {
		int i = hash(key);
		return ST[i].get(key);
	}
	
	public static void main (String[] args) {
		System.out.println("Start of Program");
		SCHashTable<String,String> SCHT1 = new SCHashTable();
		SCHT1.put("A", "Value for A");
		SCHT1.put("B", "Value for B");
		SCHT1.put("C", "Value for C");
		SCHT1.put("D", "Value for D");
		SCHT1.put("E", "Value for E");
		SCHT1.put("C", "Value for C again");
		
		System.out.println("The value at A is " + SCHT1.get("A"));
		System.out.println("The value at B is " + SCHT1.get("B"));
		System.out.println("The value at C is " + SCHT1.get("C"));
		System.out.println("The value at D is " + SCHT1.get("D"));
		System.out.println("The value at E is " + SCHT1.get("E"));
	}	
}