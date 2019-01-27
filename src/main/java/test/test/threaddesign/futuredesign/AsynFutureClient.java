package test.test.threaddesign.futuredesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 11:52
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 11:52
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AsynFutureClient{
    public static void main(String[] args) {
        FutureService<String> futureService = new FutureService<>();
        futureService.submit(()->{
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "SHICHAO\tPAN AI FANG\tYAN";
        },System.out :: println);

        System.out.println("=============================");
        System.out.println("do another things");
        System.out.println("=============================");
    }
}
