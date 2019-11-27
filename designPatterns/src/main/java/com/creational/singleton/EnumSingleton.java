package com.creational.singleton;

import java.util.logging.Logger;

public enum EnumSingleton {
	INSTANCE;
	public static void doIt() {
		Logger.getLogger(EnumSingleton.class.getName()).info("do something ...");
	}

}
