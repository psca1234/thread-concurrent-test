package com.psca.concurrent.threaddesignpartterntest.observerdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/22 20:29
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/22 20:29
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class RunnableEvent {
    private RunnableState state;
    private Thread targetThread;
    private Throwable cause;

    public RunnableState getState() {
        return state;
    }

    public Thread getTargetThread() {
        return targetThread;
    }

    public Throwable getCause() {
        return cause;
    }

    public RunnableEvent(RunnableState state, Thread targetThread, Throwable cause) {
        this.state = state;
        this.targetThread = targetThread;
        this.cause = cause;
    }
}
