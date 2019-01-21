package com.psca.concurrent.threadApi.controlconcurrentcount;

import com.psca.concurrent.threadApi.interruptforce.ThreadService;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 17:48
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 17:48
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ControlConcurrentThreadCount {
    private static final LinkedList<Control> CONTROLS = new LinkedList<>();
    private static final int MAX_SIZE = 5;
    public static void main(String[] args) {
        List<Thread> workers = new ArrayList<>();
        Arrays.asList("M1","M2","M3","M4","M5","M6","M7","M8","M9","M10")
                .stream()
                .map(ControlConcurrentThreadCount :: createThread)
                .forEach(thread -> {
                    thread.start();
                    workers.add(thread);
                });

//        Optional.of(workers).ifPresent(System.out :: println);
        workers.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All Threads executes done");
    }

    private static Thread createThread(String name){
        return new Thread(()->{
            synchronized (CONTROLS){
                while(CONTROLS.size() >= MAX_SIZE){
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROLS.addLast(new Control());
            }
            System.out.println(Thread.currentThread().getName()+"\tbegins working...");
            try {
                Thread.sleep(20_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\tends working...");
            synchronized (CONTROLS){
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }
        },name);
    }

    private static class Control{}
}
