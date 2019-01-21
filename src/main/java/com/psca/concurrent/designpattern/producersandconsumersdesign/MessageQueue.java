package com.psca.concurrent.designpattern.producersandconsumersdesign;

import java.util.LinkedList;
import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 21:07
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 21:07
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MessageQueue {
    private final LinkedList<Message> queue = new LinkedList<>();
    private static final int DEFAULT_MAX_SIZE = 100;
    private volatile int limit;
    public MessageQueue(){
        this(DEFAULT_MAX_SIZE);
    }
    public MessageQueue(int limit) {
        this.limit = limit;
    }

    public void put(Message message) throws InterruptedException {
        synchronized (queue){
            while (queue.size()>limit){
                queue.wait();
            }
            queue.addLast(message);
            queue.notifyAll();
        }
    }
    public Message take()throws InterruptedException{
        synchronized (queue){
            while (queue.size()<=0){
                queue.wait();
            }
            Message message =queue.removeFirst();
            queue.notifyAll();
            return message;
        }
    }
    public int getMaxLimit(){
        return this.limit;
    }
    public int getQueueSize(){
        synchronized (queue){
            return queue.size();
        }
    }
}
