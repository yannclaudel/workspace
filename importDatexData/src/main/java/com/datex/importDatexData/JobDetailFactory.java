package com.datex.importDatexData;

import static org.quartz.JobBuilder.newJob;

import java.io.Serializable;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;

public class JobDetailFactory implements Serializable {

	private static final long serialVersionUID = 3956590650927694727L;
	private static volatile JobDetailFactory instance = null;

	public JobDetail getJobDetailObject(String url) {
		String[] words = url.split("/");
		String jobname = "UNKNOWN";
		if (words != null && words.length > 0)
			jobname = words[words.length - 1];
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("jobName", jobname);
		jobDataMap.put("input_url", url);
		JobDetail job = newJob(ParseJob.class).withIdentity(jobname, "datex").setJobData(jobDataMap).build();
		return job;
	}

	/**
	 * @return instance
	 */
	public static JobDetailFactory getInstance() {
		if (null == instance) {
			synchronized (JobDetailFactory.class) {
				if (null == instance) {
					instance = new JobDetailFactory();
				}
			}
		}
		return instance;
	}

	/**
	 * private constructor
	 */
	private JobDetailFactory() {
	}

	/**
	 * manage serialization
	 * 
	 * @return Object
	 */
	private Object readResolve() {
		return instance;
	}

}