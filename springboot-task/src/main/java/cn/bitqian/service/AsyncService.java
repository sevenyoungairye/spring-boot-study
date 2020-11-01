package cn.bitqian.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步任务 目的 多线程，交给spring托管，带来良好的用户体验
 * @author echo lovely
 * @date 2020/10/30 8:55
 */
@Service
public class AsyncService {

    // 开启了异步任务 多线程
    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("任务进行中...");
    }


}
