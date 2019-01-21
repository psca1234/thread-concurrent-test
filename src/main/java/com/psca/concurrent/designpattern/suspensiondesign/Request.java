package com.psca.concurrent.designpattern.suspensiondesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 22:31
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 22:31
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Request {
    private final String sendData;

    public Request(String sendData) {
        this.sendData = sendData;
    }

    public String getSendData() {
        return sendData;
    }
}
