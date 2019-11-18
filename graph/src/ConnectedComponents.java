import java.util.ArrayList;
import java.util.Scanner;

class Graph2 {
	ArrayList<Integer>[] adj = null;
	int n = 0;
	int[] group = null;
	int group_nbr = 0;
	
	public Graph2(int n) {
		this.n = n;
		adj = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		group = new int[n];
	}

	public int isReachable(int x, int y) {

		int[] visited = new int[n];
		return exploreB(x, y, visited);

	}

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

	public void explore(int x, int[] visited, int group_id) {
		visited[x] = 1;
		group[x]= group_id;
		for (int i = 0; i < adj[x].size(); i++) {
			if (visited[adj[x].get(i).intValue()] != 1)
				explore(adj[x].get(i).intValue(), visited,group_id);
		}
	}
	
	public void DFS() {
		int[] visited = new int[n];
		group_nbr = 0;
		for (int i = 0; i < adj.length; i++) {
			if (visited[i] != 1) {
				group_nbr ++;
				explore(i, visited, group_nbr);				
			}
		}
	}
	
}


public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        //write your code here
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Graph2 graph = new Graph2(n);
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            graph.adj[x - 1].add(y - 1);
            graph.adj[y - 1].add(x - 1);
        }
        graph.DFS();
        System.out.println(graph.group_nbr);
    }
}

