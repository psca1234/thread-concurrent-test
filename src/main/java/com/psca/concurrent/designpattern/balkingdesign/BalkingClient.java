package com.psca.concurrent.designpattern.balkingdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 23:10
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 23:10
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class BalkingClient {
    public static void main(String[] args) {
        BalkingData balkingData = new BalkingData("E:\\工作文件夹\\thread-concurrent-test\\src\\main\\java\\com\\psca\\concurrent\\designpattern\\balkingdesign\\balking.txt", "===BEGIN====");
        new ConsumerThread(balkingData).start();
        new WaiterThread(balkingData).start();
    }
}
