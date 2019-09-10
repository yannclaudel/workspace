package com.structural.decorator;

public abstract class Decorator implements Abstract {
    protected Abstract abstraction;
    
    public Decorator(final Abstract a) {
        abstraction = a;
    }
}