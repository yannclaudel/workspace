package com.behavioral.visitor;

import java.util.logging.Logger;

public class Visitor2 implements Visitor {
	private static Logger log = Logger.getLogger(Visitor2.class.getName());
	@Override
	public void visit(ElementA a) {
		log.info(()->" PRINT A WITH STYLE 2 ... " + a.getContent().toUpperCase());
	}

	@Override
	public void visit(ElementB b) {
		log.info(()->" PRINT B WITH STYLE 2 ... " + b.getContent().toUpperCase());
	}

	@Override
	public void visit(ElementC c) {
		log.info(()->" PRINT C WITH STYLE 2 ... " + c.getContent().toUpperCase());
	}

}
