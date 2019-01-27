package test.concurrent.thread.produceandcustomerdesign;

import java.util.LinkedList;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 9:31
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 9:31
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MessageQueue {
    private final LinkedList<Message> queue = new LinkedList<>();
    private int limit;
    private final static int DEFAUTL_MAX_SIZE=100;
    public MessageQueue(){
        this(DEFAUTL_MAX_SIZE);
    }

    public MessageQueue(int limit) {
        this.limit = limit;
    }

    public Message takeMessage()throws InterruptedException{
        synchronized (queue){
            while(queue.size()<=0){
                this.queue.wait();
            }
            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;
        }
    }

    public void putMessage(Message message)throws InterruptedException{
        synchronized (queue){
            while(queue.size()>limit){
                queue.wait();
            }
            queue.addLast(message);
            queue.notifyAll();
        }
    }
}
