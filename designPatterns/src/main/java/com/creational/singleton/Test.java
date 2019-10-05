package com.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
				
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println("s1 hash=" + s1.hashCode());
		System.out.println("s2 hash=" + s2.hashCode());

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("in/s1.ser"));
			oos.writeObject(s1);
			oos.close();
			ois = new ObjectInputStream(new FileInputStream("in/s1.ser"));
			Singleton s3 = (Singleton) ois.readObject();
			ois.close();
			System.out.println("s3 hash=" + s3.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(Test::execute);
		service.submit(Test::execute);
		service.shutdown();

	}

	public static void execute() {
		//Singleton s = Singleton.getInstance();
		EnumSingleton s = EnumSingleton.INSTANCE;
		System.out.println("s hash=" + s.hashCode());
	}
}
