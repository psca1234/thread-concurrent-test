package com.psca.concurrent.designpattern.readandwritedesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 21:51
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 21:51
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ReadThread extends Thread {
    private final SharedData sharedData;

    public ReadThread(SharedData sharedData){
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        try{
            while (true){
                char [] buffer = sharedData.read();
                System.out.println(Thread.currentThread().getName()+"\tget the result\t"+String.valueOf(buffer));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
