import java.util.*;
import java.io.*;

public class CarFueling {
	static int computeMinRefills(int dist, int tank, int[] stops) {

		int countRefill = 0;
		int currentRefill = 0;
		int lastRefill = 0;
		int n = stops.length;
		int[] steps = new int[stops.length + 2];
		steps[0] = 0;
		steps[n + 1] = dist;
		System.arraycopy(stops, 0, steps, 1, n);

		while (currentRefill < n +1) {
			lastRefill = currentRefill;

			while (currentRefill < n + 1 && steps[currentRefill + 1] - steps[lastRefill] <= tank) {
				currentRefill++;
			}
			//System.out.println(lastRefill+"="+steps[lastRefill]+" "+currentRefill+"="+steps[currentRefill]);
			if (steps[lastRefill] == steps[currentRefill])
				return -1;
			if (currentRefill < n + 1)
				countRefill++;
		}
		return countRefill;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dist = scanner.nextInt();
		int tank = scanner.nextInt();
		int n = scanner.nextInt();
		int stops[] = new int[n];
		for (int i = 0; i < n; i++) {
			stops[i] = scanner.nextInt();
		}

		System.out.println(computeMinRefills(dist, tank, stops));
	}
}
