package com.psca.concurrent.designpattern.workersdesign;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 22:51
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 22:51
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WorkerThread extends Thread {
    private String name;
    private Channel channel;
    private final static Random random = new Random(System.currentTimeMillis());
    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while(true){
            channel.take().execute();
            try {
                Thread.sleep(random.nextInt(1_000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
