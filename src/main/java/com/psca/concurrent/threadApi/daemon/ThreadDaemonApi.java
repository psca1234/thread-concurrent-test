package com.psca.concurrent.threadApi.daemon;

/**
 * @Description: setDaemon,将目标线程设置成为守护线程，当主线程运行结束
 * 无论守护线程是否完成工作，都会结束
 * @Author: pansc
 * @CreateDate: 2019/1/21 15:56
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 15:56
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadDaemonApi {
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread()+"\t begin working..");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread targetThread = Thread.currentThread();
            System.out.println("The thread name is\t"+targetThread.getName()+"\t priority is\t"+targetThread.getPriority()+"\tthread state\t"+targetThread.getState());
        },"t1");

        t1.setDaemon(true);
        t1.start();
        System.out.println(Thread.currentThread().getName()+"\t begins working..");
        Thread.sleep(100L);
        System.out.println(Thread.currentThread().getName()+"\t ends working..");
    }
}
