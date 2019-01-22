package com.psca.concurrent.threaddesignpartterntest.suspensiondesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/22 20:52
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/22 20:52
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Request {
    private String sendData;

    public Request(String sendData) {
        this.sendData = sendData;
    }

    public String getSendData() {
        return sendData;
    }
}
