package com.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonT {
	private static Logger log = Logger.getLogger(SingletonT.class.getName());
	public static void main(String[] args) {
				
		Singleton sing1 = Singleton.getInstance();
		Singleton sing2 = Singleton.getInstance();

		log.info(()->"s1 hash=" + sing1.hashCode());
		log.info(()->"s2 hash=" + sing2.hashCode());

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("in/s1.ser"));
			oos.writeObject(sing1);
			oos.close();
			ois = new ObjectInputStream(new FileInputStream("in/s1.ser"));
			Singleton sing3 = (Singleton) ois.readObject();
			ois.close();
			log.info(()->"s3 hash=" + sing3.hashCode());
		} catch (Exception e) {
			log.log(Level.SEVERE,e.getMessage());
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				log.log(Level.SEVERE,e.getMessage());
			}
		}

		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(SingletonT::execute);
		service.submit(SingletonT::execute);
		service.shutdown();

	}

	public static void execute() {
		//Singleton sing = Singleton.getInstance();
		EnumSingleton sing = EnumSingleton.INSTANCE;
		log.info(()->"sing hash code =" + sing.hashCode());
	}
}
