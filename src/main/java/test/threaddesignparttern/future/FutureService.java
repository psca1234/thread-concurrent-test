package test.threaddesignparttern.future;

import com.psca.concurrent.designpattern.futuredesign.AsynFuture;

import java.util.function.Consumer;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 13:43
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 13:43
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class FutureService<T> {
    public <T> Future<T> submit(final FutureTask<T> futureTask){
        AsynFutureTask<T> asynFutureTask = new AsynFutureTask<>();
        new Thread(()->{
            T result = futureTask.call();
            asynFutureTask.done(result);
        }).start();
        return asynFutureTask;
    }

    public <T> Future<T> submit(final FutureTask<T> futureTask, Consumer<T> consumer){
        AsynFutureTask<T> asynFuture = new AsynFutureTask<>();
        new Thread(()->{
            T reuslt =futureTask.call();
            asynFuture.done(reuslt);
            consumer.accept(reuslt);
        }).start();
        return asynFuture;
    }
}
