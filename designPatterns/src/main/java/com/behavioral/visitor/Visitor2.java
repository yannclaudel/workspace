package com.behavioral.visitor;

public class Visitor2 implements Visitor {

	@Override
	public void visit(ElementA a) {
		System.out.println(" PRINT A WITH STYLE 2 ... " + a.getContent().toUpperCase());
	}

	@Override
	public void visit(ElementB b) {
		System.out.println(" PRINT B WITH STYLE 2 ... " + b.getContent().toUpperCase());
	}

	@Override
	public void visit(ElementC c) {
		System.out.println(" PRINT C WITH STYLE 2 ... " + c.getContent().toUpperCase());
	}

}
