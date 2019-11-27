package com.behavioral.chainofresponsability;

import java.util.logging.Logger;

public class Handler3 extends Handler {
	private static Logger log = Logger.getLogger(Handler3.class.getName());

	@Override
	public boolean check(int number) {
		boolean rtn = false;
		if (number % 5 == 0) {
			rtn = checkNext(number);
			log.info("Check Handler5 OK");
		}
		return rtn;
	}

}
