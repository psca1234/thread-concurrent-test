package com.psca.concurrent.threaddesignpartterntest.suspensiondesign;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/22 21:03
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/22 21:03
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ServerClient extends Thread {
    private final RequestQueue queue;
    private final Random random = new Random(System.currentTimeMillis());
    private volatile boolean closed = false;

    public ServerClient(RequestQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(!closed){
            Request request = queue.getRequest();
            if(null == request){
                System.out.println("Recieve an empty request,all request execute done.");
                continue;
            }
            String sendMessage = request.getSendData();
            System.out.println("Server->recieve request\t"+sendMessage);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void close(){
        this.closed = true;
        this.interrupt();
    }
}
