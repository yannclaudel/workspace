package com.graph.solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BFS {

	public static int[] getDistancesFrom(final List<Integer>[] adj,final int start) {
		int[] dist = new int[adj.length];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = -1;
		}
		dist[start] = 0;
		final Deque<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		int unqueue = -1;
		int current = -1;
		while (!queue.isEmpty()) {
			unqueue = queue.pollFirst().intValue();
			for (int i = 0; i < adj[unqueue].size(); i++) {
				current = adj[unqueue].get(i).intValue();
				if (dist[current] == -1) {
					queue.add(current);
					dist[current] = dist[unqueue] + 1;
				}
			}
		}

		return dist;
	}

}
