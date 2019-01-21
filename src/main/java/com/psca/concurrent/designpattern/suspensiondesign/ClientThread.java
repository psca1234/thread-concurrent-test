package com.psca.concurrent.designpattern.suspensiondesign;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 22:37
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 22:37
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ClientThread extends Thread {
    private final ReuqestQueue reuqestQueue;
    private final String sendMessage;
    private final Random random;
    public ClientThread(ReuqestQueue reuqestQueue,String sendMessage){
        this.reuqestQueue = reuqestQueue;
        this.sendMessage= sendMessage;
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println("Client->request\t"+sendMessage);
            reuqestQueue.putRequest(new Request(sendMessage));
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
