package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

import com.creational.singleton.Singleton;

public class SingletonTest {
	@Test
	public void testSingleton() {
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println("s1 hash=" + s1.hashCode());
		System.out.println("s2 hash=" + s2.hashCode());
		assertEquals(s1.hashCode(), s2.hashCode());

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
			assertEquals(s1.hashCode(), s3.hashCode());
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
	}


}
