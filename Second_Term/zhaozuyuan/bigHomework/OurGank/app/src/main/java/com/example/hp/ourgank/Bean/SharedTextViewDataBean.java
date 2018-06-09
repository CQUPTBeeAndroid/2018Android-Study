package com.example.hp.ourgank.Bean;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/8 0:37
 * @简述:
 */
public class SharedTextViewDataBean {
    private String string1;
    private String string2;

    public String getString1() {
        return string1;
    }

    public String getString2() {
        return string2;
    }

    public SharedTextViewDataBean(String string1,String string2){
        this.string1 = string1;
        this.string2 = string2;
    }
}
