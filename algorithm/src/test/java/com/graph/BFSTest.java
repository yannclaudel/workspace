package com.graph;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.graph.exercice.BFS;

public class BFSTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testBFS() {
		int n = 10;
		List<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];

		adj[0] = new ArrayList<Integer>(Arrays.asList(1,2));
		adj[1] = new ArrayList<Integer>(Arrays.asList(0,2));
		adj[2] = new ArrayList<Integer>(Arrays.asList(0,1,3,4));
		adj[3] = new ArrayList<Integer>(Arrays.asList(2));
		adj[4] = new ArrayList<Integer>(Arrays.asList(2,5,6,7));
		adj[5] = new ArrayList<Integer>(Arrays.asList(4));
		adj[6] = new ArrayList<Integer>(Arrays.asList(4,8,9));
		adj[7] = new ArrayList<Integer>(Arrays.asList(4));
		adj[8] = new ArrayList<Integer>(Arrays.asList(6));
		adj[9] = new ArrayList<Integer>(Arrays.asList(6));
		
		int[] dist = BFS.getDistancesFrom(adj, 0);

		assertTrue(dist[0]==0);
		assertTrue(dist[1]==1);
		assertTrue(dist[4]==2);
		assertTrue(dist[5]==3);
		assertTrue(dist[8]==4);
	}
	
}
