package test.concurrent.thread.workerdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 11:34
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 11:34
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WorkerClient {
    public static void main(String[] args) {
        final Channel channel = new Channel(5);

        channel.startWork();

        new TransportThread("SHICHAO\tPAN",channel).start();
        new TransportThread("FANG\tYAN",channel).start();
        new TransportThread("AI",channel).start();
    }
}
