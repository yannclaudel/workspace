package com.graph.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphTopoSort {
	private List<Integer>[] adj = null;
	private List<Integer> order = new ArrayList<>();
	private int nbrVertex = 0;
	private int[] prev = null;
	private int[] post = null;
	private int count = 0;

	public GraphTopoSort(final int nbrVertex,final List<Integer>[] adj) {
		this.nbrVertex = nbrVertex;
		this.adj = Arrays.copyOf(adj, adj.length);;
		prev = new int[nbrVertex];
		post = new int[nbrVertex];
	}

	public void explore(final int nodeX, int[] visited) {
		visited[nodeX] = 1;
		previsit(nodeX);
		for (int i = 0; i < adj[nodeX].size(); i++) {
			if (visited[adj[nodeX].get(i).intValue()] != 1) {
				explore(adj[nodeX].get(i).intValue(), visited);
			}
		}
		postvisit(nodeX);
	}

	private void previsit(final int nodeX) {
		prev[nodeX] = count;
		count++;
	}

	private void postvisit(final int nodeX) {
		post[nodeX] = count;
		order.add(new Integer(nodeX));
		count++;
	}

	public void DFS() {
		final int[] visited = new int[nbrVertex];
		this.count = 1;
		for (int i = 0; i < adj.length; i++) {
			if (visited[i] != 1) {
				explore(i, visited);
			}
		}
	}

	public void print() {
		for (int i = 0; i < adj.length; i++) {
			System.out.println();
			System.out.print((i + 1) + " : prev=" + prev[i] + " post=" + post[i] + " ->");
			for (int k = 0; k < adj[i].size(); k++) {
				System.out.print(" " + (adj[i].get(k).intValue() + 1));
			}
		}
		System.out.println();
		for (int i = order.size() - 1; i > -1; i--) {
			System.out.print((order.get(i) + 1) + " -> ");
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(final String... args) {

		final int nbrVertex = 6;
		ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[nbrVertex];

		for (int i = 0; i < nbrVertex; i++) {
			adj[i] = new ArrayList<>();
		}
		adj[0].add(1);
		adj[2].add(1);
		adj[2].add(5);
		adj[4].add(3);
		adj[4].add(1);
		adj[5].add(4);

		final GraphTopoSort graph = new GraphTopoSort(nbrVertex, adj);
		graph.DFS();
		graph.print();
	}

}
