package test.test.threaddesign.readwritelockdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 14:19
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 14:19
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ReadThread extends Thread{
    private final SharedData sharedData;

    public ReadThread(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while(true){
            try {
                char [] result= sharedData.read();
                System.out.println(Thread.currentThread().getName()+"\t get the result is\t"+String.valueOf(result));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
