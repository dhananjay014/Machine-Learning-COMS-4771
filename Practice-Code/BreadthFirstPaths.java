public class BreadthFirstPaths {
	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;
	private int[] edgeTo;
	private int dist = 1;
	private int[] distTo;
	private int s;
	
	public BreadthFirstPaths(Graph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		bfs(G,s);
	}
	
	private void bfs(Graph G, int s) {
		Queue<Integer> q = new Queue<Integer>();
		for (int v = 0; v < G.V(); v++) {
			distTo[v] = INFINITY;
		}
		distTo[s] = 0;
		q.enqueue(s);
		marked[s] = true;
		while (!q.isEmpty()) {					//taking out all from the queue, till queue is not empty
			int v = q.dequeue();				//taking out one element from the queue
			for (int w : G.adj(v)) {			//iterating through all the adjacent nodes of the source node
				if (!marked[w]) {				//checking if its marked
					distTo[w] = distTo[v] + 1;	//setting the distance
					q.enqueue(w);				//moving the unmarked nodes in the queue
					marked[w] = true;			//marking the node
					edgeTo[w] = v;				//updating the edgeTo list to tell which node is reached through which node
				}
			}								//updating the distance (after all the nodes adjacent from the source node (v or s) are marked) 
		}
	}
	
	private int shortestdistance(int v) {
		return distTo[v];
	}
	
	public static void main(String[] args) {
		System.out.println("Here starts the breadth first paths");
		In in = new In(args[0]);
		Graph G = new Graph(in);
		BreadthFirstPaths BFS = new BreadthFirstPaths(G,4);
		System.out.println(" The shortest distance from 4 to 2 is " + BFS.shortestdistance(2));
	}
}