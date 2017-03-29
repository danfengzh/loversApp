package org.loversAPP.SheduleTask;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by Administrator on 2017/3/28.
 */
public class ExtendStyleService extends QuartzJobBean {
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("bvvvvvvvvvvvvv    ........");
    }
}
