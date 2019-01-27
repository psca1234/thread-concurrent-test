package test.test.threaddesign.observerdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 12:42
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 12:42
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class RunningEvent {
    private Thread thread;
    private RunnableState state;
    private Throwable cause;

    public RunningEvent(Thread thread, RunnableState state, Throwable cause) {
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
