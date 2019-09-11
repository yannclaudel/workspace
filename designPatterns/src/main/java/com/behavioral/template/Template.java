package com.behavioral.template;

public abstract class Template {

	public final int algorith(int x, int y) {
		return operationA(x, y) * operationB(x, y);
	}

	public abstract int operationA(int x, int y);

	public abstract int operationB(int x, int y);

}
