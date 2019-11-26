package com.graph;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.graph.exercice.Graph;

public class GraphTest {

	@SuppressWarnings("unchecked")
	@Test
	void testGraph1() {
		int n = 4;
		ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];

		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		adj[0].add(1);
		adj[0].add(3);
		adj[1].add(0);
		adj[1].add(2);
		adj[2].add(1);
		adj[2].add(3);
		adj[3].add(2);
		adj[3].add(0);
		
		Graph graph = new Graph(n,adj);
		graph.DFS();
		assertTrue(graph.isReachable(0, 3));
		assertTrue(graph.getGroup_nbr()==1);

	}
	@SuppressWarnings("unchecked")
	@Test
	void testGraph2() {
		int n = 8;
		List<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
		adj[0] = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2}));
		adj[1] = new ArrayList<Integer>(Arrays.asList(new Integer[]{0,2}));
		adj[2] = new ArrayList<Integer>(Arrays.asList(new Integer[]{0,1,3}));
		adj[3] = new ArrayList<Integer>(Arrays.asList(new Integer[]{2}));
		adj[4] = new ArrayList<Integer>(Arrays.asList(new Integer[]{5}));
		adj[5] = new ArrayList<Integer>(Arrays.asList(new Integer[]{4,6,7}));
		adj[6] = new ArrayList<Integer>(Arrays.asList(new Integer[]{5}));
		adj[7] = new ArrayList<Integer>(Arrays.asList(new Integer[]{5}));
		
		final Graph graph = new Graph(n,adj);
		graph.DFS();
		assertTrue(!graph.isReachable(0, 7));
		assertTrue(graph.isReachable(4, 7));
		assertTrue(graph.getGroup_nbr()==2);
	}

	
}
