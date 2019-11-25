import java.util.ArrayList;
import java.util.Scanner;

public class NegativeCycle {
	private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
		int[] dist = new int[adj.length];
		int[] prev = new int[adj.length];

		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE-1000;
			prev[i] = -1;
		}
		dist[0] = 0;
		int rtn = 0; 
		for (int epoch = 0; epoch < adj.length; epoch++) {
			rtn = 0;
			//System.out.println(">> epoch " + epoch);
			for (int k = 0; k < adj.length; k++) {
				//System.out.println(">>>> k " + k);
				for (int i = 0; i < adj[k].size(); i++) {
					int current = adj[k].get(i).intValue();
					//System.out.println(">>>>>> current " + current + "?" + dist[current] +">"+ dist[k] +"+"+ cost[k].get(i) );
					if (dist[current] > dist[k] + cost[k].get(i)) {
						//System.out.println(">>>>>> current is relax");
						dist[current] = dist[k] + cost[k].get(i);
						prev[current] = k;
						rtn=1;
					}
				}
			}
			System.out.println(">> epoch return" + rtn);
		}
		return rtn;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
		ArrayList<Integer>[] cost = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
			cost[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int x, y, w;
			x = scanner.nextInt();
			y = scanner.nextInt();
			w = scanner.nextInt();
			adj[x - 1].add(y - 1);
			cost[x - 1].add(w);
		}
		System.out.println(negativeCycle(adj, cost));
	}
}
