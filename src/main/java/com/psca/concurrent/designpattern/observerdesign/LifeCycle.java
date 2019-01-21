package com.psca.concurrent.designpattern.observerdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 20:51
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 20:51
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface LifeCycle {
    void onEvent(ObserverableRunning.RunnableEvent event);
}
