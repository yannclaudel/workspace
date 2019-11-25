import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Dijkstra {

/**
 * 
 * @param adj
 * @param cost
 * @param s
 * @param t
 * @return
 */
	private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        int[] dist = new int[adj.length];
        int[] prev = new int[adj.length];
        //boolean[] view = new boolean[adj.length];
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < dist.length; i++) {
        	dist[i]=Integer.MAX_VALUE-1000;
			prev[i]=-1;
			set.add(i);
		}
        dist[s]=0;
        
		while(!set.isEmpty()) {
			int pop=-1;
			for (Integer integer : set) {
				if (pop==-1||dist[pop]>dist[integer.intValue()]) 
					pop=integer.intValue();
			}
			set.remove(pop);
			for (int i = 0; i < adj[pop].size(); i++) {
        		int current = adj[pop].get(i).intValue();
        		
        		if (dist[current]>dist[pop]+cost[pop].get(i)) {
        			dist[current] = dist[pop]+cost[pop].get(i);
        			prev[current]=pop;
        			
        		}
        	}
		}
		
		return (dist[t]==Integer.MAX_VALUE-1000?-1:dist[t]);
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
		int x = scanner.nextInt() - 1;
		int y = scanner.nextInt() - 1;
		System.out.println(distance(adj, cost, x, y));
	}
}
