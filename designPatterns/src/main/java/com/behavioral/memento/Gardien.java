package com.behavioral.memento;

import java.util.LinkedList;
import java.util.List;

public class Gardien {
	private List<Memento> list = new LinkedList<>();

	public void addMemento(Memento pMemento) {
		list.add(pMemento);
	}

	public Memento getMemento(int pIndex) {
		return list.get(pIndex);
	}
	
	public int getLastIndex() {
		return list.size()-1;
	}
}
