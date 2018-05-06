package com.example.asus_pc.myapplication;

/**
 * Created by asus-pc on 2018/5/2.
 */

public class Fruit{
    private String name;
    private int imageId;
    public Fruit(String name,int imageID){
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