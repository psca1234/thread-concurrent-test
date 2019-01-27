package test.concurrent.thread.futuredesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 15:40
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 15:40
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AsynFutureClient {
    public static void main(String[] args) {
        FutureService futureService = new FutureService();
        futureService.submit(()->{
            try {
                Thread.sleep(1_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FANG\tYAN";
        },System.out::println);

        System.out.println("============================");
        System.out.println("do any other things");
        System.out.println("============================");
    }
}
