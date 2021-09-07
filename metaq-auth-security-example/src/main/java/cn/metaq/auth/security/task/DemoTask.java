package cn.metaq.auth.security.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoTask {

    @Scheduled(cron = "0/1 * * * * * 2021")
    public void exec(){

        System.out.println("定时任务执行");
    }
}
