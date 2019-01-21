package com.psca.concurrent.designpattern.readandwritedesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 21:43
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 21:43
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SharedData {
    private final char[] buffer;
    private final ReadWriteLock lock=new ReadWriteLock();

    public SharedData(int size){
        this.buffer = new char[size];
        for(int i=0;i<buffer.length;i++){
            buffer[i] = '*';
        }
    }

    public char[] read()throws InterruptedException{
        try{
            lock.readLock();
            return this.doRead();
        }finally {
            lock.unReadLock();
        }
    }

    public void write(char c)throws InterruptedException{
        try{
            lock.writeLock();
            this.doWrite(c);
        }finally {
            lock.unWriteLock();
        }
    }

    private void doWrite(char c) {
        for(int i=0;i<buffer.length;i++){
            buffer[i] = c;
            slowly(10);
        }
    }

    private char[] doRead() {
        char [] newBuffer = new char[buffer.length];
        for(int i=0;i<buffer.length;i++){
            newBuffer[i] = buffer[i];
        }
        slowly(50);
        return newBuffer;
    }



    private void slowly(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
}
