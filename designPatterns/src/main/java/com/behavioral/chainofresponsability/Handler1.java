package com.behavioral.chainofresponsability;

import java.util.logging.Logger;

public class Handler1 extends Handler {

	private static Logger log = Logger.getLogger(Handler1.class.getName());

	@Override
	public boolean check(int number) {
		boolean rtn = false;
		if (number % 3 == 0) {
			rtn = checkNext(number);
			log.info("Check Handler1 OK");
		}
		
		return rtn;
	}

}
