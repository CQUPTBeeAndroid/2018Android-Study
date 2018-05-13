package com.example.super_chao.myfirstapplication;

/**
 * Created by Super_chao on 2018/5/7.
 */

public class Chat {
    private String time;
    private String name;
    private  int imageId;
    private String content;
    public Chat(String name,int imageId,String time,String content){
        this.name = name;
        this.imageId = imageId;
        this.time = time;
        this.content=content;
    }
    public String getName(){
        return  name;
    }
    public String getTime(){
        return time;
    }

    public int getImageId() {
        return imageId;
    }
    public String getContent(){
        return content;
    }
}
