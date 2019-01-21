package com.psca.concurrent.threadApi.threadlocal;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 19:33
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 19:33
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadLocalSimple {
    private static final ThreadLocal<String> threadlocal=new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "SHICHAO\tPAN";
        }
    };

    public static void main(String[] args) {
        String result = threadlocal.get();
        System.out.println(Thread.currentThread().getName()+"\t get threadlocal value is\t"+result);
        new Thread(()->{
            threadlocal.set("FANG\tYAN");
            try {
                Thread.sleep(1_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String threadResult = threadlocal.get();
            System.out.println(Thread.currentThread().getName()+"\t get threadlocal value is\t"+threadResult);
        },"t1").start();


    }
}
