package test.concurrent.thread.workerdesign;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 10:23
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 10:23
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WorkerThread extends Thread{
    private final static Random random = new Random(System.currentTimeMillis());
    private static Channel channel;
    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while(true){
            channel.take().execute();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
