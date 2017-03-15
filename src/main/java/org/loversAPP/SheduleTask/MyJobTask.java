package org.loversAPP.SheduleTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/15.
 */
@Component
public class MyJobTask implements JobService {
    @Scheduled(fixedRate = 50000)
    @Override
    public void job1() {
        System.out.println("he;; looeoeooe");
    }
}
