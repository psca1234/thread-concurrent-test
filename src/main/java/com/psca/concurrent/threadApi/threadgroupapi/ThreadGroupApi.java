package com.psca.concurrent.threadApi.threadgroupapi;

import java.util.stream.IntStream;

/**
 * @Description: ThreadGroup,在面方法中创建的ThreadGroup对象，
 * 并且未显示指定目标threadgroup的父级，则目标threadgroup的父级
 * 对象为main线程的threadgroup，名称为main
 * @Author: pansc
 * @CreateDate: 2019/1/21 18:39
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 18:39
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadGroupApi {
    public static void main(String[] args) throws InterruptedException{
        ThreadGroup tg1 = new ThreadGroup("tg1");
        tg1.setDaemon(true);
        String parentThreadGroupName = tg1.getParent().getName();
        System.out.println(Thread.currentThread().getName()+"\t thread group names "+parentThreadGroupName);
        System.out.println("====================================");
        IntStream.rangeClosed(1,10).forEach(i->new Thread(tg1,"T"+String.valueOf(i)){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"\tbegins working..");
                try {
                    Thread.sleep(1_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\tends working...");
                System.out.println(Thread.currentThread().getThreadGroup().getName());
            }
        }.start());
        ThreadGroup tg2 = new ThreadGroup(tg1,"tg2");
        String threadGroupName = tg2.getName();
        String tg2ParentThreadGroupName= tg2.getParent().getName();
        System.out.printf("The current thread group names %s\t,it parent thread group names %s\n",threadGroupName,tg2ParentThreadGroupName);
        Thread [] tg1Threads = new Thread[tg1.activeCount()];
        tg1.enumerate(tg1Threads,false);
        System.out.println("========="+tg1Threads.length);
        for(Thread thread : tg1Threads){
            System.out.println(thread);
        }
        tg2.destroy();

        while(true){
            if(tg1.isDestroyed()){
                System.out.println(tg1.getName()+"\tinner thread executed done");
                break;
            }
        }
    }
}
