package test.concurrent.thread.readwritelock;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 14:28
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 14:28
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ReadWriteLock {
    private int waittingreaders;
    private int readingreaders;
    private int waittingwriters;
    private int writtingwriters;
    private boolean prefer;
    public ReadWriteLock(){
        this(true);
    }

    public ReadWriteLock(boolean prefer) {
        this.prefer = prefer;
    }

    public synchronized void readLock()throws InterruptedException{
        this.waittingreaders++;
        while(this.writtingwriters>0 || (prefer && this.waittingwriters>0)){
            this.wait();
        }
        this.readingreaders++;
        this.waittingreaders--;
    }

    public synchronized void unReadLock(){
        this.readingreaders--;
        this.notifyAll();
    }

    public synchronized void writeLock()throws InterruptedException{
        this.waittingwriters++;
        while(this.readingreaders>0 || this.writtingwriters>0){
            this.wait();
        }
        this.writtingwriters++;
        this.waittingwriters--;
    }

    public synchronized void unWriteLock(){
        this.writtingwriters--;
        this.notifyAll();
    }
}
