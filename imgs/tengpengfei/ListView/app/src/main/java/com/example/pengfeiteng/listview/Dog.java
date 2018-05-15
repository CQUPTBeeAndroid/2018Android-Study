package com.example.pengfeiteng.listview;

public class Dog {
    private String name;
    private int imageId;

    public Dog (String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName (){
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
