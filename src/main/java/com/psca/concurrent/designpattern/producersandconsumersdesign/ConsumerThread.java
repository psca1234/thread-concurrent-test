package com.psca.concurrent.designpattern.producersandconsumersdesign;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 21:08
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 21:08
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ConsumerThread extends Thread {
    private final MessageQueue messageQueue;
    private final Random random;
    public ConsumerThread(MessageQueue queue,int seq){
        super("Consumer-"+seq);
        this.messageQueue = queue;
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while(true){
            try {
                Message message = messageQueue.take();
                System.out.println(Thread.currentThread().getName()+"\t receive a message is\t"+message.getSendData());
                Thread.sleep(random.nextInt(1_000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
