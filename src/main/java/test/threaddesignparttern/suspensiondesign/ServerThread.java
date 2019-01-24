package test.threaddesignparttern.suspensiondesign;

import com.psca.concurrent.designpattern.readandwritedesign.ReadWriteLock;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 23:44
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 23:44
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ServerThread extends Thread{
    private final RequestQueue queue;
    private final Random random= new Random(System.currentTimeMillis());
    private volatile boolean closed = false;

    public ServerThread(RequestQueue queue){
        super("Server->");
        this.queue = queue;
    }

    @Override
    public void run() {
        while(!closed){
            System.out.println(Thread.currentThread().getName()+"\t receive request from queue");
            Request request = queue.getRequest();
            if(null == request){
                System.out.println("Recived an empty request!");
                continue;
            }
            System.out.println(Thread.currentThread().getName()+"\t request:\t"+request.getSendData());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void close(){
        this.closed = true;
        this.interrupt();
    }
}
