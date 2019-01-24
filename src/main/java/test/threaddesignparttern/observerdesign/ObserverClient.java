package test.threaddesignparttern.observerdesign;

import java.util.Arrays;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 13:22
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 13:22
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ObserverClient {
    public static void main(String[] args) {
        ThreadLifeCycleObserver threadLifeCycleObserver = new ThreadLifeCycleObserver();
        threadLifeCycleObserver.concurrentQuery(Arrays.asList("T1","T2","T3","T4","T5","T6","T7"));
        System.out.println("the counter return is\t"+threadLifeCycleObserver.getCounter());
    }
}
