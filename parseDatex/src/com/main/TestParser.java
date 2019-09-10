package com.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.model.Measurement;
import com.parse.Datex2Parser;

public class TestParser {
	public static void main(String[] args) throws FileNotFoundException {
		// Locate the file
		File xmlFile = new File("./in/trafficstatus_a3_001.xml");

		// Create the parser instance
		Datex2Parser parser = new Datex2Parser();

		// Parse the file
		ArrayList<Measurement> measures = parser.parseXml(new FileInputStream(xmlFile));

		// Verify the result
		for (Measurement m : measures) {
			System.out.println(m.toString());
		}
	}
}
