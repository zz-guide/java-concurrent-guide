package org.zz.thread;

import org.junit.jupiter.api.Test;
import org.zz.task.Ticket;
import org.zz.task.TicketReentrantLock;
import org.zz.task.TicketSynchronize;

class ThreadSafeTests {

    @Test
    void testNoSafe() {
        Thread t1 = new Thread(Ticket::sell);
        Thread t2 = new Thread(Ticket::sell);
        Thread t3 = new Thread(Ticket::sell);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testSynchronized() {
        Thread t1 = new Thread(TicketSynchronize::sell);
        Thread t2 = new Thread(TicketSynchronize::sell);
        Thread t3 = new Thread(TicketSynchronize::sell);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testReentrantLock() {
        Thread t1 = new Thread(TicketReentrantLock::sell);
        Thread t2 = new Thread(TicketReentrantLock::sell);
        Thread t3 = new Thread(TicketReentrantLock::sell);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
