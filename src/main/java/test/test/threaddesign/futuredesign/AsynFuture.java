package test.test.threaddesign.futuredesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 11:45
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 11:45
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AsynFuture<T> implements Future<T> {
    private volatile boolean finished =false;
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
