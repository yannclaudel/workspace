package com.behavioral.chainofresponsability;

import java.util.logging.Logger;

public class TestHandler {

	private static Logger log = Logger.getLogger(Handler1.class.getName());
	public static void main(String[] args) {
		Handler handlerRoot = new Handler1();
		handlerRoot.setNext(new Handler2()).setNext(new Handler3());

		log.info(()->"30 >>> " + handlerRoot.check(30));
		log.info(()->"36 >>> " + handlerRoot.check(36));
		log.info(()->"10 >>> " + handlerRoot.check(10));

	}

}
