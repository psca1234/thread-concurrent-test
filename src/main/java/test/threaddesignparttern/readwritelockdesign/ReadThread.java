package test.threaddesignparttern.readwritelockdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/24 15:06
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/24 15:06
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
        try {
            while(true){
                char [] resultBuffer =sharedData.read();
                System.out.println(Thread.currentThread().getName()+"\tget the result\t"+String.valueOf(resultBuffer));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
