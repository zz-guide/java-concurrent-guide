package org.zz.thread;

import org.junit.jupiter.api.Test;
import org.zz.task.PrintNum;

import java.util.concurrent.*;

class ThreadPoolTests {

    @Test
    void testPoolHelloWorld() throws InterruptedException {
        // 简单认识线程池
        // 默认情况下多个任务分别使用不同的线程执行
        // 通过增加sleep延迟，保证上一个任务执行完之后把线程还回去，验证使用的是同一个线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new PrintNum());
        Thread.sleep(1000);
        executorService.submit(new PrintNum());
        Thread.sleep(1000);
        executorService.submit(new PrintNum());
        Thread.sleep(1000);
        executorService.shutdown();
    }

    @Test
    void testThreadPoolNum() throws InterruptedException {
//        ExecutorService executorService = Executors.newCachedThreadPool(); // 线程数无上限
        ExecutorService executorService = Executors.newFixedThreadPool(2); // 线程数有上限
        executorService.submit(new PrintNum());
        executorService.submit(new PrintNum());
        executorService.submit(new PrintNum());
        executorService.submit(new PrintNum());
        executorService.submit(new PrintNum());
        executorService.submit(new PrintNum());
        executorService.submit(new PrintNum());
        executorService.shutdown();
    }

    @Test
    void testThreadPoolCreateRule() throws InterruptedException {
        // 线程池都依赖ThreadPoolExecutor这个对象

        int corePoolSize = 2; // 核心工作线程数量
        int maximumPoolSize = 3; // 最多允许线程数，临时线程 = 最大 - 核心
        long keepAliveTime = 0L; // 临时线程存活时间
        TimeUnit unit = TimeUnit.MILLISECONDS; // 临时线程存活时间单位
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(); //任务队列,排队的地方
        ThreadFactory threadFactory = Executors.defaultThreadFactory(); // 线程吃工厂，创建线程
        RejectedExecutionHandler defaultHandler = new ThreadPoolExecutor.AbortPolicy(); // 线程池的任务拒绝策略，最繁忙的时候，新任务如何处理

        ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, defaultHandler);
        executorService.submit(new PrintNum());
        executorService.submit(new PrintNum());
        executorService.submit(new PrintNum());
        executorService.submit(new PrintNum());
        executorService.submit(new PrintNum());
        executorService.submit(new PrintNum());
        executorService.submit(new PrintNum());
        executorService.shutdown();
    }
}
