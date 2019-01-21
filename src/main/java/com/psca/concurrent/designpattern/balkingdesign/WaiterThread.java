package com.psca.concurrent.designpattern.balkingdesign;

import java.io.IOException;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 23:09
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 23:09
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WaiterThread extends Thread{
    private final BalkingData balkingData;

    public WaiterThread(BalkingData balkingData) {
        super("Waiter");
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            try {
                balkingData.save();
                Thread.sleep(1_000L);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
