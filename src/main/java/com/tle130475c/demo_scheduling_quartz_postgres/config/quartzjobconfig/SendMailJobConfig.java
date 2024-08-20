package com.tle130475c.demo_scheduling_quartz_postgres.config.quartzjobconfig;

import java.util.TimeZone;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tle130475c.demo_scheduling_quartz_postgres.quartzjob.SendMailJob;

@Configuration
public class SendMailJobConfig {
    @Bean(name = "sendMailJobDetail")
    JobDetail sendMailJobDetail() {
        return JobBuilder.newJob(SendMailJob.class)
                .withIdentity("SendMailJob")
                .storeDurably()
                .build();
    }

    @Bean
    Trigger sendMailTrigger(@Qualifier("sendMailJobDetail") JobDetail jobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity("SendMailJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?")
                        .inTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh")))
                .build();
    }
}