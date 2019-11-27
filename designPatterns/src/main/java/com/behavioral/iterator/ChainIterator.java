package com.behavioral.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChainIterator implements Iterator<Link> {

	private Map<String, Link> chain = new HashMap<>();
	private String current = null;

	public ChainIterator(Map<String, Link> chain) {
		super();
		this.chain = chain;
	}

	@Override
	public boolean hasNext() {
		return current == null || chain.get(current).getNext() != null;
	}

	@Override
	public Link next() {
		Link link = null;
		if (current == null) {
			current = "root";
			link = chain.get(current);
		} else if (chain.get(current).getNext() != null) {
			link = chain.get(current).getNext();
			current = link.getKey();

		}
		return link;
	}

}
