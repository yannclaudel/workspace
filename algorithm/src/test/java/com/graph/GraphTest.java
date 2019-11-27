package com.graph;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.graph.exercice.Graph;

public class GraphTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testGraph1() {
		final int nbrVertex = 4;
		ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[nbrVertex];

		for (int i = 0; i < nbrVertex; i++) {
			adj[i] = new ArrayList<>();
		}
		adj[0].add(1);
		adj[0].add(3);
		adj[1].add(0);
		adj[1].add(2);
		adj[2].add(1);
		adj[2].add(3);
		adj[3].add(2);
		adj[3].add(0);
		
		final Graph graph = new Graph(nbrVertex,adj);
		graph.DFS();
		assertTrue(graph.isReachable(0, 3)," 0 and 3 are reachable ");
		assertSame(1,graph.getNbrGroup()==1,"graph.getNbrGroup()==1");

	}
	@SuppressWarnings("unchecked")
	@Test
	public void testGraph2() {
		final int nbrVertex = 8;
		List<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[nbrVertex];
		adj[0] = new ArrayList<>(Arrays.asList(new Integer[]{1,2}));
		adj[1] = new ArrayList<>(Arrays.asList(new Integer[]{0,2}));
		adj[2] = new ArrayList<>(Arrays.asList(new Integer[]{0,1,3}));
		adj[3] = new ArrayList<>(Arrays.asList(new Integer[]{2}));
		adj[4] = new ArrayList<>(Arrays.asList(new Integer[]{5}));
		adj[5] = new ArrayList<>(Arrays.asList(new Integer[]{4,6,7}));
		adj[6] = new ArrayList<>(Arrays.asList(new Integer[]{5}));
		adj[7] = new ArrayList<>(Arrays.asList(new Integer[]{5}));
		
		final Graph graph = new Graph(nbrVertex,adj);
		graph.DFS();
		assertTrue(!graph.isReachable(0, 7)," 0 and 7 are not reachable");
		assertTrue(graph.isReachable(4, 7)," 4 and 7 are reachable");
		assertSame(2,graph.getNbrGroup()==2,"graph.getNbrGroup()==2");
	}

	
}
