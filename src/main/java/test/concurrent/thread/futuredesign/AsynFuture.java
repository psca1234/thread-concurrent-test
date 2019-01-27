package test.concurrent.thread.futuredesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 15:33
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 15:33
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AsynFuture<T> implements Future<T>{
    private volatile boolean finished;
    private T result;
    public void done(T result){
        synchronized (this){
            this.result = result;
            this.finished = true;
            this.notifyAll();
        }
    }
    @Override
    public T get() throws InterruptedException{
        synchronized (this){
            while(!finished){
                this.wait();
            }
        }
        return result;
    }
}
