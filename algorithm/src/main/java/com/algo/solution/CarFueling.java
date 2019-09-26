package com.algo.solution;

import java.util.Scanner;

public class CarFueling {
	public static int computeMinRefills(int dist, int tank, int[] stops) {

		int countRefill = 0; // refill counter
		int currentRefillIdx = 0; // current refill index
		int lastRefillIdx = 0; // last refill index
		int n = stops.length; // number max of refill

		// steps = [ 0 , stop1, stop2 , ... stopn, dist]
		int[] steps = new int[stops.length + 2];
		steps[0] = 0;
		steps[n + 1] = dist;
		System.arraycopy(stops, 0, steps, 1, n);

		// while the current refill index is not at the end of steps
		while (currentRefillIdx < n + 1) {
			lastRefillIdx = currentRefillIdx;
			// refill at the farthest reachable step
			while (currentRefillIdx < n + 1 && steps[currentRefillIdx + 1] - steps[lastRefillIdx] <= tank) {
				currentRefillIdx++;
			}
			// currentRefillIdx did not change, next step is unreachable
			if (steps[lastRefillIdx] == steps[currentRefillIdx])
				return -1;
			// if we have not reached the finish , countRefill = countRefill +1
			if (currentRefillIdx < n + 1)
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

		scanner.close();
	}
}
