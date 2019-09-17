package com.behavioral.visitor;

public class ElementA extends Element {

	public ElementA(String content) {
		super(content);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
