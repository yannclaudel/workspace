package com.behavioral.visitor;

public interface Visitor {
	void visit(ElementA a);
	void visit(ElementB b);
	void visit(ElementC c);

}
