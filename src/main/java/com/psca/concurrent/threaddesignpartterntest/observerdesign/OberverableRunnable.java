package com.psca.concurrent.threaddesignpartterntest.observerdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/22 20:28
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/22 20:28
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public abstract class OberverableRunnable implements Runnable {
    private LifeCycle lifeCycle;

    public OberverableRunnable(LifeCycle lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public void notifyChange(RunnableEvent event){
        lifeCycle.onEvent(event);
    }


}
