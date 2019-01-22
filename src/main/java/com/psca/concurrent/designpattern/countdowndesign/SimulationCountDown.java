package com.psca.concurrent.designpattern.countdowndesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/22 9:25
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/22 9:25
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SimulationCountDown {
    private volatile int limit;

    public SimulationCountDown(int limit) {
        this.limit = limit;
    }

    public synchronized void countdown(){
        limit--;
        this.notify();
    }

    public synchronized void await()throws InterruptedException{
        if(limit>0){
            this.wait();
        }
    }
}
