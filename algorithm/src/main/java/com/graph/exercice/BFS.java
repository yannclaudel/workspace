package com.graph.exercice;

import java.util.List;

public class BFS {

	public static int[] getDistancesFrom(final List<Integer>[] adj,final int start) {
		int[] dist = new int[adj.length];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = -1;
		}
		dist[start] = 0;
		// TODO
		return dist;
	}

}
