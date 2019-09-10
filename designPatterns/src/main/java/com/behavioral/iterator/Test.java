package com.behavioral.iterator;

import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		Chain chain = new Chain();
		Link Z = new Link("Z");
		chain.add(Z);
		Link B = new Link("B");
		chain.add(B);
		Link Q = new Link("Q");
		chain.add(Q);
		Link D = new Link("D");
		chain.add(D);
		
		for (Iterator<Link> iterator = chain.iterator(); iterator.hasNext();) {
			Link link = (Link) iterator.next();
			System.out.println(link.getContent());			
		}
		
	}
}
