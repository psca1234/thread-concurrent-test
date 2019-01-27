package test.test.threaddesign.observerdesign;

import java.util.Arrays;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/27 12:52
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/27 12:52
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycle().concurrentQuery(Arrays.asList("1","2","3","4"));
    }
}
