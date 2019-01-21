package com.psca.concurrent.designpattern.suspensiondesign;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 22:41
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 22:41
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ServerThread extends Thread {
    private final ReuqestQueue queue;
    private volatile boolean closed;
    private final Random random;

    public ServerThread(ReuqestQueue queue){
        this.closed = false;
        this.queue=queue;
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        synchronized (queue){
            while (!closed){
                Request request = queue.getRequest();
                if (null == request) {
                    System.out.println("Received the empty request.");
                    continue;
                }
                System.out.println("Server-> recieve\t"+request.getSendData());
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public void close(){
        this.closed=true;
        this.interrupt();
    }
}
