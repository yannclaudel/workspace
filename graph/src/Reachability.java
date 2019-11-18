import java.util.ArrayList;
import java.util.Scanner;

class Graph {
	ArrayList<Integer>[] adj = null;
	int n = 0;
	int[] group = null;
	int group_nbr = 0;

	public Graph(int n) {
		this.n = n;
		adj = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		group = new int[n];
	}

	public int isReachable(int x, int y) {
		int[] visited = new int[n];
		group = new int[n];
		explore(x, visited, 1);
		if (group[x] == group[y])
			return 1;
		else
			return 0;

	}
/*
	public int exploreB(int x, int y, int[] visited) {
		visited[x] = 1;
		if (x == y)
			return 1;
		for (int i = 0; i < adj[x].size(); i++) {
			if (visited[adj[x].get(i).intValue()] != 1)
				return exploreB(adj[x].get(i).intValue(), y, visited);
		}
		return 0;
	}
*/
	public void explore(int x, int[] visited, int group_id) {
		visited[x] = 1;
		group[x] = group_id;
		for (int i = 0; i < adj[x].size(); i++) {
			if (visited[adj[x].get(i).intValue()] != 1)
				explore(adj[x].get(i).intValue(), visited, group_id);
		}
	}

	public void DFS() {
		int[] visited = new int[n];
		group_nbr = 0;
		for (int i = 0; i < adj.length; i++) {
			if (visited[i] != 1) {
				group_nbr++;
				explore(i, visited, group_nbr);

			}
		}
	}

}

public class Reachability {

	/*
	 * private static void explore(ArrayList<Integer>[] adj, int x, int y) {
	 * 
	 * }
	 * 
	 * private static int reach(ArrayList<Integer>[] adj, int x, int y) { return
	 * explore(adj, x, y); }
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		// ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
		Graph graph = new Graph(n);
		/*
		 * for (int i = 0; i < n; i++) { adj[i] = new ArrayList<Integer>(); }
		 */
		for (int i = 0; i < m; i++) {
			int x, y;
			x = scanner.nextInt();
			y = scanner.nextInt();
			graph.adj[x - 1].add(y - 1);
			graph.adj[y - 1].add(x - 1);
		}
		int x = scanner.nextInt() - 1;
		int y = scanner.nextInt() - 1;
		System.out.println(graph.isReachable(x, y));
	}
}
