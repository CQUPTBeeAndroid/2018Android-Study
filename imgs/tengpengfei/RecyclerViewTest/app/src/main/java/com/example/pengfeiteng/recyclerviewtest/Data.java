package com.example.pengfeiteng.recyclerviewtest;

import java.io.Serializable;

public class Data implements Serializable {
    private String name;
    private int imageID;
    private String mContext;

    public Data(String name, int imageID,String mContext) {
        this.name = name;
        this.imageID = imageID;
        this.mContext = mContext;
    }

    public String getName() {
        return name;
    }
    public int getImageID() { return imageID;}

    public String getmContext() {
        return mContext;
    }
}
