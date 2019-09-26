package com.algo.exercice;

import java.util.*;

import com.algo.solution.Segment;

public class CoveringSegments {

	public static int[] optimalPoints(Segment[] segments) {
		return null;
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
