package com.algo.solution;

public class CarFueling {
	public static int computeMinRefills(final int dist, final int tank, final int[] stops) {

		int countRefill = 0; // refill counter
		int currentRefillIdx = 0; // current refill index
		int lastRefillIdx = 0; // last refill index
		final int nbrMaxRefill = stops.length; // number max of refill

		// steps = [ 0 , stop1, stop2 , ... stopn, dist]
		int[] steps = new int[stops.length + 2];
		steps[0] = 0;
		steps[nbrMaxRefill + 1] = dist;
		System.arraycopy(stops, 0, steps, 1, nbrMaxRefill);

		// while the current refill index is not at the end of steps
		while (currentRefillIdx < nbrMaxRefill + 1) {
			lastRefillIdx = currentRefillIdx;
			// refill at the farthest reachable step
			while (currentRefillIdx < nbrMaxRefill + 1 && steps[currentRefillIdx + 1] - steps[lastRefillIdx] <= tank) {
				currentRefillIdx++;
			}
			// currentRefillIdx did not change, next step is unreachable
			if (steps[lastRefillIdx] == steps[currentRefillIdx]) {
				countRefill = -1;
				break;
			}
			// if we have not reached the finish , countRefill = countRefill +1
			if (currentRefillIdx < nbrMaxRefill + 1) {
				countRefill++;
			}
		}
		return countRefill;
	}

}
