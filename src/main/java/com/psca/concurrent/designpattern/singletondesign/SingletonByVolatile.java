package com.psca.concurrent.designpattern.singletondesign;

import java.util.stream.IntStream;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 20:03
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 20:03
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SingletonByVolatile {
    private static volatile SingletonByVolatile singleton;

    private SingletonByVolatile(){}

    public static SingletonByVolatile getInstance(){
        if(null == singleton){
            synchronized (SingletonByVolatile.class){
                if(null == singleton){
                    singleton = new SingletonByVolatile();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1,20).forEach(i->new Thread("T"+String.valueOf(i)){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"\t"+SingletonByVolatile.getInstance());
            }
        }.start());
    }
}
