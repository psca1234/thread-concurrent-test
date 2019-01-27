package test.test.threaddesign.readwritelockdesign;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 14:23
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 14:23
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WriteThread extends Thread{
    private final SharedData sharedData;

    private String fillter;

    private static final Random random = new Random(System.currentTimeMillis());

    private int index;

    public WriteThread(SharedData sharedData,String fillter) {
        this.sharedData = sharedData;
        this.fillter = fillter;
    }

    @Override
    public void run() {
        try{
            while(true){
                char c = nextChar();
                sharedData.write(c);
                Thread.sleep(random.nextInt(1000));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private char nextChar(){
        char c = fillter.charAt(index);
        index++;
        if(index>fillter.length()){
            index=0;
        }
        return c;
    }
}
