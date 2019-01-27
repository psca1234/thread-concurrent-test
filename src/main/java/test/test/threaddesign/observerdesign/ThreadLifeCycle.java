package test.test.threaddesign.observerdesign;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 12:44
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 12:44
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadLifeCycle implements LifeCycle {
    public void concurrentQuery(List<String> ids){
        ids.stream().forEach(id->new Thread(
                new ObserverableRunnable(this) {
                    @Override
                    public void run() {
                        try {
                            notifyChange(new RunningEvent(Thread.currentThread(),RunnableState.RUNNING,null));
                            Thread.sleep(100L);
                            int result = 1/0;
                            System.out.println(Thread.currentThread().getName()+"\t"+result);
                            notifyChange(new RunningEvent(Thread.currentThread(),RunnableState.DONE,null));
                        } catch (Exception e) {
                            //e.printStackTrace();
                            notifyChange(new RunningEvent(Thread.currentThread(),RunnableState.ERROE,e));
                        }
                    }
                }
        ,id).start());
    }
    @Override
    public void onEvent(RunningEvent event) {
        synchronized (this){
            if(event.getCause() !=null){
                System.out.println(event.getThread().getName()+"\t"+event.getState()+"\t"+event.getCause().getMessage());
            }else{
                System.out.println(event.getThread().getName()+"\t"+event.getState()+"\t");
            }
        }
    }
}
