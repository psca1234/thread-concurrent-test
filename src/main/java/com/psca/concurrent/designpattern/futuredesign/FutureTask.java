package com.psca.concurrent.designpattern.futuredesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 22:16
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 22:16
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface FutureTask<T> {
    T call();
}
