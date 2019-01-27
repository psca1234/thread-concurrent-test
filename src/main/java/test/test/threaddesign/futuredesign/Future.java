package test.test.threaddesign.futuredesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 11:44
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 11:44
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface Future<T> {
    T get()throws InterruptedException;
}
