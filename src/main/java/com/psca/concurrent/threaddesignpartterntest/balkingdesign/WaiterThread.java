package com.psca.concurrent.threaddesignpartterntest.balkingdesign;

import java.io.IOException;
import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/22 12:06
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/22 12:06
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WaiterThread extends Thread {
    private final BalkingData balkingData;
    public WaiterThread(BalkingData balkingData){
        super("Waiter");
        this.balkingData =balkingData;
    }

    @Override
    public void run() {
        try{
            for(int i=0;i<200;i++){
                balkingData.save();
                Thread.sleep(1500L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
