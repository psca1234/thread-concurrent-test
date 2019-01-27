package test.concurrent.thread.workerdesign;

import java.util.Arrays;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 10:23
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 10:23
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Channel {
    private final static int MAX_REQUEST_SIZE =100;

    private final Request [] requestQueue;

    private int header;

    private int tail;

    private int count;

    private WorkerThread [] workerThreads;

    public Channel(int workerSize){
        requestQueue = new Request[MAX_REQUEST_SIZE];
        header=0;
        tail=0;
        count=0;
        workerThreads = new WorkerThread[workerSize];
        this.init();
    }

    private void init() {
        for(int i=0;i<workerThreads.length;i++){
            workerThreads[i] = new WorkerThread("Worker-"+i,this);
        }
    }

    public void startWork(){
        Arrays.asList(workerThreads).forEach(WorkerThread :: start);
    }

    public synchronized void put(Request request){
        while(count >=MAX_REQUEST_SIZE){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requestQueue[tail] = request;
        tail = (tail+1)%this.requestQueue.length;
        count++;
        this.notifyAll();
    }

    public synchronized Request take(){
        while(count<=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = requestQueue[header];
        header = (header+1)%this.requestQueue.length;
        count--;
        this.notifyAll();
        return request;
    }
}
