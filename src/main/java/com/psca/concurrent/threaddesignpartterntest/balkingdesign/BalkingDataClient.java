package com.psca.concurrent.threaddesignpartterntest.balkingdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/22 12:12
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/22 12:12
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class BalkingDataClient {
    public static void main(String[] args) {
        BalkingData data = new BalkingData("E:\\工作文件夹\\thread-concurrent-test\\src\\main\\resource\\balkingData.txt","===BEGIN====");
        new CustomerThread(data).start();
        Thread waiterThread =new WaiterThread(data);
        waiterThread.setDaemon(true);
        waiterThread.start();
        System.out.println(""+Thread.currentThread().getState());
    }
}
