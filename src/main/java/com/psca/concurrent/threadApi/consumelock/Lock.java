package com.psca.concurrent.threadApi.consumelock;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 18:11
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 18:11
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface Lock {
    public static class TimeoutException extends RuntimeException{
        public TimeoutException(String message){
            super(message);
        }
    }

    void lock()throws InterruptedException;

    void lock(long executedTs)throws InterruptedException,TimeoutException;

    void unlock();


}
