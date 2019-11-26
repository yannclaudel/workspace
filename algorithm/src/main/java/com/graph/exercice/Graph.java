package com.graph.exercice;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Integer>[] adj = null;
	private int nbrVertex = 0;
	private int[] group = null;
	private int nbrGroup = 0;

	@SuppressWarnings("unchecked")
	public Graph(final int nbrVertex) {
		this.nbrVertex = nbrVertex;
		adj = new ArrayList[nbrVertex];
		for (int i = 0; i < nbrVertex; i++) {
			adj[i] = new ArrayList<>();
		}
		group = new int[nbrVertex];
	}

	public Graph(final int nbrVertex, final List<Integer>[] adj) {
		this.nbrVertex = nbrVertex;
		this.adj = adj;
	}

	public boolean isReachable(final int nodeX, final int nodeY) {
		if (group == null) {
			DFS();
		}
		return group[nodeX] == group[nodeY];
	}

	private void explore(final int nodeX, int[] visited, final int groupId) {
		// TODO
	}

	public void DFS() {
		final int[] visited = new int[nbrVertex];
		group = new int[nbrVertex];
		nbrGroup = 0;
		// TODO
	}

	public List<Integer>[] getAdj() {
		return adj;
	}

	public int getN() {
		return nbrVertex;
	}

	public int[] getGroup() {
		return group;
	}

	public int getNbrGroup() {
		return nbrGroup;
	}

}
