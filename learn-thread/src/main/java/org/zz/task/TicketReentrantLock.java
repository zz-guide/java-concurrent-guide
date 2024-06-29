package org.zz.task;

import java.util.concurrent.locks.ReentrantLock;

public class TicketReentrantLock {
    // 此变量被所有线程共享，如果不加保护措施，会出现少卖或者超卖的现象
    static Integer num = 0;
    static ReentrantLock lock = new ReentrantLock();
    public static void sell(){
        while(true) {
            lock.lock();
            if (num < 100) {
                num++;
                System.out.println(Thread.currentThread().getName() + "正在卖第" + num + "张票");
            } else {
                break;
            }

            lock.unlock();
        }
    }
}
