package com.psca.concurrent.threadApi.threadjoin;

/**
 * @Description: 线程的join方法复习
 * 线程的join方式就是让线程按照开发顺序进行执行
 * @Author: pansc
 * @CreateDate: 2019/1/21 15:43
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 15:43
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadJoinSimple {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t begins working.");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t ends working.");
        },"t1");

        t1.start();

        t1.join();

        System.out.println(Thread.currentThread().getName()+"\t begins working...");
        Thread.sleep(1000L);
        System.out.println(Thread.currentThread().getName()+"\t ends working...");
    }

}
