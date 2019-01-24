package test.threaddesignparttern.balkingdesign;

import java.io.IOException;
import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 15:09
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 15:09
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class CustomerThread extends Thread {
    private final BalkingData balkingData;
    private final Random random = new Random(System.currentTimeMillis());

    public CustomerThread(BalkingData balkingData){
        super("Customer->");
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        try {
            balkingData.save();
            for(int i =1;i<=20;i++){
                balkingData.change("No"+i);
                Thread.sleep(random.nextInt(1000));
                balkingData.save();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
