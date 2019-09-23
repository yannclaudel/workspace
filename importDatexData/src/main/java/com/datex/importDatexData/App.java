package com.datex.importDatexData;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.examples.example1.SimpleExample;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datex.model.Datex;

/**
 * Hello world!
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
		
		JobDetail jobA1 = JobDetailFactory.getInstance().getJobDetailObject(Datex.TRAFFIC_A1);
		JobDetail jobA3 = JobDetailFactory.getInstance().getJobDetailObject(Datex.TRAFFIC_A3);
						
		Trigger triggerA1 = newTrigger().withIdentity("A1", "datex").withSchedule(scheduleBuilder).build();
		Trigger triggerA3 = newTrigger().withIdentity("A3", "datex").withSchedule(scheduleBuilder).build();

		sched.scheduleJob(jobA1, triggerA1);
		sched.scheduleJob(jobA3, triggerA3);

		sched.start();


		// shut down the scheduler
		//log.info("------- Shutting Down ---------------------");
		//sched.shutdown(true);
		//log.info("------- Shutdown Complete -----------------");
	}

	public static void main(String[] args) throws Exception {
		App app = new App();
		app.run();
		System.out.println("Hello World!");
	}
}
