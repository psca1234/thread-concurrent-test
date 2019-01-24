package test.threaddesignparttern.readwritelockdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/24 11:58
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/24 11:58
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SharedData {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public SharedData(int size){
        this.buffer = new char[size];
        for(int i=0;i<size;i++){
            buffer[i] ='*';
        }
    }

    public char[] read()throws InterruptedException{
        try {
            lock.readLock();
            return doRead();
        }finally {
            lock.unReadLock();
        }
    }

    private char[] doRead() {
        char [] newBuffer = new char[buffer.length];
        for(int i=0;i<buffer.length;i++){
            newBuffer[i] = buffer[i];
        }
        slowly(10);
        return newBuffer;
    }

    public void write(char c)throws InterruptedException{
        try{
            this.lock.writeLock();
            this.doWrite(c);
        }finally {
            this.lock.unWriteLock();
        }
    }

    private void doWrite(char c) {
        for(int i=0;i<buffer.length;i++){
            buffer[i] = c;
        }
        slowly(50);
    }

    private void slowly(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
