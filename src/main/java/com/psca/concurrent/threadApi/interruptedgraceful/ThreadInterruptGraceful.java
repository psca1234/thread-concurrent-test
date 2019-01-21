package com.psca.concurrent.threadApi.interruptedgraceful;

/**
 * @Description: 所谓的优雅的打断线程，就是在终止线程
 * 时不能抛出异常
 * 有两种方式
 * 1.定义一个标识变量，通过改变变量的true/false值来控制线程的运行或停止
 * 2.使用线程的isInterrupt方法
 * @Author: pansc
 * @CreateDate: 2019/1/21 16:05
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 16:05
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadInterruptGraceful{
    public static class Worker extends Thread{
        private volatile boolean started = true;

        @Override
        public void run() {
            while(started){
                System.out.println(Thread.currentThread().getName()+"\tbegins working.");
            }
            System.out.println(Thread.currentThread().getName()+("\t ends working"));
        }

        public void shutdown(){
            this.started = false;
        }
    }

    public static void main(String[] args)throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(1000L);
        worker.shutdown();
    }

}
