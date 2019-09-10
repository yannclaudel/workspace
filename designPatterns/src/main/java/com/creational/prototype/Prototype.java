package com.creational.prototype;

public abstract class Prototype implements Cloneable {

    protected String texte;
    
    /**
     * Constructor.
     * @param pTexte
     */
    public Prototype(String pTexte) {
        texte = pTexte;
    }
    
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }
    
    public void setTexte(String pTexte) {
        texte = pTexte;
    }
    
    public abstract void display();
}