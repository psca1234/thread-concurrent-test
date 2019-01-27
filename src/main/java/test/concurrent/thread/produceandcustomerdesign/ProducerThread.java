package test.concurrent.thread.produceandcustomerdesign;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 9:40
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 9:40
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ProducerThread extends Thread {
    private final Random random = new Random(System.currentTimeMillis());
    private AtomicInteger counter = new AtomicInteger(0);
    private final MessageQueue queue;
    public ProducerThread(MessageQueue queue,int seq){
        super("Producer->"+seq);
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Message message = new Message("Message"+counter.getAndIncrement());
                queue.putMessage(message);
                System.out.println(Thread.currentThread().getName()+"\t"+message);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
