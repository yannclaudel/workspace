package com.creational.singleton;

import java.io.Serializable;

/**
 * Only one instance allowed for this class Expose a method in order to access
 * to this instance
 **/
public class Singleton implements Serializable {

	private static final long serialVersionUID = 3956590650927694727L;

	private static volatile Singleton instance = null;

	/**
	 * @return instance
	 */
	public static Singleton getInstance() {
		if (null == instance) {
			synchronized (Singleton.class) {
				if (null == instance) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	/**
	 * private constructor
	 */
	private Singleton() {
	}

	private Object readResolve() {
		return instance;
	}

}
