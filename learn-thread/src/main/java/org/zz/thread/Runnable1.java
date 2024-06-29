package org.zz.thread;

public class Runnable1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Runnable1:"+Thread.currentThread().getName()+"=>"+i);
        }
    }
}
