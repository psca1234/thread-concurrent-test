package com.psca.concurrent.threadApi.threadlocal;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 19:44
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 19:44
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SimulationThreadLocalClient {
    public static void main(String[] args) {
        SimulationThreadLocal<String> threadLocal = new SimulationThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return "FANY\tYAN";
            }
        };

        String result = threadLocal.get();
        System.out.println(Thread.currentThread().getName()+"\t thread local values is\t"+result);

        new Thread(()->{
            threadLocal.set("SHICHAO\tPAN");
            try {
                Thread.sleep(1_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String retVal = threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"\tthread local values is\t"+retVal);
        },"t1").start();

    }
}
