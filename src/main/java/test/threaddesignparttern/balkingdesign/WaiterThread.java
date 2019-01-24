package test.threaddesignparttern.balkingdesign;

import java.io.IOException;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 15:10
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 15:10
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WaiterThread extends Thread {
    private final BalkingData balkingData;
    public WaiterThread(BalkingData balkingData){
        super("Waiter->");
        this.balkingData = balkingData;
    }

    @Override
    public void run(){
        try {
            while(true){
                balkingData.save();
                Thread.sleep(1_000L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
