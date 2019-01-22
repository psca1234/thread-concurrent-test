package com.psca.concurrent.designpattern.countdowndesign;

import java.util.stream.IntStream;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/22 9:30
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/22 9:30
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface SimulatonCountDowmClient {
    public static void main(String[] args) throws InterruptedException{
        SimulationCountDown simulationCountDown = new SimulationCountDown(5);
        IntStream.rangeClosed(1,5).forEach(i->new Thread(String.valueOf(i)){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"\tbegin working.");
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\tends working.");
                simulationCountDown.countdown();
            }
        }.start());
        simulationCountDown.await();
        System.out.println("All task executed done");
    }
}
