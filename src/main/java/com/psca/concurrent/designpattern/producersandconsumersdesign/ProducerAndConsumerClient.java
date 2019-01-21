package com.psca.concurrent.designpattern.producersandconsumersdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 21:08
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 21:08
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ProducerAndConsumerClient {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        new ProducerThread(queue,1).start();
        new ProducerThread(queue,2).start();
        new ProducerThread(queue,3).start();
        new ProducerThread(queue,4).start();
        new ConsumerThread(queue,1).start();
        new ConsumerThread(queue,2).start();
        new ConsumerThread(queue,3).start();
    }
}
