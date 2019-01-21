package com.psca.concurrent.designpattern.balkingdesign;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 23:03
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 23:03
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class BalkingData {
    private String fileName;
    private String context;
    private volatile boolean changed;

    public BalkingData(String fileName, String context) {
        this.fileName = fileName;
        this.context = context;
        this.changed = true;
    }

    public synchronized void change(String newContext){
        this.context= newContext;
        this.changed=true;
    }

    public synchronized void save()throws IOException {
        while (!changed){
            return;
        }
        doSave();
        this.changed=false;
    }

    private void doSave() throws IOException{
        System.out.println(Thread.currentThread().getName() + " calls do save,content=" + context);
        try (Writer writer = new FileWriter(fileName, true)) {
            writer.write(context);
            writer.write("\n");
            writer.flush();
        }
    }
}
