package com.mes.common.utils;

import com.mes.common.framework.Exception.JobException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * 通用的任务调度管理工具类
 */
public class JobTool {

    private static final Logger log = LogManager.getLogger(JobTool.class);

    private static class JobToolHelper {
        private static final JobTool INSTANCE = new JobTool();
    }

    public static JobTool getInstance() {
        return JobToolHelper.INSTANCE;
    }

    private Scheduler scheduler;

    public JobTool() {
        try {
            if (scheduler == null) {
                scheduler = StdSchedulerFactory.getDefaultScheduler();
            }
            scheduler.start();
            log.info("scheduler init success.");
        } catch (SchedulerException e) {
            log.error("scheduler 初始化失败.", e);
        }
    }

    /**
     * 增加一个调度任务
     * @param jobName 任务名称
     * @param frequency corn表达式
     * @param clazz Job
     * @throws JobException
     */
    public void addJob(String jobName,String frequency,Class clazz) throws JobException {
        String groupName = jobName;
        JobDetail job;
        CronTrigger trigger;
        try {
            job = newJob(clazz).withIdentity(jobName,groupName).build();
            trigger = newTrigger().withIdentity(jobName+groupName, groupName).withSchedule(cronSchedule(frequency)).build();
        } catch (Exception e) {
            throw new JobException("build JobDetail or CronTrigger exception," + e.getMessage(), e);
        }

        try {
            if (scheduler.isShutdown()) {
                scheduler.start();
            }
            try {
                if (!scheduler.checkExists(job.getKey())) {
                    scheduler.scheduleJob(job, trigger);
                    log.info("the " + jobName + " job was started.{jobName:" + jobName + ",frequency:" + frequency + ",clazz:" + clazz.getName() + "}");
                }
            } catch (SchedulerException e) {
                throw new JobException("add new job scheduler exception,{jobCode:" + jobName + "}," + e.getMessage(), e);
            }
        } catch (SchedulerException e) {
            throw new JobException("restart scheduler exception," + e.getMessage(), e);
        }
    }


    public void addJob(String jobCode, String frequency, String className) throws JobException {
        if (StringUtils.isBlank(jobCode) || StringUtils.isBlank(frequency) || StringUtils.isBlank(className)) {
            throw new JobException("one of the params is null,{jobCode:"+jobCode+",frequency:"+frequency+",className:"+className+"}");
        }

        Object obj;
        try {
            obj = Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            throw new JobException(" new class by className error,{className:" + className + "}," + e.getMessage(), e);
        } catch (InstantiationException e2) {
            throw new JobException(e2);
        } catch (IllegalAccessException e3) {
            throw new JobException(e3);
        }

        if (!(obj instanceof Job)) {
            throw new JobException("a instance of className is not instanceof org.quartz.Job,{className:" + className + "}");
        }

        JobDetail job;
        CronTrigger trigger;

        try {

            //是否可以获取class of Job 有待测试
            job = newJob(Job.class.cast(obj).getClass()).withIdentity(jobCode, jobCode).build();
            trigger = newTrigger().withIdentity(jobCode + jobCode, jobCode).withSchedule(cronSchedule(frequency)).build();
        } catch (Exception e) {
            throw new JobException("build JobDetail or CronTrigger exception," + e.getMessage(), e);
        }

        try {
            if (scheduler.isShutdown()) {
                scheduler.start();
            }
            try {
                scheduler.scheduleJob(job, trigger);
            } catch (SchedulerException e) {
                throw new JobException("add new job scheduler exception,{jobCode:" + jobCode + "}," + e.getMessage(), e);
            }
        } catch (SchedulerException e) {
            throw new JobException("restart scheduler exception," + e.getMessage(), e);
        }
    }


    public void delJob(String jobCode) throws JobException{
        try {
            if (scheduler.isShutdown()) {
                scheduler.start();
            }
            JobKey key = new JobKey(jobCode, jobCode);
            if (scheduler.checkExists(key)) {
                scheduler.deleteJob(key);
                log.info("the " + jobCode + " job was removed.");
            }
        } catch (SchedulerException e) {
            throw new JobException("delete job by jobCode failed,{jobCode:" + jobCode + "}", e);
        }
    }
}

