package com.algo.solution;

import java.util.*;

public class CoveringSegments {

	public static int[] optimalPoints(Segment[] segments) {

		// sort segments in ascending order of right end
		Arrays.sort(segments, Comparator.comparing(Segment::getEnd));

		ArrayList<Integer> pts = new ArrayList<Integer>();

		for (int j = 0; j < segments.length; j++) {
			// go to the first segment without a point
			Segment segment = segments[j];
			pts.add(new Integer(segment.getEnd()));
			// search the next segment without a point
			while (j < segments.length - 1 && segments[j + 1].getStart() <= segment.getEnd()) {
				j++;
			}
		}

		int[] points = pts.stream().mapToInt(i -> i.intValue()).toArray();

		return points;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Segment[] segments = new Segment[n];
		for (int i = 0; i < n; i++) {
			int start, end;
			start = scanner.nextInt();
			end = scanner.nextInt();
			segments[i] = new Segment(start, end);
		}
		int[] points = optimalPoints(segments);
		System.out.println(points.length);
		for (int point : points) {
			System.out.print(point + " ");
		}

		scanner.close();
	}
}
