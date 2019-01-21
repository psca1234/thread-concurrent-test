package com.psca.concurrent.threadApi.consumelock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 18:13
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 18:13
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class BooleanLock implements Lock {
    private final List<Thread>  blockList = new ArrayList<>();

    private volatile static boolean locked = false;

    private Thread targetThread;
    @Override
    public synchronized void lock() throws InterruptedException {
        while (locked){
            this.wait();
            blockList.add(Thread.currentThread());
        }
        locked =true;
        blockList.remove(Thread.currentThread());
        this.targetThread = Thread.currentThread();
    }

    @Override
    public synchronized void lock(long executedTs) throws InterruptedException, TimeoutException {
        if(executedTs <=0){
            lock();
        }
        long hasExecutedTs = executedTs;
        long endExecutedTs = System.currentTimeMillis()+executedTs;
        while(locked){
            if(hasExecutedTs <=0){
                throw new Lock.TimeoutException(Thread.currentThread().getName()+"\tTime out...");
            }
            hasExecutedTs = endExecutedTs-System.currentTimeMillis();
            this.wait();
            blockList.add(Thread.currentThread());
        }
        locked = true;
        blockList.remove(Thread.currentThread());
        this.targetThread = Thread.currentThread();

    }

    @Override
    public synchronized void unlock(){
        if(this.targetThread == Thread.currentThread()){
            this.locked = false;
            this.notifyAll();
            blockList.remove(Thread.currentThread());
        }
    }
}
