package com.behavioral.visitor;

public class Visitor1 implements Visitor {

	@Override
	public void visit(ElementA a) {
		System.out.println(" print A with stype 1 ... " + a.getContent());
	}

	@Override
	public void visit(ElementB b) {
		System.out.println(" print B with stype 1 ... " + b.getContent());
	}

	@Override
	public void visit(ElementC c) {
		System.out.println(" print C with stype 1 ... " + c.getContent());
	}

}
