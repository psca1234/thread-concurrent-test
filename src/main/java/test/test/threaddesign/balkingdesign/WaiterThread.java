package test.test.threaddesign.balkingdesign;

import java.io.IOException;
import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 12:17
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 12:17
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WaiterThread extends Thread{
    private final BalkingData balkingData;
    private static final Random random = new Random(System.currentTimeMillis());

    public WaiterThread(final BalkingData balkingData,final String name) {
        super(name);
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        try {
            while(true){
                balkingData.save();
                Thread.sleep(random.nextInt(1000));
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
