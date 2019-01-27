package com.psca.concurrent.designpattern.workersdesign;

import java.util.Arrays;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 22:50
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 22:50
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Channel {
    private final static int MAX_REQUEST_SIZE=100;

    private final Request [] requests;

    private int header;

    private int tail;

    private int count;

    private final WorkerThread [] workerThreads;

    public Channel(int workers) {
        this.requests = new Request[MAX_REQUEST_SIZE];
        this.header = 0;
        this.tail = 0;
        this.count = 0;
        workerThreads = new WorkerThread[workers];
        init();
    }

    private void init() {
        for(int i=0;i<workerThreads.length;i++){
            workerThreads[i] = new WorkerThread("Worker-" + i, this);
        }
    }

    public void start(){
        Arrays.asList(workerThreads).forEach(WorkerThread :: start);
    }

    public synchronized void put(Request request){
        while(this.count >= MAX_REQUEST_SIZE){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requests[tail] =request;
        tail = (tail +1)%requests.length;
        count++;
        this.notifyAll();
    }

    public synchronized Request take(){
        while(this.count<=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = requests[header];
        header = (header+1) %this.requests.length;
        count--;
        this.notifyAll();
        return request;
    }
}
