package org.zz.thread;

import java.util.concurrent.Callable;

public class Callable1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum++;
        }

        return sum;
    }
}
