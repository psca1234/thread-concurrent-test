package com.psca.concurrent.designpattern.observerdesign;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 20:57
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 20:57
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadLifeCycleObserver implements LifeCycle {

    public void concurrentQuery(List<String> ids){
        if(ids !=null && !ids.isEmpty()){
            ids.stream().forEach(id->new Thread(new ObserverableRunning(this) {
                @Override
                public void run() {
                    try {
                        notifyChange(new RunnableEvent(Thread.currentThread(),RunnableState.RUNNING,null));
                        Thread.sleep(10_000L);
                        notifyChange(new RunnableEvent(Thread.currentThread(),RunnableState.DEAD,null));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        notifyChange(new RunnableEvent(Thread.currentThread(),RunnableState.ERROR,e));
                    }
                }
            },id).start());
        }
    }
    @Override
    public void onEvent(ObserverableRunning.RunnableEvent event) {
        synchronized (this) {
            System.out.println("The runnable [" + event.getThread().getName() + "] data changed and state is [" + event.getState() + "]");
            if (event.getCause() != null) {
                System.out.println("The runnable [" + event.getThread().getName() + "] process failed.");
                event.getCause().printStackTrace();
            }
        }
    }
}
