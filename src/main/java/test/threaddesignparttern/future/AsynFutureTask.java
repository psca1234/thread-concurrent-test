package test.threaddesignparttern.future;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 13:44
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 13:44
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AsynFutureTask<T> implements Future<T>{
    private T result;

    private volatile boolean finished = false;

    public void done(T result){
        synchronized (this){
            this.result = result;
            this.finished=true;
            this.notifyAll();
        }
    }
    @Override
    public T get() {
        synchronized (this){
            while(!finished) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }
}
