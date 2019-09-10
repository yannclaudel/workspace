package com.behavioral.iterator;

import java.util.HashMap;
import java.util.Iterator;

public class ChainIterator implements Iterator<Link>{

	private HashMap<String, Link> chain = new HashMap<>();
	private String current = null;
	
	public ChainIterator(HashMap<String, Link> chain) {
		super();
		this.chain = chain;
	}

	@Override
	public boolean hasNext() {
		if (current==null || chain.get(current).getNext()!=null)
			return true;
		else 
			return false;		
	}

	@Override
	public Link next() {
		if (current == null) {
			current = "root";
			return chain.get(current);
		}
		else if (chain.get(current).getNext()!=null) {
			Link link = chain.get(current).getNext();
			current = link.getKey();
			return link;
		}
		else 
			return null;
	}


}
