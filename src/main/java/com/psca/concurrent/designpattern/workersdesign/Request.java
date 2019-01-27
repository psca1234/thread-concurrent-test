package com.psca.concurrent.designpattern.workersdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 22:51
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 22:51
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Request {
    private String name;
    private int number;

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName()+"\t"+this);
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
