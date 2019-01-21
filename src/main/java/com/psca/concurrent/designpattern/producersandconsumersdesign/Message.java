package com.psca.concurrent.designpattern.producersandconsumersdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 21:07
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 21:07
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Message {
    private String sendData;

    public Message(String sendData) {
        this.sendData = sendData;
    }

    public String getSendData() {
        return sendData;
    }
}
