import java.util.*;

import java.io.*;

public class is_bst_hard {
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

		void readInOrder(List<Integer> result,List<String> direction,int nodeIdx,String d) {
			if (nodeIdx==-1) return;
			Node node = tree[nodeIdx];
			readInOrder(result,direction, node.left,"-");
			result.add(node.key);
			direction.add(d);
			readInOrder(result,direction, node.right,"+");			
		}
		
        boolean isBinarySearchTree2(int nodeIdx,long min,long max) {          
            if (nodeIdx<0) return true;
            Node node = tree[nodeIdx];
            //System.out.println("Check :"+min + " < "+ node.key + " <  " + max );
            if (node.key < min || node.key > max) {
            	
            	return false;
            }

            return isBinarySearchTree2(node.left,min,((long)node.key)-1) && isBinarySearchTree2(node.right,(long)node.key,max);
          }

		
		boolean isBinarySearchTree() {          
			ArrayList<Integer> result = new ArrayList<Integer>();
			ArrayList<String> direction = new ArrayList<String>();
			readInOrder(result,direction,0,"+");
			/*for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i)+"\t"+direction.get(i));
			}*/
						
			for (int i = 1; i < result.size(); i++) {
				//System.out.println(result.get(i-1)+"<"+result.get(i));
				if (result.get(i-1).intValue()>result.get(i).intValue()) return false;
				if (result.get(i-1).intValue()==result.get(i).intValue() && "-".equals(direction.get(i-1)) && "+".equals(direction.get(i))) return false;
			}
	         return true;
	        }

        
	       boolean solve() {
	            if (tree==null||tree.length==0) return true;
	            else return isBinarySearchTree2(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
	          }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
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
