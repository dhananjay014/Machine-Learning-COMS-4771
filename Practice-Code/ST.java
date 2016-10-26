public class ST<Key extends Comparable <Key>, Value> {
	public ST();
	public void put(Key key, Value val);
	public Value get(Key key);
	public boolean contains(Key key);
	public boolean isEmpty();
	public Value floor(Key key);
	public Value ceiling(Key key);
	public Value rank(Key key);
	public Value max();
	public Value min();
	
}