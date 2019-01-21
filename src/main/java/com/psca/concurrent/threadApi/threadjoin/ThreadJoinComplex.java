package com.psca.concurrent.threadApi.threadjoin;

/**
 * @Description: 需要注意注意的是，join是让线程和调用join线程的启动的方法
 * 的代码按照编写顺序执行
 * @Author: pansc
 * @CreateDate: 2019/1/21 15:48
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 15:48
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadJoinComplex {
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
        Thread t2 = new Thread(()->{
            System.out.println(Thread.currentThread()+"\t begin working..");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread targetThread = Thread.currentThread();
            System.out.println("The thread name is\t"+targetThread.getName()+"\t priority is\t"+targetThread.getPriority()+"\tthread state\t"+targetThread.getState());
        },"t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(Thread.currentThread().getName()+"\t priority\t"+Thread.currentThread().getPriority()+"\tstate\t"+Thread.currentThread().getState());
    }
}
