package test.concurrent.thread.workerdesign;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 10:54
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 10:54
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class TransportThread extends Thread{
    private final Channel channel;

    private final static Random random = new Random(System.currentTimeMillis());

    public TransportThread(final String name ,final Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        for(int i=0;true;i++){
            Request request = new Request(getName(),i);
            channel.put(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
