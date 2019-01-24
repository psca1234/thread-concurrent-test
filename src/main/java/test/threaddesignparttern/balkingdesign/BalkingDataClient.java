package test.threaddesignparttern.balkingdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 15:38
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 15:38
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class BalkingDataClient {
    public static void main(String[] args) {
        BalkingData balkingData = new BalkingData("E:\\balkingData.txt","========Hello\tWorld=========");
        CustomerThread customerThread = new CustomerThread(balkingData);
        customerThread.start();
        WaiterThread waiterThread = new WaiterThread(balkingData);
        waiterThread.setDaemon(true);
        waiterThread.start();
    }
}
