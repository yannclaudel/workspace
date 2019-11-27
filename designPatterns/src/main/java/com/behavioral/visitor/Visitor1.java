package com.behavioral.visitor;

import java.util.logging.Logger;

public class Visitor1 implements Visitor {
	private static Logger log = Logger.getLogger(Visitor1.class.getName());
	@Override
	public void visit(ElementA a) {
		log.info(()->" print A with stype 1 ... " + a.getContent());
	}

	@Override
	public void visit(ElementB b) {
		log.info(()->" print B with stype 1 ... " + b.getContent());
	}

	@Override
	public void visit(ElementC c) {
		log.info(()->" print C with stype 1 ... " + c.getContent());
	}

}
