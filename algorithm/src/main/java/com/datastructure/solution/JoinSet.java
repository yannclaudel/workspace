package com.datastructure.solution;

import java.util.Arrays;

/**
 * 
 * @author YannCLAUDEL
 *
 */
public class JoinSet {
	private int[] parent = null;
	private int[] rank = null;

	public JoinSet(int nbrOfElement) {
		super();
		this.parent = new int[nbrOfElement];
		this.rank = new int[nbrOfElement];
		for (int i = 0; i < parent.length; i++) {
			parent[i]=i;
			rank[i]=0;
		}
	}
	
	public int findWithPathCompression(int i) {
		if (i!=parent[i]) {
			parent[i]=findWithPathCompression(parent[i]);
		}
		return parent[i];
	}
	
	
	public int find(int i) {
		while(i!=parent[i]) {
			i=parent[i];
		}		
		return i;
	}
	
	public void union(int i,int j) {
		final int iid= find(i);
		final int jid= find(j);
		if (iid==jid) return;
		if (rank[iid]>rank[jid]) {
			parent[jid]=iid;
		}else {
			parent[iid]=jid;
			if (rank[iid]==rank[jid]) {
				rank[jid]++;
			}
		}
			
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "JoinSet [parent="
				+ (parent != null ? Arrays.toString(Arrays.copyOf(parent, Math.min(parent.length, maxLen))) : null)
				+ ", rank="
				+ (rank != null ? Arrays.toString(Arrays.copyOf(rank, Math.min(rank.length, maxLen))) : null) + "]";
	}
	
	public static void main(String[] args) {
		final JoinSet js = new JoinSet(10);
		System.out.println(js.toString());
		js.union(0, 9);
		js.union(1, 2);
		System.out.println(js.toString());
		js.union(1, 3);
		System.out.println(js.toString());
		System.out.println(js.findWithPathCompression(1));
		js.union(0, 8);
		System.out.println(js.toString());
		js.union(0, 1);
		System.out.println(js.toString());
		js.findWithPathCompression(1);
		System.out.println(js.toString());
	}
}
