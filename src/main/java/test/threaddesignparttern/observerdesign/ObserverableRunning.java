package test.threaddesignparttern.observerdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 12:38
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 12:38
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public abstract class ObserverableRunning implements Runnable{
    private LifeCycle lifeCycle;

    public ObserverableRunning(LifeCycle lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    protected void notifyChange(RunnableEvent event){
        lifeCycle.onEvent(event);
    }
}
