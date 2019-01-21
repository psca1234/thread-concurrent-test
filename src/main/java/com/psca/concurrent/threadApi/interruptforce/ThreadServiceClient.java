package com.psca.concurrent.threadApi.interruptforce;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 16:31
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 16:31
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadServiceClient {
    public static void main(String[] args)throws InterruptedException {
        long startExecutedTs = System.currentTimeMillis();
        ThreadService.execute(() -> {
            while (true) {
            }
        });
        ThreadService.shutdown(20_000L);
        long endExecutedTs = System.currentTimeMillis();

        System.out.println("The thread interrupted and use time ts is\t" + (endExecutedTs - startExecutedTs));
    }
}
