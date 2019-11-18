import java.util.ArrayList;
import java.util.Scanner;

class GraphTopoSort {
	ArrayList<Integer>[] adj = null;
	ArrayList<Integer> order = new ArrayList<Integer>();
	int n = 0;
	int[] in = null;
	int[] out = null;
	int[] prev = null;
	int[] post = null;
	int count = 0;

	public GraphTopoSort(int n) {
		this.n = n;
		adj = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		in = new int[n];
		out = new int[n];
		prev = new int[n];
		post = new int[n];
	}

	public void explore(int x, int[] visited) {
		visited[x] = 1;
		previsit(x);
		for (int i = 0; i < adj[x].size(); i++) {
			if (visited[adj[x].get(i).intValue()] != 1)
				explore(adj[x].get(i).intValue(), visited);
		}
		postvisit(x);
	}

	private void previsit(int x) {
		prev[x] = count;
		count++;
	}

	private void postvisit(int x) {
		post[x] = count;
		order.add(new Integer(x));
		count++;
	}

	public void DFS() {
		int[] visited = new int[n];
		this.count = 1;
		for (int i = 0; i < adj.length; i++) {
			if (visited[i] != 1) {
				explore(i, visited);
			}
		}
	}

	public void print() {
		for (int i = 0; i < adj.length; i++) {
			System.out.println();
			System.out.print((i + 1) + " : prev=" + prev[i] + " post=" + post[i] + " ->");
			for (int k = 0; k < adj[i].size(); k++) {
				System.out.print(" " + (adj[i].get(k).intValue() + 1));
			}
		}
		System.out.println();
		for (int i = order.size() - 1; i > -1; i--) {
			System.out.print(order.get(i) + " -> ");
		}
	}

}

public class Toposort {
	private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
		int used[] = new int[adj.length];
		ArrayList<Integer> order = new ArrayList<Integer>();
		// write your code here
		return order;
	}

	private static void dfs(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order, int s) {
		// write your code here
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		GraphTopoSort graph = new GraphTopoSort(n);
		/*
		 * ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n]; for (int i
		 * = 0; i < n; i++) { adj[i] = new ArrayList<Integer>(); }
		 */
		for (int i = 0; i < m; i++) {
			int x, y;
			x = scanner.nextInt();
			y = scanner.nextInt();
			graph.adj[x - 1].add(y - 1);
			graph.out[x - 1]++;
			graph.in[y - 1]++;
		}
		graph.DFS();
		for (int i = graph.order.size() - 1; i > -1; i--) {
			System.out.print((graph.order.get(i) + 1) + " ");
		}
		// graph.print();
		/*
		 * ArrayList<Integer> order = toposort(graph.adj); for (int x : order) {
		 * System.out.print((x + 1) + " "); }
		 */
	}
}
