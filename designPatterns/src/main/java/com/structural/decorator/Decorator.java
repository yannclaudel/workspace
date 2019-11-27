package com.structural.decorator;

public abstract class Decorator implements WhatToDo {
    protected WhatToDo abstraction;
    
    public Decorator(final WhatToDo absObj) {
        abstraction = absObj;
    }
}