package test.test.threaddesign.balkingdesign;

import java.io.IOException;
import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 12:13
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 12:13
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class CustomerThread extends Thread{
    private final BalkingData balkingData;
    private static final Random random = new Random(System.currentTimeMillis());

    public CustomerThread(final BalkingData balkingData,final String name) {
        super(name);
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        try{
            balkingData.save();
            for(int i=0;i<20;i++){
                balkingData.change(Thread.currentThread().getName()+"No"+i);
                Thread.sleep(random.nextInt(1_000));
                balkingData.save();
            }
        }catch (IOException e){

        }catch (InterruptedException ex){

        }
    }
}
