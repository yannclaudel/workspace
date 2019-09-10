package com.behavioral.memento;

import java.nio.charset.Charset;
import java.util.Random;

public class Creator {
		
	    private String state;
	    private String otherData;
	 
	    public Creator(String state,String otherData) {
	        this.state = state;
	        this.otherData = otherData;
	    }
	 
	    public Memento saveToMemento() {
	        return new Memento(this.state);
	    }
	 
	    public void restoreFromMemento(Memento memento) {
	        this.state = memento.getSavedState();
	    }

		public String getState() {
			return state;
		}

		public String getOtherData() {
			return otherData;
		}
		
		public String changeState() {
			byte[] array = new byte[7]; // length is bounded by 7
		    new Random().nextBytes(array);
		    this.state = new String(array, Charset.forName("UTF-8"));
		 
		    return this.state;
		}
	    	    
}
