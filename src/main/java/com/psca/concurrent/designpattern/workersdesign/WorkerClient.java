package com.psca.concurrent.designpattern.workersdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 23:25
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 23:25
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WorkerClient {
    public static void main(String[] args) {
        final Channel channel = new Channel(5);
        channel.start();

        new TransportThread("SHICHAO\tPAN",channel).start();
        new TransportThread("FANG\tYAN",channel).start();
        new TransportThread("AI\tNI",channel).start();
    }
}
