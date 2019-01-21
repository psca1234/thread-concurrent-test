package com.psca.concurrent.threadApi.consumelock;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 18:24
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 18:24
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class BooleanLockClient {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch latch = new CountDownLatch(5);
        BooleanLock lock = new BooleanLock();
        IntStream.rangeClosed(1, 5).forEach(i -> new Thread("T" + String.valueOf(i)) {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "\tbegins working..");
                    Thread.sleep(2_000L);
                    System.out.println(Thread.currentThread().getName() + "\tends working....");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }.start());
        latch.await();
        System.out.println("============华丽的分割线===============");
        IntStream.rangeClosed(1, 10).forEach(i -> new Thread("T" + String.valueOf(i)) {
            @Override
            public void run() {
                try {
                    lock.lock(10_000L);
                    System.out.println(Thread.currentThread().getName() + "\tbegins working..");
                    Thread.sleep(2_000L);
                    System.out.println(Thread.currentThread().getName() + "\tends working....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Lock.TimeoutException ex){
                    System.out.println(ex.getMessage());
                }finally {
                    lock.unlock();
                }
            }
        }.start());
    }
}
