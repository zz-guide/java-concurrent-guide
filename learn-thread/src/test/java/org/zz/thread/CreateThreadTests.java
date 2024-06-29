package org.zz.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.FutureTask;

/**
 * 归根到底，实现了Runnable接口就意味着具备了线程功能
 */
class CreateThreadTests {

    @Test
    void testThreadHelloWorld() {
        // 定义线程的三种方式
        // extends Thread 无返回值
        // implements Runnable 无返回值
        // implements Callable<T> 可以有返回值
        Thread1 t1 = new Thread1();
        Thread t2 = new Thread(new Runnable1());

        Callable1 myCallable = new Callable1();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread t3 = new Thread(futureTask);

        t1.setName("继承Thread类");
        t2.setName("实现Runnable接口");
        t3.setName("实现Callable接口");

        t1.start();
        t2.start();
        t3.start();

        // 经过观察发现线程之间交替执行
        try {
            // join 代表插入线程，优先执行task，然后执行main线程
            t1.join();
            t2.join();
            t3.join();

            Integer sum = futureTask.get();
            System.out.println("运行结果:"+ sum);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void testThread1() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("使用匿名类创建 Thread 子类对象");
            }
        };

        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testThread2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名类创建 Runnable 子类对象");
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testThread3() {
        Thread thread = new Thread(()-> {
            System.out.println("lambda 表达式创建 Runnable 子类对象");
        });

        thread.start();
        try {
            thread.join();
        } catch (Exception  e) {
            throw new RuntimeException(e);
        }
    }
}
