package com.psca.concurrent.threaddesignpartterntest.observerdesign;



import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/22 20:34
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/22 20:34
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadLifeCycleObserver implements LifeCycle{
    public void concurrentQuery(List<String> ids){
        ids.stream().forEach(id->new Thread(new OberverableRunnable(this) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RunnableState.RUNNING,Thread.currentThread(),null));
                    Thread.sleep(1_000L);
                    notifyChange(new RunnableEvent(RunnableState.DONE,Thread.currentThread(),null));
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    notifyChange(new RunnableEvent(RunnableState.ERROR,Thread.currentThread(),e));
                }
            }
        }, id).start());
    }
    @Override
    public void onEvent(RunnableEvent event) {
        synchronized (this){
            System.out.println("The runnable [" + event.getTargetThread().getName() + "] data changed and state is [" + event.getState() + "]");
            if (event.getCause() != null) {
                System.out.println("The runnable [" + event.getTargetThread().getName() + "] process failed.");
                event.getCause().printStackTrace();
            }
        }
    }
}
