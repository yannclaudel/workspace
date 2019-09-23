package com.datex.importDatexData;

import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datex.model.Datex;

/**
 * Main Launcher
 *
 */
public class App {

	public void run() throws Exception {
		Logger log = LoggerFactory.getLogger(App.class);

		log.info("------- Initializing ----------------------");

		// First we must get a reference to a scheduler
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		// Trigger the job to run on the next round minute
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInMinutes(Datex.INTERVAL_IN_MINUTE).repeatForever();

		for (String url : Datex.RESOURCE_MAP.keySet()) {
			String[] words = url.split("/");
			String jobname = "UNKNOWN";
			if (words != null && words.length > 0)
				jobname = words[words.length - 1].toUpperCase();

			JobDetail job = JobDetailFactory.getInstance().getJobDetailObject(url, jobname);
			Trigger trigger = newTrigger().withIdentity(jobname, "DATEX").withSchedule(scheduleBuilder).build();
			sched.scheduleJob(job, trigger);
		}

		sched.start();
		String ererer = "\"\"";
		if (ererer=="null") {
			
		} 
		// shut down the scheduler
		// log.info("------- Shutting Down ---------------------");
		// sched.shutdown(true);
		// log.info("------- Shutdown Complete -----------------");
	}

	public static void main(String[] args) throws Exception {
		App app = new App();
		app.run();
	}
}
