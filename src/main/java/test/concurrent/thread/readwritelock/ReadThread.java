package test.concurrent.thread.readwritelock;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 14:46
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 14:46
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
        while(true){
            try {
                char [] messsage = sharedData.read();
                System.out.println(Thread.currentThread().getName()+"\t"+messsage);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
