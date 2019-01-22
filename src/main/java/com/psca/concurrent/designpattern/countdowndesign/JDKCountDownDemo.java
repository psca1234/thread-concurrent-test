package com.psca.concurrent.designpattern.countdowndesign;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/22 9:00
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/22 9:00
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class JDKCountDownDemo {
    private static final CountDownLatch LATCH = new CountDownLatch(5);
    private static String groupName = "";
    public static void main(String[] args) throws InterruptedException{
        IntStream.rangeClosed(1,5).forEach(i->new Thread("T"+String.valueOf(i)){
            @Override
            public void run() {
                ThreadGroup mainTg = Thread.currentThread().getThreadGroup();
                groupName +=mainTg.getName()+",";
                System.out.println(Thread.currentThread().getName()+"\tbegins working.");
                try {
                    Thread.sleep(1_000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\tends working.");
                LATCH.countDown();
            }
        }.start());
        LATCH.await();
        String [] groupNames = groupName.split(",");
        Arrays.asList(groupNames).stream().forEach(System.out::println);
    }
}
