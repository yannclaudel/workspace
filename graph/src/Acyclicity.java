import java.util.ArrayList;
import java.util.Scanner;

class GraphAcy {
	ArrayList<Integer>[] adj = null;
	int n = 0;
	boolean isAcy = true;
	int[] in = null;
	int[] out = null;
	
	public GraphAcy(int n) {
		this.n = n;
		adj = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		in = new int[n];
		out = new int[n];
	}

	public void explore(int x, int[] visited, int[] recStack) {
		

		if (recStack[x] == 1) {
			isAcy=false;
			return;
		}
		if (visited[x]==1) return;
		visited[x] = 1;
		recStack[x] = 1;
		for (int i = 0; i < adj[x].size(); i++) {
			//if (visited[adj[x].get(i).intValue()] != 1)
				explore(adj[x].get(i).intValue(), visited, recStack);
		}
		recStack[x] = 0;
	}

	public void DFS() {
		int[] visited = new int[n];
		int[] recStack = new int[n];
		
		for (int i = 0; i < adj.length; i++) {
			//if (visited[i] != 1) {
				explore(i, visited,recStack);
			//}
		}
	}

	public void print() {
		for (int i = 0; i < adj.length; i++) {
			System.out.println();
			System.out.print((i + 1) + " : ");
			for (int k = 0; k < adj[i].size(); k++) {
				System.out.print(" " + (adj[i].get(k).intValue() + 1));
			}
		}
	}

}

public class Acyclicity {
	private static int acyclic(ArrayList<Integer>[] adj) {
		// write your code here
		return 0;
	}

	public static void main(String[] args) {
		/*
		 * Scanner scanner = new Scanner(System.in); int n = scanner.nextInt(); int m =
		 * scanner.nextInt(); ArrayList<Integer>[] adj = (ArrayList<Integer>[])new
		 * ArrayList[n]; for (int i = 0; i < n; i++) { adj[i] = new
		 * ArrayList<Integer>(); } for (int i = 0; i < m; i++) { int x, y; x =
		 * scanner.nextInt(); y = scanner.nextInt(); adj[x - 1].add(y - 1); }
		 * System.out.println(acyclic(adj));
		 */

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		GraphAcy graph = new GraphAcy(n);
		for (int i = 0; i < m; i++) {
			int x, y;
			x = scanner.nextInt();
			y = scanner.nextInt();
			graph.adj[x - 1].add(y - 1);
			graph.out[x - 1]++;
			graph.in[y - 1]++;
		}

		//graph.print();
		graph.DFS();
		System.out.println((graph.isAcy ? 0 : 1));
	}
}
