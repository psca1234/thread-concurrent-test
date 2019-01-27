package test.concurrent.thread.produceandcustomerdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 9:09
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 9:09
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Message {
    private String sendMessage;

    public Message(String sendMessage) {
        this.sendMessage = sendMessage;
    }

    public String getSendMessage() {
        return sendMessage;
    }
}
