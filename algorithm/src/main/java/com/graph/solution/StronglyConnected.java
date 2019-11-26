package com.graph.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StronglyConnected {
	ArrayList<Integer>[] adj = null;
	ArrayList<Integer> order = new ArrayList<Integer>();
	Set<Set<Integer>> SCC = new HashSet<Set<Integer>>();
	int n = 0;
	int[] prev = null;
	int[] post = null;
	int count = 0;

	public StronglyConnected(int n, ArrayList<Integer>[] adj) {
		this.n = n;
		prev = new int[n];
		post = new int[n];
		this.adj = adj;
	}

	public StronglyConnected getReverse() {
		ArrayList<Integer>[] reverse = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++) {
			reverse[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < adj[i].size(); k++) {
				reverse[adj[i].get(k)].add(i);
			}
		}
		return new StronglyConnected(n, reverse);

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

	public void exploreSCC(int x, int[] visited, Set set) {
		set.add(x);
		visited[x] = 1;
		for (int i = 0; i < adj[x].size(); i++) {
			if (visited[adj[x].get(i).intValue()] != 1)
				exploreSCC(adj[x].get(i).intValue(), visited, set);
		}
	}

	public void SCC() {
		int[] visited = new int[n];
		StronglyConnected gReverse = this.getReverse();
		gReverse.DFS();
		// gReverse.print();
		ArrayList<Integer> walk = gReverse.order;
		// for (int i = 0; i < walk.size(); i++)
		// System.out.print(i + " -> ");
		for (int i = 0; i < walk.size(); i++) {
			int current = walk.get(i);
			if (visited[current] == 0) {
				Set<Integer> set = new HashSet<Integer>();
				exploreSCC(current, visited, set);
				SCC.add(set);
			}
		}
	}

	public void DFS() {
		int[] visited = new int[n];
		this.count = 1;
		for (int i = 0; i < adj.length; i++) {
			if (visited[i] != 1) {
				explore(i, visited);
			}
		}
		Collections.reverse(order);
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
		System.out.println();
	}

	public static void main(String[] args) {

		int n = 13;
		ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];

		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		adj[0].add(1);
		adj[1].add(2);
		adj[2].add(5);
		adj[5].add(4);
		adj[4].add(1);
		adj[4].add(3);

		adj[5].add(8);
		adj[8].add(7);
		adj[7].add(6);
		adj[7].add(9);
		adj[9].add(8);
		adj[8].add(10);
		adj[10].add(11);
		adj[11].add(12);
		adj[12].add(10);

		StronglyConnected graph = new StronglyConnected(n, adj);
		graph.DFS();
		graph.print();
		graph.SCC();
		System.out.println(graph.SCC.size());
	}

}
