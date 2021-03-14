package top.bitqian;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author echo lovely
 * @date 2021/3/8 14:11
 */

public class Demo {

    @Test
    void contextLoad() {

        ConcurrentSkipListMap<String, String> cslMap = new ConcurrentSkipListMap<>();

        cslMap.put("k1", "a");
        cslMap.put("k2", "a");
        cslMap.put("k3", "a");
        cslMap.put("k4", "a");

        System.out.println(cslMap.firstEntry().getKey() + "\t" + cslMap.firstEntry().getValue());

    }

    @Test
    void test1() {

        // dead calculate
        /*for (;;) {
            int i = 0;
            i ++;
            System.out.println(i);

            if (i >= 10) {
                break;
            }
        }*/

        Ticket ticket = new Ticket();

        for (int i = 0; i < 30; i++) {

            new Thread(ticket::sale, "A").start();

            new Thread(ticket::sale, "B").start();

        }


    }

}

class Ticket {

    private Integer num = 10;

    private final Lock lock = new ReentrantLock();

    void sale() {

        try {
            lock.lock();

            if (num > 0)
                System.out.println(Thread.currentThread().getName() + "\t sale a ticket, and ticket num left: " + --num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
