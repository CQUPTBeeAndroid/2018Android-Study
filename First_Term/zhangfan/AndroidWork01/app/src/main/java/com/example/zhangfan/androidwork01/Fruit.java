package com.example.zhangfan.androidwork01;

public class Fruit {
    private  String name;
    private int imageId;

    public Fruit (String name,int imageId){
        this.imageId=imageId;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
