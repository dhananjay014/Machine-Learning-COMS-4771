public class Graph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;			//The adjacency list
	
	
	public Graph(int V) {
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public Graph(In in) {
		this(in.readInt());
		int E = in.readInt();
		if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public int degree(int v) {
		return adj[v].size();
	}
	
	public static void main(String[] args) {
		System.out.println("Graph algorithm starts");
		In in  = new In(args[0]);
		int i = 1;
		Graph G = new Graph(in);
		
		for (int v = 0; v < G.V(); v++)
			for (int w : G.adj(v))
				System.out.println(i++ + ". " + v + " - " + w);
	}
}