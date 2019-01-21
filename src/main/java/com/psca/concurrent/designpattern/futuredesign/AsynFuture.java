package com.psca.concurrent.designpattern.futuredesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 22:18
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 22:18
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AsynFuture<T> implements Future<T> {
    private T result;
    private volatile boolean done = false;

    public void done(T result){
        synchronized (this){
            this.done= true;
            this.notifyAll();
            this.result = result;
        }
    }
    @Override
    public T get() throws InterruptedException{
        synchronized (this){
            while (!done){
                this.wait();
            }
        }
        return result;
    }
}
