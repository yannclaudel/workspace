package com.graph.exercice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kruskal{
	
	public class Edge implements Comparable<Edge>{
		public int vertex1;
		public int vertex2;

		public int vertex1X;
		public int vertex1Y;
		
		public int vertex2X;
		public int vertex2Y;
		
		private double distance = -1;
		public Edge(int vertex1, int vertex2, int vertex1x, int vertex1y, int vertex2x, int vertex2y) {
			super();
			this.vertex1 = vertex1;
			this.vertex2 = vertex2;
			vertex1X = vertex1x;
			vertex1Y = vertex1y;
			vertex2X = vertex2x;
			vertex2Y = vertex2y;
			distance = Math.sqrt((double)((vertex1x-vertex2x)*(vertex1x-vertex2x)+(vertex1y-vertex2y)*(vertex1y-vertex2y)));
		}
		@Override
		public int compareTo(Edge edge) {
			if (this.distance<edge.getDistance())
				return -1;
			else if (this.distance>edge.getDistance())
				return 1;
			return 0;
		}
		public double getDistance() {
			return distance;
		}
		@Override
		public String toString() {
			return "Edge [vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", vertex1X=" + vertex1X + ", vertex1Y="
					+ vertex1Y + ", vertex2X=" + vertex2X + ", vertex2Y=" + vertex2Y + ", distance=" + distance + "]";
		}
		
				
	}
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

		
		}
	
    private static Set<Edge> findMinimalTotalWeightConnectedGraph(int[] x, int[] y) {
        List<Edge> edges = new ArrayList<>();
        final JoinSet js = new Kruskal().new JoinSet(y.length);
        Set<Edge> resultSet = new HashSet<>();
        for (int i = 0; i < y.length - 1; i++) {
        	for (int j = i+1; j < y.length; j++) {
    			edges.add(new Kruskal().new Edge(i, j, x[i], y[i], x[j], y[j]));
    		}
		}
        Collections.sort(edges);
        for (int i = 0; i < edges.size(); i++) {
        	Edge current =edges.get(i);
        	if (js.find(current.vertex1)!=js.find(current.vertex2)) {
        		resultSet.add(current);
        		js.union(current.vertex1, current.vertex2);
        	}
        	
		}
        return resultSet;
    }

    public static void main(String[] args) {
        int[] x = new int[] {0,0,1,1};
        int[] y = new int[] {0,1,0,1};
        Set<Edge> result = findMinimalTotalWeightConnectedGraph(x, y);
        for (Edge edge : result) {
			System.out.println(edge.toString());
		}
        
        System.out.println("**************************");
        
        x = new int[] {0,0,1,3,3};
        y = new int[] {0,2,1,0,2};
        result = findMinimalTotalWeightConnectedGraph(x, y);
        for (Edge edge : result) {
			System.out.println(edge.toString());
		}

        
    }
}

