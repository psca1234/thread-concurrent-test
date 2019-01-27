package test.concurrent.thread.futuredesign;

import java.util.function.Consumer;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 15:32
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 15:32
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class FutureService<T> {
    public <T> Future<T> submit(FutureTask<T> futureTask){
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

    public <T> Future<T> submit(FutureTask<T> futureTask, Consumer<T> consumer){
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
