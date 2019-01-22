package com.psca.concurrent.threaddesignpartterntest.suspensiondesign;

import java.util.LinkedList;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/22 20:52
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/22 20:52
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class RequestQueue {
    private final LinkedList<Request> queue = new LinkedList<>();

    public void putRequest(Request request){
        synchronized (queue){
            queue.addLast(request);
            queue.notifyAll();
        }
    }

    public Request getRequest(){
        synchronized (queue){
            while(queue.size()<=0){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    return null;
                }
            }
            return queue.removeFirst();
        }
    }
}
