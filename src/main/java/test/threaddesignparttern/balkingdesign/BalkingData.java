package test.threaddesignparttern.balkingdesign;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/23 14:55
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/23 14:55
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class BalkingData {
    private final String fileName;
    private String context;
    private volatile boolean changed;
    private final Random random = new Random(System.currentTimeMillis());

    public BalkingData(String fileName, String context) {
        this.fileName = fileName;
        this.context = context;
        this.changed =false;
    }

    public synchronized void change(String newContext){
        this.changed =true;
        this.context =newContext;
    }

    public synchronized void save()throws InterruptedException,IOException{
        while(!changed){
            return;
        }
        doSave();
        this.changed = false;
    }

    private void doSave()throws IOException {
        System.out.println(Thread.currentThread().getName()+"\t call do save\t"+context);
        try(Writer writer = new FileWriter(this.fileName,true)){
            writer.write(context);
            writer.write("\n");
            writer.flush();
        }
    }
}
