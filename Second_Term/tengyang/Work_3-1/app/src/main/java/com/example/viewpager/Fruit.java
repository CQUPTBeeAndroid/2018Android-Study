package com.example.viewpager;

import java.io.Serializable;

/**
 * Created by 滕扬 on 2018/4/26.
 */

public class Fruit implements Serializable {
    String name;
    int imageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
