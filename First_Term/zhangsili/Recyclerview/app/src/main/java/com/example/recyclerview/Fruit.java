package com.example.recyclerview;

/**
 * Created by asus-pc on 2018/5/5.
 */

public class Fruit{
    private String name;
    private int imageId;
    public Fruit(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}