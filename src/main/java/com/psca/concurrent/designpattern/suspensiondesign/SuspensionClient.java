package com.psca.concurrent.designpattern.suspensiondesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 22:46
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 22:46
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SuspensionClient {
    public static void main(String[] args)throws InterruptedException {
        ReuqestQueue queue = new ReuqestQueue();
        new ClientThread(queue, "Alex").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();
        Thread.sleep(100_000);
        serverThread.close();
    }
}
