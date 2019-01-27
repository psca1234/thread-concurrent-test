package test.concurrent.thread.twopharsedesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 11:39
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 11:39
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AppServerClient {
    public static void main(String[] args)throws InterruptedException {
        AppServer server = new AppServer(13345);
        server.start();
        Thread.sleep(15_000L);
        server.shutdown();
    }
}
