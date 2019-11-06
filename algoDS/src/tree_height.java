import java.util.*;

import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
    public class Node {
    	int data;
    	int level;
    	List<Node> children = new ArrayList<Node>();
    	
    }
	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight() {
			Node[] nodes = new Node[n]; 
			Node root = null;
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node();
				nodes[i].data = i;
			}
			for (int i = 0; i < n; i++) {
				if (parent[i]==-1) root = nodes[i];
				else nodes[parent[i]].children.add(nodes[i]);
			}
			
                        // Replace this code with a faster implementation
			int maxHeight = 0;
			Deque<Node> q = new ArrayDeque<>();
			if (root!=null) {
				q.addLast(root);maxHeight=1;root.level=1;
			}
			while(!q.isEmpty()) {
				Node head = q.poll();
				//System.out.println(head.data+"\t"+head.level);
				if (!head.children.isEmpty()) {
					for (Node child : head.children) {
						child.level=head.level+1;
						if (child.level>maxHeight) maxHeight = child.level;
						q.addLast(child);
					}
				}
			}
			/*
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}*/
			return maxHeight;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
