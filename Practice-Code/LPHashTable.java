public class LPHashTable<Key,Value> {
	int M = 30001;
	public Key[] keys; 
	//= (Key[]) new Object[M];
	public Value[] vals; 
	//= (Value[]) new Object[M];
	
	public int hash(Key key) {
		return key.hashCode() & 0x7fffffff % M;
	}
	
	public LPHashTable() {
		System.out.println("From inside LPHashTable constructor");
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	
	public Value get(Key key) {
		for (int i = hash(key); keys[i]!=null; i = (i+1)%M )
			if (key.equals(keys[i]))
			{	
				System.out.println("yoyoyo the key is " + key + " and index " + i );
				return vals[i];
			}
		return null;				
	}
	
	public void put (Key key, Value val) {
		int i;
		System.out.println("Hash for " + key + " is " + hash(key));
		for (i = hash(key); keys[i]!=null; i = (i+1)%M )
			if (key.equals(keys[i]))
				break;
		keys[i] = key;
		vals[i] = val;			
	}
	
	public static void main(String[] args) {
		LPHashTable<String, String> HT1 = new LPHashTable();
		System.out.println("YAY");
		HT1.put("GAGA", "Value for A");
		System.out.println("The value for GAGA is " + HT1.get("GAGA"));
		HT1.put("GAGA", "Value changed to GAGA");
		System.out.println("The value for GAGA is " + HT1.get("GAGA"));
		HT1.put("A", "Value for A");
		HT1.put("B", "Value for B");
		HT1.put("C", "Value for C");
		HT1.put("D", "Value for D");
		HT1.put("E", "Value for E");
		System.out.println("The value for C is " + HT1.get("C"));
		System.out.println("The value for E is " + HT1.get("E"));

	}
}