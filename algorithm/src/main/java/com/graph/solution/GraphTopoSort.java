package com.graph.solution;

import java.util.ArrayList;
import java.util.List;

public class GraphTopoSort {
	List<Integer>[] adj = null;
	List<Integer> order = new ArrayList<Integer>();
	private int n = 0;
	private int[] prev = null;
	private int[] post = null;
	private int count = 0;

	public GraphTopoSort(int n, List<Integer>[] adj) {
		this.n = n;
		this.adj = adj;
		prev = new int[n];
		post = new int[n];
	}

	public void explore(int x, int[] visited) {
		visited[x] = 1;
		previsit(x);
		for (int i = 0; i < adj[x].size(); i++) {
			if (visited[adj[x].get(i).intValue()] != 1)
				explore(adj[x].get(i).intValue(), visited);
		}
		postvisit(x);
	}

	private void previsit(int x) {
		prev[x] = count;
		count++;
	}

	private void postvisit(int x) {
		post[x] = count;
		order.add(new Integer(x));
		count++;
	}

	public void DFS() {
		int[] visited = new int[n];
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
			System.out.print((order.get(i)+1) + " -> ");
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		int n = 6;
		ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];

		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		adj[0].add(1);
		adj[2].add(1);
		adj[2].add(5);
		adj[4].add(3);
		adj[4].add(1);
		adj[5].add(4);

		GraphTopoSort graph = new GraphTopoSort(n, adj);
		graph.DFS();
		graph.print();
	}

}
