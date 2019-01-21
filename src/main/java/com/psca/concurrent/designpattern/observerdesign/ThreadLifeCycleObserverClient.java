package com.psca.concurrent.designpattern.observerdesign;

import java.util.Arrays;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 21:04
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 21:04
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadLifeCycleObserverClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1","2","3","4"));
    }
}
