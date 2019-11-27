package com.behavioral.visitor;

public abstract class  Element {
	private String content;
	
	public Element(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public abstract void accept(Visitor visitor);
}
