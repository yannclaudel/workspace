package com.graph;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.graph.exercice.BFS;

public class BFSTest {


	@SuppressWarnings("unchecked")
	@Test
	public void testBFS() {
		final int nbrVertex = 10;
		
		List<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[nbrVertex];

		adj[0] = new ArrayList<>(Arrays.asList(1,2));
		adj[1] = new ArrayList<>(Arrays.asList(0,2));
		adj[2] = new ArrayList<>(Arrays.asList(0,1,3,4));
		adj[3] = new ArrayList<>(Arrays.asList(2));
		adj[4] = new ArrayList<>(Arrays.asList(2,5,6,7));
		adj[5] = new ArrayList<>(Arrays.asList(4));
		adj[6] = new ArrayList<>(Arrays.asList(4,8,9));
		adj[7] = new ArrayList<>(Arrays.asList(4));
		adj[8] = new ArrayList<>(Arrays.asList(6));
		adj[9] = new ArrayList<>(Arrays.asList(6));
		
		final int[] dist = BFS.getDistancesFrom(adj, 0);

		assertSame(0,dist[0],"dist[0]==0");
		assertSame(1,dist[1],"dist[1]==1");
		assertSame(2,dist[4],"dist[4]==2");
		assertSame(5,dist[5],"dist[5]==3");
		assertSame(4,dist[8],"dist[8]==4");
		
	}
	
}
