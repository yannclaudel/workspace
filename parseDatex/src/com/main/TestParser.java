package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.model.Measurement;
import com.parse.Datex2Parser;

public class TestParser {
	public static void main(String[] args) {
		// Locate the file
		// File xmlFile = new File("./in/trafficstatus_a3_001.xml");
		try {
			String urlString = "http://www.cita.lu/info_trafic/datex/trafficstatus_a3";
			URL url = new URL(urlString);
			// Create the parser instance
			Datex2Parser parser = new Datex2Parser();

			// Parse the file
			ArrayList<Measurement> measures = parser.parseXml(url.openStream());

			// Verify the result
			for (Measurement m : measures) {
				System.out.println(m.toString());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void mainXX(String[] args) throws Exception {
		String urlString = "http://www.cita.lu/info_trafic/datex/trafficstatus_a3";

		// create the url
		URL url = new URL(urlString);

		// open the url stream, wrap it an a few "readers"
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

		// write the output to stdout
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		// close our reader
		reader.close();
	}
}
