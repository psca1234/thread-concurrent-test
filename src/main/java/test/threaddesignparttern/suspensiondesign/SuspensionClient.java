package test.threaddesignparttern.suspensiondesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 23:45
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 23:45
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SuspensionClient {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();
        new ClientThread(queue,"SHICHAO\tPAN").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serverThread.close();
    }
}
