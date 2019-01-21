package com.psca.concurrent.designpattern.readandwritedesign;

import java.util.stream.IntStream;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 21:56
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 21:56
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ReadWriteClient {
    public static void main(String[] args) {
        final SharedData sharedData = new SharedData(10);
        new ReadThread(sharedData).start();
        new ReadThread(sharedData).start();
        new ReadThread(sharedData).start();
        new ReadThread(sharedData).start();
        new WriteThread(sharedData,"pashichao\tai\tyanfang").start();
        new WriteThread(sharedData,"PANSHICHAO\tLOVE\tYANFANG").start();
    }
}
