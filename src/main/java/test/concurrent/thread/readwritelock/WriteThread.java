package test.concurrent.thread.readwritelock;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 14:53
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 14:53
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WriteThread extends Thread{
    private final SharedData sharedData;
    private final Random random = new Random(System.currentTimeMillis());
    private String filler;
    private int index=0;

    public WriteThread(SharedData sharedData, String filler) {
        this.sharedData = sharedData;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            while(true){
                char c = this.nextChar();
                sharedData.write(c);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar(){
        char c = filler.charAt(index);
        index++;
        if(index >=filler.length()){
            index =0;
        }
        return c;
    }
}
