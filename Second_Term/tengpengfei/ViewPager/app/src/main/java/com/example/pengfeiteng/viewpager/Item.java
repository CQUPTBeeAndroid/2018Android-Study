package com.example.pengfeiteng.viewpager;

public class Item {
    private String name;

    private int imageId;

    public Item(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
