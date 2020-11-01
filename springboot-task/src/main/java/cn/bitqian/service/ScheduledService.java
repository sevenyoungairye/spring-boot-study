package cn.bitqian.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 定时任务 springboot 已经集成
 * @author echo lovely
 * @date 2020/10/30 11:26
 */
@Service
public class ScheduledService {

    // corn表达式: 秒 时 分 日 月 周几
    @Scheduled(cron = "0/1 0/1 0/1 * * ?")
    public void show() {
        System.out.println("执行123...");
    }

}
