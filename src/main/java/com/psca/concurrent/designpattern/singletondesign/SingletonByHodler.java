package com.psca.concurrent.designpattern.singletondesign;

import java.util.stream.IntStream;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 20:25
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 20:25
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SingletonByHodler {
    private static SingletonByHodler singletonByHoder;

    private SingletonByHodler(){}

    private static class SinletonByHodlerInstance{
        private static final SingletonByHodler singletonByHolder = new SingletonByHodler();
    }

    public static SingletonByHodler getInstance(){
        return SinletonByHodlerInstance.singletonByHolder;
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1,20).forEach(i->new Thread(String.valueOf(i)){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"\t"+SingletonByHodler.getInstance());
            }
        }.start());
    }
}
