package com.graph.solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BFS {

	public static int[] getDistancesFrom(List<Integer>[] adj, int s) {
		int[] dist = new int[adj.length];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = -1;
		}
		dist[s] = 0;
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(s);
	
		while (!queue.isEmpty()) {
			int u = queue.pollFirst().intValue();
			for (int i = 0; i < adj[u].size(); i++) {
				int current = adj[u].get(i).intValue();
				if (dist[current] == -1) {
					queue.add(current);
					dist[current] = dist[u] + 1;
				}
			}
		}

		return dist;
	}

}
