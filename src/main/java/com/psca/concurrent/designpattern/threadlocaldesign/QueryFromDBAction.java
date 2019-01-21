package com.psca.concurrent.designpattern.threadlocaldesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 22:51
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 22:51
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class QueryFromDBAction {
    public void execute() {
        try {
            Thread.sleep(1000L);
            String name = "Alex " + Thread.currentThread().getName();
            ActionContent.getInstance().getContent().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
