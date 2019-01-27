package test.concurrent.thread.readwritelock;

import com.psca.concurrent.designpattern.readandwritedesign.ReadThread;
import com.psca.concurrent.designpattern.readandwritedesign.SharedData;
import com.psca.concurrent.designpattern.readandwritedesign.WriteThread;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 15:28
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 15:28
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ReadWriteLockClient {
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
