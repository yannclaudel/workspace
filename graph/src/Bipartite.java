import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        int[] dist = new int[adj.length];
        int[] color = new int[adj.length];
        boolean bipartite = true;
        for (int i = 0; i < dist.length; i++) {
			dist[i]=-1;
			color[i]=-1;
		}
        int currentColor = 0; 
        dist[0]=0;
        color[0]=currentColor;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while(!queue.isEmpty()) {
        	int u = queue.pollFirst().intValue();
        	//System.out.println(">> dequeue >>" + u);
        	for (int i = 0; i < adj[u].size(); i++) {
        		int current = adj[u].get(i).intValue();
            	//System.out.println("       current >>" + current);
        		if (dist[current]==-1) {
        			queue.add(current);
        			dist[current]=dist[u]+1;
        			color[current]=(color[u]+1)%2;
                	//System.out.println("       add queue >>" + current + " distance " + dist[current]);
        		}else {
        			if (color[current]==color[u])
        				bipartite = false;
        		}				
			}
        }
        
        return (bipartite?1:0);
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
        System.out.println(bipartite(adj));
    }
}

