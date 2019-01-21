package com.psca.concurrent.threadApi.waitandnotify;

import java.util.stream.IntStream;

/**
 * @Description: 每一个作为锁的对象中都有一个waitset，用来存储获取对象锁的线程
 * waitset中的存储结构不是FIFO
 * waitset中有类似程序计数器的小工具，当被锁对象锁定的代码被锁唤醒后，会获取程序计数器记录的wait前当前线程执行到的逻辑单元的行数
 * 然后向下继续执行
 * @Author: pansc
 * @CreateDate: 2019/1/21 20:05
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 20:05
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WaitSetDemo {
    private static final Object LOCK = new Object();

    private static void work() {
        synchronized (LOCK) {
            System.out.println("Begin....");

            try {
                System.out.println("Thread will coming");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread will out.");
        }
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(i -> new Thread(() -> {
        }, "T" + String.valueOf(i)) {
            @Override
            public void run() {
                synchronized (LOCK) {
                    System.out.println(Thread.currentThread().getName() + "\t recieve a lock");
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t leave a lock");
                }
            }
        }.start());
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        IntStream.rangeClosed(1, 10).forEach(i -> {
            synchronized (LOCK) {
                LOCK.notify();
            }
        });

        System.out.println("=============================");

        new Thread("t1") {
            @Override
            public void run() {
                work();

            }
        }.start();
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (LOCK) {
            LOCK.notify();
        }
    }
}
