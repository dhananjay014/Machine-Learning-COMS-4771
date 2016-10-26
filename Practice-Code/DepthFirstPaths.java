public class DepthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public DepthFirstPaths(Graph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		dfs(G,s);
	}
	
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G,w);
				edgeTo[w] = v;
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
	
	public static void main(String[] args) {
		System.out.println("Here starts the DepthFirstPaths");
		In in = new In(args[0]);
		Graph G = new Graph(in);
		
		DepthFirstPaths DFP = new DepthFirstPaths(G,4);
		System.out.println("The path from 4 to 2 is");
		for (int i : DFP.pathTo(2))
				System.out.print(i + "-");
		System.out.print("End");
	}
}