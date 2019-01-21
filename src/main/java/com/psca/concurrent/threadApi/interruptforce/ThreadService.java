package com.psca.concurrent.threadApi.interruptforce;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 16:29
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 16:29
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadService {
    private static volatile boolean finished = false;
    private static Thread targetThread;

    public static void execute(Runnable runnable){
        targetThread = new Thread(()->{
            Thread t1 = new Thread(runnable,"targetDaemonThread");
            t1.setDaemon(true);
            t1.start();
            try {
                t1.join();
                finished = true;
            } catch (InterruptedException e) {
                System.out.println("Daemon thread interrupted.");
            }
        });
        targetThread.start();
    }

    public static void shutdown(long executeTs){
        long startExecutedTs = System.currentTimeMillis();
        while(!finished){
            if((System.currentTimeMillis())-startExecutedTs>=executeTs){
                targetThread.interrupt();
                break;
            }else{
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        finished =false;
    }
}
