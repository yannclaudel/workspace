package com.graph.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StronglyConnected {
	private ArrayList<Integer>[] adj = null;
	private List<Integer> order = new ArrayList<>();
	private Set<Set<Integer>> strongConnectComp = new HashSet<>();
	private int nbrVertex = 0;
	private int[] prev = null;
	private int[] post = null;
	private int count = 0;

	public StronglyConnected(final int nbrVertex, ArrayList<Integer>[] adj) {
		this.nbrVertex = nbrVertex;
		prev = new int[nbrVertex];
		post = new int[nbrVertex];
		this.adj = adj;
	}

	@SuppressWarnings("unchecked")
	public StronglyConnected getReverse() {
		ArrayList<Integer>[] reverse = (ArrayList<Integer>[]) new ArrayList[nbrVertex];
		for (int i = 0; i < nbrVertex; i++) {
			reverse[i] = new ArrayList<>();
		}
		for (int i = 0; i < nbrVertex; i++) {
			for (int k = 0; k < adj[i].size(); k++) {
				reverse[adj[i].get(k)].add(i);
			}
		}
		return new StronglyConnected(nbrVertex, reverse);

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

	public void exploreSCC(final int nodeX, int[] visited, final Set<Integer> set) {
		set.add(nodeX);
		visited[nodeX] = 1;
		for (int i = 0; i < adj[nodeX].size(); i++) {
			if (visited[adj[nodeX].get(i).intValue()] != 1) {
				exploreSCC(adj[nodeX].get(i).intValue(), visited, set);
			}
		}
	}

	public void SCC() {
		final int[] visited = new int[nbrVertex];
		final StronglyConnected gReverse = this.getReverse();
		gReverse.DFS();

		final List<Integer> walk = gReverse.order;
		int current = -1;
		for (int i = 0; i < walk.size(); i++) {
			current = walk.get(i);
			if (visited[current] == 0) {
				final Set<Integer> set = new HashSet<>();
				exploreSCC(current, visited, set);
				strongConnectComp.add(set);
			}
		}
	}

	public void DFS() {
		final int[] visited = new int[nbrVertex];
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

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		final int nbrVertex = 13;
		ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[nbrVertex];

		for (int i = 0; i < nbrVertex; i++) {
			adj[i] = new ArrayList<>();
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

		final StronglyConnected graph = new StronglyConnected(nbrVertex, adj);
		graph.DFS();
		graph.print();
		graph.SCC();
		System.out.println(graph.strongConnectComp.size());
	}

}
