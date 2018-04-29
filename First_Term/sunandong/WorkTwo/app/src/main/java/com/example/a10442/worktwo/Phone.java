package com.example.a10442.worktwo;

/**
 * Created by 10442 on 2018/4/26.
 */

public class Phone {
    private String name;
    private int imageId;
    public Phone(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
