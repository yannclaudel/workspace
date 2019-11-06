import java.util.*;
import java.io.*;

public class is_bst {
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

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

		void readInOrder(List<Integer> result,int nodeIdx) {
			if (nodeIdx==-1) return;
			Node node = tree[nodeIdx];
			readInOrder(result, node.left);
			result.add(node.key);
			readInOrder(result, node.right);			
		}
		boolean isBinarySearchTree() {          
			ArrayList<Integer> result = new ArrayList<Integer>();
			readInOrder(result,0);
						
			for (int i = 1; i < result.size(); i++) {
				System.out.println(result.get(i-1)+"<"+result.get(i));
				if (result.get(i-1)>=result.get(i)) return false;
			}
	         return true;
	        }
		
        boolean isBinarySearchTree2(int nodeIdx) {          
          if (nodeIdx<0) return true;
          Node node = tree[nodeIdx];
          if (node.left>-1) {
        	  if (tree[node.left].key>=node.key) return false;
          }
          if (node.right>-1) {
        	  if (tree[node.right].key<node.key) return false;
          }

          return isBinarySearchTree2(node.left) && isBinarySearchTree2(node.right);
        }
        boolean solve() {
            if (tree==null||tree.length==0) return true;
            else return isBinarySearchTree();
          }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.solve()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
