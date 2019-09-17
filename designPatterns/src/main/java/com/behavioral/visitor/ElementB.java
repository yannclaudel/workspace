package com.behavioral.visitor;

public class ElementB extends Element {

	public ElementB(String content) {
		super(content);
}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
