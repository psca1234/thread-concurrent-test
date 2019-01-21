package com.psca.concurrent.designpattern.observerdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 20:50
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 20:50
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public abstract class ObserverableRunning implements Runnable {
    private LifeCycle lifeCycle;

    public ObserverableRunning(LifeCycle lifeCycle){
        this.lifeCycle = lifeCycle;
    }

    protected void notifyChange(final RunnableEvent event){
        lifeCycle.onEvent(event);
    }

    public enum RunnableState{
        RUNNING,BLOCK,DEAD,ERROR
    }

    public static class RunnableEvent{
        private Thread thread;
        private RunnableState state;
        private Throwable cause;

        public RunnableEvent(Thread thread, RunnableState state, Throwable cause) {
            this.thread = thread;
            this.state = state;
            this.cause = cause;
        }

        public Thread getThread() {
            return thread;
        }

        public RunnableState getState() {
            return state;
        }

        public Throwable getCause() {
            return cause;
        }
    }
}
