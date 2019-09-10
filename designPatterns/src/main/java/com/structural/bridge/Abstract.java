package com.structural.bridge;

public abstract class Abstract {

	private Implementation impl;
    
    protected Abstract(Implementation pimpl) {
        this.impl = pimpl;
    }

    public abstract void execute();
    
    
	public void execute1() {
		impl.execute1();
	}

	public void execute2() {
		impl.execute2();
	}

}
