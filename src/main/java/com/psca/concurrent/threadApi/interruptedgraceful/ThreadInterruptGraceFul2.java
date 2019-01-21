package com.psca.concurrent.threadApi.interruptedgraceful;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 16:21
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 16:21
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadInterruptGraceFul2 {

    public static class Worker extends Thread{
        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName()+"\tbegins working.");
            }
            System.out.println(Thread.currentThread().getName()+"\tends working.");
        }
    }

    public static void main(String[] args)throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(20_000L);
        worker.interrupt();
    }
}
