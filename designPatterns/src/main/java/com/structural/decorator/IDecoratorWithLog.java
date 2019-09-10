package com.structural.decorator;

public class IDecoratorWithLog extends Decorator{
	    
	    public IDecoratorWithLog(final Abstract abs) {
	        super(abs);
	    }

	    
	    public void execute() {
	        System.out.println("log before");
	        abstraction.execute();
	        System.out.println("log after");
	    }
	}
