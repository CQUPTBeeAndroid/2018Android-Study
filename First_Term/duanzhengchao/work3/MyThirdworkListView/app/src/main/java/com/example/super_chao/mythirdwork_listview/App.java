package com.example.super_chao.mythirdwork_listview;

/**
 * Created by Super_chao on 2018/4/29.
 */

public class App {
    private String name;
    private  int imageId;

    public App(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName(){
        return  name;
    }
    public int getImageId(){
        return imageId;
    }
}
