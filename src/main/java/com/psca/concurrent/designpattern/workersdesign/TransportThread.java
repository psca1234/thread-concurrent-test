package com.psca.concurrent.designpattern.workersdesign;

import com.psca.concurrent.designpattern.readandwritedesign.ReadWriteLock;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 23:17
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 23:17
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class TransportThread extends Thread {
    private Channel channel;

    private final static Random random = new Random(System.currentTimeMillis());

    public TransportThread(String name,Channel channel){
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            for(int i=0;true;i++){
                Request request = new Request(getName(),i);
                channel.put(request);
                Thread.sleep(random.nextInt(1_000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
