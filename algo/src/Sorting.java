import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    public static int[] partition3(int[] a, int l, int r) {
        int m1 = l;
        int m2 = r;
        int[] m = {m1, m2};
        int count = 1;
        //write your code here
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
        	int t = a[i];
            if (t <= x) {
                j++;
                
                a[i] = a[j];
                a[j] = t;
                if (t==x) {
                    int temp = a[j];
                    a[j] = a[l+count];
                    a[l+count] = temp;
                    count++;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            int t = a[l+i];
            a[l+i] = a[j-i];
            a[j-i] = t;			
		}
        m[0] = j-count+1;
        m[1]= j ;
      return m;
    }

    public static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    public static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0]-1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

