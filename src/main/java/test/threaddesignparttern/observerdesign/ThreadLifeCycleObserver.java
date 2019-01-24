package test.threaddesignparttern.observerdesign;

import java.util.List;
import java.util.Optional;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 12:47
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 12:47
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadLifeCycleObserver implements LifeCycle{
    private volatile int counter=0;
    public void concurrentQuery(List<String> ids){
        ids.stream().forEach(id->new Thread(new ObserverableRunning(this) {
            @Override
            public void run() {
                try {
                    if(counter >5){
                        throw new RuntimeException("出错了");
                    }
                    System.out.println("The current thread begins working.");
                    notifyChange(new RunnableEvent(Thread.currentThread(),RunnableState.RUNNING,null));
                    counter++;
                    Thread.sleep(1_000L);
                    notifyChange(new RunnableEvent(Thread.currentThread(),RunnableState.DONE,null));
                } catch (Exception e) {
                    notifyChange(new RunnableEvent(Thread.currentThread(),RunnableState.ERROR,e));
                }
            }
        }, id).start());
    }

    @Override
    public void onEvent(RunnableEvent event) {
        synchronized (this){
            if(null !=event){
                System.out.println("The thread \t"+event.getThread().getName()+"\t"+event.getState());
//                Optional.of(event.getCause().getMessage()).ifPresent(System.out :: println);
            }
        }
    }

    public int getCounter(){
        return this.counter;
    }
}
