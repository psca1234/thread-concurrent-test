package test.threaddesignparttern.observerdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 12:45
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 12:45
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface LifeCycle {
    void onEvent(RunnableEvent event);
}
