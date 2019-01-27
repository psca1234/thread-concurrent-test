package test.test.threaddesign.futuredesign;

import java.util.function.Consumer;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 11:44
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 11:44
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class FutureService<T> {
    public <T> Future<T> submit(final FutureTask<T> futureTask){
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(){
            @Override
            public void run() {
                T result = futureTask.call();
                asynFuture.done(result);
            }
        }.start();
        return asynFuture;
    }

    public <T> Future<T> submit(final FutureTask<T> futureTask, final Consumer<T> consumer){
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(){
            @Override
            public void run() {
                T result = futureTask.call();
                asynFuture.done(result);
                consumer.accept(result);
            }
        }.start();
        return asynFuture;
    }
}
