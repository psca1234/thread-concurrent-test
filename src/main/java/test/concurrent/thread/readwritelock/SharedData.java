package test.concurrent.thread.readwritelock;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 14:36
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 14:36
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SharedData {
    private final ReadWriteLock lock = new ReadWriteLock();
    private final char [] buffer;

    public SharedData(int size) {
        buffer = new char[size];
        for(int i=0;i<size;i++){
            buffer[i] ='*';
        }
    }

    public char[] read()throws InterruptedException{
        try {
            lock.readLock();
            return this.doRead();
        }finally {
            lock.unReadLock();
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

    public void write(char n)throws InterruptedException{
        try{
            lock.writeLock();
            this.doWrite(n);
        }finally {
            lock.unWriteLock();
        }
    }

    private void doWrite(char n) {
        for(int i=0;i<buffer.length;i++){
            buffer[i]=n;
        }
    }

    private void slowly(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
