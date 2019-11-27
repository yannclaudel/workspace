package com.behavioral.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Listener {
	private final List<Observer> observers = new ArrayList<>();
	  
    private void notifyObservers(String event) {
        observers.forEach(observer -> observer.update(event));
    }
  
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
  
    public void listenSystemIn() {
    	Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
        	String line = scanner.nextLine();
            notifyObservers(line);
        }     
        scanner.close();
    }
}
