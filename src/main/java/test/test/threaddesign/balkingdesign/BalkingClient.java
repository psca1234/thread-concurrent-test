package test.test.threaddesign.balkingdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 12:30
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 12:30
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class BalkingClient {
    public static void main(String[] args) {
        BalkingData balkingData = new BalkingData("E:\\balking.txt","===BEGIN====");

        new CustomerThread(balkingData,"Customer").start();

        new WaiterThread(balkingData,"Waiter").start();
    }
}
