package test.concurrent.thread.produceandcustomerdesign;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 9:47
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 9:47
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class CustomerThread extends Thread {
    private final MessageQueue queue;
    private final Random random = new Random(System.currentTimeMillis());

    public CustomerThread(MessageQueue queue,int seq){
        super("Customer->"+seq);
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Message message = queue.takeMessage();
                System.out.println(Thread.currentThread().getName()+"\t"+message.getSendMessage());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
