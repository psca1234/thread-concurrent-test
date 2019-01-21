package com.psca.concurrent.designpattern.producersandconsumersdesign;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 21:07
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 21:07
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ProducerThread extends Thread{
    private final MessageQueue queue;
    private final AtomicInteger counter = new AtomicInteger(0);
    private final Random random;

    public ProducerThread(MessageQueue queue,int seq){
        super("Producer-"+seq);
        this.queue = queue;
        random=new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while(true){
            try {
                Message message = new Message("Message"+counter.getAndIncrement());
                queue.put(message);
                System.out.println(Thread.currentThread().getName()+"\t put value"+message.getSendData());
                Thread.sleep(random.nextInt(1_000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
