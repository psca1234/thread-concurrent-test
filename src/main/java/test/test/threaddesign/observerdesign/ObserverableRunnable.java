package test.test.threaddesign.observerdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 12:40
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 12:40
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public abstract class ObserverableRunnable implements Runnable {
    private final LifeCycle lifeCycle;

    public ObserverableRunnable(LifeCycle lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public void notifyChange(RunningEvent event){
        lifeCycle.onEvent(event);
    }
}
