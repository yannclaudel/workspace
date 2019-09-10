package com.behavioral.iterator;

public class Link {

	private String content;
	private Link next;
	public Link( String content) {
		super();
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	public Link getNext() {
		return next;
	}
	public String getKey() {
		return ""+this.getContent().hashCode();
	}
	public void setNext(Link next) {
		this.next = next;
	}	
	
}
