package org.zz.thread;

public class Thread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread1:"+Thread.currentThread().getName()+"=>"+i);

            // 主动让出cpu的执行权，但不是绝对的让出，只是尽可能
            Thread.yield();
        }
    }
}
