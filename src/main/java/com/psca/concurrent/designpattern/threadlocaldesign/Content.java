package com.psca.concurrent.designpattern.threadlocaldesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 22:51
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 22:51
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Content {
    private String name;
    private String cardId;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }
}
