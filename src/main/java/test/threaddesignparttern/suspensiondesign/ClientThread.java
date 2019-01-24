package test.threaddesignparttern.suspensiondesign;

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
public class ClientThread extends Thread{
    private final RequestQueue queue;
    private final String sendMessage;
    private final Random random = new Random(System.currentTimeMillis());

    public ClientThread(RequestQueue queue,String sendMessage){
        this.queue = queue;
        this.sendMessage = sendMessage;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println("Client->request\t"+sendMessage);
            queue.putRequest(new Request(sendMessage));
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
