package test.concurrent.thread.twopharsedesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 10:10
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 10:10
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class CounterClient {
    public static void main(String[] args) throws InterruptedException {
        CounterIncrement increment = new CounterIncrement();
        increment.start();
        Thread.sleep(10_000L);
        increment.close();
    }
}
