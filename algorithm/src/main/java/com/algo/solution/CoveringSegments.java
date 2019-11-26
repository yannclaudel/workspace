package com.algo.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CoveringSegments {

	public static int[] optimalPoints(final Segment[] segments) {

		// sort segments in ascending order of right end
		Arrays.sort(segments, Comparator.comparing(Segment::getEnd));

		final ArrayList<Integer> pts = new ArrayList<>();
		Segment segment = null;
		for (int j = 0; j < segments.length; j++) {
			// go to the first segment without a point
			segment = segments[j];
			pts.add(new Integer(segment.getEnd()));
			// search the next segment without a point
			while (j < segments.length - 1 && segments[j + 1].getStart() <= segment.getEnd()) {
				j++;
			}
		}

		return pts.stream().mapToInt(i -> i.intValue()).toArray();
	}
}
