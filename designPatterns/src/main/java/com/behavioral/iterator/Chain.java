package com.behavioral.iterator;

import java.util.HashMap;
import java.util.Iterator;

public class Chain implements Iterable<Link>{
	
	private HashMap<String, Link> chain = new HashMap<>();
	private String last = null;
	
	@Override
	public Iterator<Link> iterator() {		
		return new ChainIterator(chain);
	}
	
	public void add(Link link) {
		if (chain.isEmpty()) {
			chain.put("root", link);
			last = "root";
		}else {
			chain.get(last).setNext(link);
			chain.put(link.getKey(), link);
			last=link.getKey();
		}
	}
	
}
