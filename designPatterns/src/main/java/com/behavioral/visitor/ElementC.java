package com.behavioral.visitor;

public class ElementC extends Element {

	public ElementC(String content) {
		super(content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
