package com.psca.concurrent.threadApi.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 19:41
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 19:41
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SimulationThreadLocal<T> {
    private final Map<Thread,T> map = new HashMap<>();

    public synchronized T get(){
        return map.get(Thread.currentThread());
    }

    public synchronized void set(T value){
        map.put(Thread.currentThread(),value);
    }

    protected T initialValue(){
        return map.put(Thread.currentThread(),(T)"hello thread local");
    }
}
