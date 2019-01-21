package com.psca.concurrent.designpattern.threadlocaldesign;

import java.util.stream.IntStream;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 23:02
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 23:02
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ExecuteTaskClient {
    public static void main(String[] args) {
        IntStream.range(1, 5)
                .forEach(i ->
                        new Thread(new ExecuteTask()).start()
                );
    }
}
