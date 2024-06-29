package org.zz.task;

public class Ticket {
    // 此变量被所有线程共享，如果不加保护措施，会出现少卖或者超卖的现象
    static Integer num = 0;

    public static void sell(){
        while(true) {
            if (num < 100) {
                // 为了观察到超卖现象加的
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                num++;
                System.out.println(Thread.currentThread().getName() + "正在卖第" + num + "张票");
            } else {
                break;
            }
        }
    }
}
