package com.example.materiatest3;

import java.io.Serializable;

/**
 * @author 14512 on 2018/4/29
 */
public class Contact implements Serializable {
    private String mName;
    private String mPortraitId;


    public Contact(String name, String portraitId) {
        this.mName = name;
        this.mPortraitId = portraitId;

    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setPortraitId(String portraitId) {
        this.mPortraitId = portraitId;
    }

    public String getPortraitId() {
        return mPortraitId;
    }
}
