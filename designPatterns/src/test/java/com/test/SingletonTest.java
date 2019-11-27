package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.creational.singleton.Singleton;

public class SingletonTest {
	private static Logger log = Logger.getLogger(SingletonTest.class.getName());

	@Test
	public void testSingleton() {

		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		log.info(()->"s1 hash=" + s1.hashCode());
		log.info(()->"s2 hash=" + s2.hashCode());
		assertEquals(s1.hashCode(), s2.hashCode(),"hash codes s1 and s2 are equal");

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("in/s1.ser"));
			oos.writeObject(s1);
			oos.close();
			ois = new ObjectInputStream(new FileInputStream("in/s1.ser"));
			Singleton s3 = (Singleton) ois.readObject();
			ois.close();
			log.log(Level.INFO,()->"s3 hash=" + s3.hashCode());
			assertEquals(s1.hashCode(), s3.hashCode(),"hash codes s1 and s3 are equal");
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

}
