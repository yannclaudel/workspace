import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        int[] dist = new int[adj.length];
        for (int i = 0; i < dist.length; i++) {
			dist[i]=-1;
		}
        dist[s]=0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        while(!queue.isEmpty()) {
        	int u = queue.pollFirst().intValue();
        	//System.out.println(">> dequeue >>" + u);
        	for (int i = 0; i < adj[u].size(); i++) {
        		int current = adj[u].get(i).intValue();
            	//System.out.println("       current >>" + current);
        		if (dist[current]==-1) {
        			queue.add(current);
        			dist[current]=dist[u]+1;
                	//System.out.println("       add queue >>" + current + " distance " + dist[current]);
        		}				
			}
        	if (dist[t]!=-1) break;
        }
        
        return dist[t];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

