package com.datex.importDatexData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datex.model.Datex;
import com.datex.model.Measurement;
import com.datex.parser.Datex2Parser;

public class ParseJob implements Job {

	private static Logger log = LoggerFactory.getLogger(ParseJob.class);
	private String url = null;
	public void execute(JobExecutionContext context) throws JobExecutionException {
		final JobDataMap map = context.getJobDetail().getJobDataMap();
		this.url = map.getString("input_url");
		log.info(">>> Execution Start >>> "+url);
		if (url==null) throw new JobExecutionException("Param url missing");
		List<Measurement> out = fetchData();
		write(out);
		log.info(">>> Execution End >>> "+url);
	}

	private List<Measurement> fetchData() {

		List<Measurement> out = new ArrayList<>();
		try {
			URL urlstream = new URL(this.url);
			Datex2Parser parser = new Datex2Parser();
			out.addAll(parser.parseXml(urlstream.openStream()));
		} catch (MalformedURLException e) {
			log.error("MalformedURLException [" + "url" + "] msg [" + e.getMessage() + "]");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("IOException - msg [" + e.getMessage() + "]");
			e.printStackTrace();
		}
		return out;
	}

	private void write(List<Measurement> out) {
		BufferedWriter writer = null;
		try {
			String filename = Datex.RESOURCE_MAP.get(this.url);
			if (filename==null) filename = Datex.RESOURCE_DEFAULT; 
			writer = new BufferedWriter(new FileWriter(filename, true));
			for (Measurement measurement : out) {
				writer.write(measurement.print(";"));
			}			
		} catch(IOException e){
			log.error("IOException - msg [" + e.getMessage() + "]");
		}finally {
			if (writer!=null)
				try {
					writer.close();
				} catch (IOException e) {
					log.error("IOException - msg [" + e.getMessage() + "]");
				}
		}
	}

}
