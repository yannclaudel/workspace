import java.util.*;
import java.io.*;

public class tree_orders {
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

	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}
		
		void readInOrder(List<Integer> result,int node) {
			if (node==-1) return;
			
			readInOrder(result, left[node]);
			result.add(key[node]);
			readInOrder(result, right[node]);			
		}
		
		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			readInOrder(result,0);
			return result;
		}
		
		void readPreOrder(List<Integer> result,int node) {
			if (node==-1) return;
			result.add(key[node]);
			readPreOrder(result, left[node]);
			readPreOrder(result, right[node]);			
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			readPreOrder(result,0);
                
			return result;
		}
		void readPostOrder(List<Integer> result,int node) {
			if (node==-1) return;
			readPostOrder(result, left[node]);
			readPostOrder(result, right[node]);
			result.add(key[node]);
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			readPostOrder(result,0);
                        
			return result;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
