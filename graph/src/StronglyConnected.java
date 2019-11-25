import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


class GraphSC {
	ArrayList<Integer>[] adj = null;
	ArrayList<Integer> order = new ArrayList<Integer>();
	Set<Set> SCC = new HashSet<Set>();
	int n = 0;
	int[] in = null;
	int[] out = null;
	int[] prev = null;
	int[] post = null;
	int count = 0;

	public GraphSC(int n,ArrayList<Integer>[] adj) {
		this.n = n;
		in = new int[n];
		out = new int[n];
		prev = new int[n];
		post = new int[n];
		this.adj = adj;
		for (int i = 0; i < n; i++) {
			out[i]=adj[i].size();
			for (int k = 0; k < adj[i].size(); k++) {
				in[adj[i].get(k).intValue()]++;
			}
		}
	}

	public GraphSC(int n) {
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
	
	public GraphSC getReverse() {
		ArrayList<Integer>[] reverse = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++) {
			reverse[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n; i++) {			
			for (int k = 0; k < adj[i].size(); k++) {
				reverse[adj[i].get(k)].add(i);
			}
		}
		return new GraphSC(n,reverse);

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
	public void exploreSCC(int x, int[] visited,Set set) {
		set.add(x);
		visited[x] = 1;
		for (int i = 0; i < adj[x].size(); i++) {
			if (visited[adj[x].get(i).intValue()] != 1)
				exploreSCC(adj[x].get(i).intValue(), visited,set);
		}
	}

	public void SCC() {
		int[] visited = new int[n];
		GraphSC gReverse = this.getReverse();
		gReverse.DFS();		
		//gReverse.print();
		ArrayList<Integer> walk = gReverse.order;
		//for (int i = 0; i < walk.size(); i++)
			//System.out.print(i + " -> ");
		for (int i = 0; i < walk.size(); i++) {
			int current = walk.get(i);
			if(visited[current]==0) {
				Set<Integer> set = new HashSet<Integer>();
				exploreSCC(current, visited,set);
				SCC.add(set);
			}
		}
	}
	public void DFS() {
		int[] visited = new int[n];
		this.count = 1;
		for (int i = 0; i < adj.length; i++) {
			if (visited[i] != 1) {
				explore(i, visited);
			}
		}
		Collections.reverse(order);
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
			System.out.print((order.get(i)+1) + " -> ");
		}
		System.out.println();
	}

}

public class StronglyConnected {
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
    	GraphSC graph = new GraphSC(adj.length,adj);
    	graph.DFS();
    	//graph.print();
    	graph.SCC();
    	
        return graph.SCC.size();
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
        }
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}

