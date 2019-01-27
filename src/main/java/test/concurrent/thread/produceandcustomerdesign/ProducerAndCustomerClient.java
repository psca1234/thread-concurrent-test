package test.concurrent.thread.produceandcustomerdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 9:59
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 9:59
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ProducerAndCustomerClient {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        new ProducerThread(queue,1).start();
        new ProducerThread(queue,2).start();
        new ProducerThread(queue,3).start();
        new ProducerThread(queue,4).start();
        new CustomerThread(queue,1).start();
        new CustomerThread(queue,2).start();
    }
}
