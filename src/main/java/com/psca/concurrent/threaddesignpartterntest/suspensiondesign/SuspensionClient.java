package com.psca.concurrent.threaddesignpartterntest.suspensiondesign;

import com.psca.concurrent.designpattern.suspensiondesign.ClientThread;
import com.psca.concurrent.designpattern.suspensiondesign.ReuqestQueue;
import com.psca.concurrent.designpattern.suspensiondesign.ServerThread;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/22 21:09
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/22 21:09
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SuspensionClient {
    public static void main(String[] args) throws InterruptedException{
        ReuqestQueue queue = new ReuqestQueue();
        new ClientThread(queue, "Alex").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();
        Thread.sleep(1_000);
        serverThread.close();
    }
}
