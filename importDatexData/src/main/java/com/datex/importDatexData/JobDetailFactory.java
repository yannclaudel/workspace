package com.datex.importDatexData;

import static org.quartz.JobBuilder.newJob;

import java.io.Serializable;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;

public class JobDetailFactory implements Serializable {

	private static final long serialVersionUID = 3956590650927694727L;
	private static volatile JobDetailFactory instance = null;

	public JobDetail getJobDetailObject(String url,String jobname) {
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("jobName", jobname);
		jobDataMap.put("input_url", url);
		JobDetail job = newJob(ParseJob.class).withIdentity(jobname, "DATEX").setJobData(jobDataMap).build();
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