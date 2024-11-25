package com.example.EcommerceWebsite.config;

import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class JobListener implements JobExecutionListener {

    private final Logger logger = Logger.getLogger(String.valueOf(JobListener.class));
    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("Job Started: " + jobExecution.getJobInstance().getJobName());
        logger.info("Start time: " + jobExecution.getStartTime());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            logger.info("Job Completed");
        }
    }


}

//Adding a listener in Spring Batch can be useful to track the status of a job or step, log events, handle errors,
// or trigger actions after specific events. Here’s how to add a listener to the batch job.
//
//Step-by-Step Guide to Adding a Listener
// --Create a Job Listener: This listener will handle events at the job level.
// --Create a Step Listener: This listener will handle events at the step level.
// --Configure Listeners in the Batch Job.