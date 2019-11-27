package com.behavioral.chainofresponsability;

import java.util.logging.Logger;

public class Handler2 extends Handler {
	private static Logger log = Logger.getLogger(Handler2.class.getName());
	@Override
	public boolean check(int number) {
		boolean rtn = false;
		if (number % 2 == 0) {
			rtn = checkNext(number);
			log.info("Check Handler2 OK");
		}		
		return rtn;

	}

}
