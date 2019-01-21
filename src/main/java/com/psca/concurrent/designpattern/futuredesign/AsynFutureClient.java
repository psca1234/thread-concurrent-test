package com.psca.concurrent.designpattern.futuredesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 22:25
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 22:25
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AsynFutureClient {
    public static void main(String[] args) {
        FutureServce futureServce = new FutureServce();
        futureServce.submit(()->{
            try {
                Thread.sleep(1_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "YANFANG";
        },System.out::println);

        System.out.println("==============");
        System.out.println("do other things");
        System.out.println("==============");
    }
}
