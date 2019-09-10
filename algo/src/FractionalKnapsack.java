import java.util.Scanner;

public class FractionalKnapsack {
	private static double getOptimalValue(int capacity, int[] values, int[] weights) {
		double value = 0;
		int n = values.length;
		int w = capacity;
		// write your code here
		double[] vpu = new double[n];
		for (int i = 0; i < n; i++) {
			vpu[i] = 1.0 * values[i] / weights[i];
		}
		while (w > 0) {
			int imax = -1;
			double vpumax = 0;
			for (int i = 0; i < n; i++) {
				if (vpumax < vpu[i]) {
					vpumax = vpu[i];
					imax = i;
				}
			}
			if (imax==-1) break;
			int pick = Math.min(w, weights[imax]);
			w-=pick;
			value+=pick*vpu[imax];
			vpu[imax]=0;
		}
		return value;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int capacity = scanner.nextInt();
		int[] values = new int[n];
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
		}
		System.out.println(getOptimalValue(capacity, values, weights));
	}
}
