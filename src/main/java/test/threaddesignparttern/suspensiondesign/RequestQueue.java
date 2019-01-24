package test.threaddesignparttern.suspensiondesign;

import java.util.LinkedList;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 23:38
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 23:38
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class RequestQueue {
    private LinkedList<Request> queue = new LinkedList<>();


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

    public void putRequest(Request request){
        synchronized (queue){
            queue.addLast(request);
            queue.notifyAll();
        }
    }
}
