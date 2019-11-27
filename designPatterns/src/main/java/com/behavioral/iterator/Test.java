package com.behavioral.iterator;

import java.util.logging.Logger;

public class Test {
	
	private static Logger log = Logger.getLogger(Test.class.getName());
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
		
		for (Link link : chain) {
			log.info(link.getContent());			
		}
		
	}
}
