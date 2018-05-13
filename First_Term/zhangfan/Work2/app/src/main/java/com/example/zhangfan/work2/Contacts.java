package com.example.zhangfan.work2;

public class Contacts {
    private String name;
    private int imageId;
    public Contacts(int imageId,String name){
        this.imageId = imageId;
        this.name= name;
    }

    public String getName() {
        return name;
    }


    public int getImageId() {
        return imageId;
    }

}
