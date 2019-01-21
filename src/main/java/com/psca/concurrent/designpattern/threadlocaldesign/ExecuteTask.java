package com.psca.concurrent.designpattern.threadlocaldesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 22:59
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 22:59
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ExecuteTask implements Runnable {
    private final QueryFromDBAction queryFromDBAction = new QueryFromDBAction();
    private final QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();
    @Override
    public void run() {
        queryFromDBAction.execute();
        System.out.println("query from db successful");
        queryFromHttpAction.execute();
        System.out.println("query from http successful");
        Content context = ActionContent.getInstance().getContent();
        System.out.println("The Name is " + context.getName() + " and CardId " + context.getCardId());

    }
}
