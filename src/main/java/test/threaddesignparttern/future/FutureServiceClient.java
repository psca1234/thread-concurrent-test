package test.threaddesignparttern.future;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 14:31
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 14:31
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class FutureServiceClient {
    public static void main(String[] args) {
        FutureService futureService = new FutureService();
        futureService.submit(()->{
            try {
                Thread.sleep(1_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        },System.out::println);

        System.out.println("===============");
        System.out.println("do another things");
        System.out.println("===============");
    }
}
