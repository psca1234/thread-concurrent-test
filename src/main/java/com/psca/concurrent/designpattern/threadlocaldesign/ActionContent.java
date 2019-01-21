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
public class ActionContent {
    private final ThreadLocal<Content> threadLocal = new ThreadLocal<Content>(){
        @Override
        protected Content initialValue() {
            return new Content();
        }
    };
    private ActionContent(){}

    private enum ActionContentSingleton{
        INSTANCE;
        private ActionContent actionContent;
        ActionContentSingleton(){
            this.actionContent = new ActionContent();
        }
        public ActionContent getActionContent(){
            return this.actionContent;
        }
    }

    public static ActionContent getInstance(){
        return ActionContentSingleton.INSTANCE.getActionContent();
    }

    public Content getContent(){
        return threadLocal.get();
    }
}
