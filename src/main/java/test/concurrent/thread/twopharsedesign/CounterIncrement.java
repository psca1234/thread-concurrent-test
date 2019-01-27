package test.concurrent.thread.twopharsedesign;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 10:05
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 10:05
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class CounterIncrement extends Thread {
    private volatile boolean terminated = false;
    private final Random random = new Random(System.currentTimeMillis());
    private int counter=0;

    @Override
    public void run() {
        try{
            while(!terminated){
                System.out.println(Thread.currentThread().getName()+"\t"+counter++);
                Thread.sleep(random.nextInt(1000));
            }
        }catch (InterruptedException e){

        }finally {
            clean();
        }
    }
    private void clean(){
        System.out.println("do something for clean resouces\t"+counter);
    }
    public void close(){
        this.terminated = true;
        this.interrupt();
    }
}
