package com.graph.exercice;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Integer>[] adj = null;
	private int n = 0;
	private int[] group = null;
	private int group_nbr = 0;
	
	public Graph(int n) {
		this.n = n;
		adj = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		group = new int[n];
	}
	public Graph(int n,List<Integer>[] adj) {
		this.n = n;
		this.adj = adj;		
	}

	public boolean isReachable(int x, int y) {
		if (group==null);
			DFS();
		if (group[x] == group[y])
			return true;
		else
			return false;

	}

	private void explore(int x, int[] visited, int group_id) {
		// TODO
	}

	public void DFS() {
		int[] visited = new int[n];
		group = new int[n];
		group_nbr = 0;
		// TODO
		
		
	}
	public List<Integer>[] getAdj() {
		return adj;
	}
	public int getN() {
		return n;
	}
	public int[] getGroup() {
		return group;
	}
	public int getGroup_nbr() {
		return group_nbr;
	}
	
}
