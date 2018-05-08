package com.example.zhangfan.work2;

public class Message {
    private String name;
    private String time;
    private String message;
    private int imageId;
    public Message(int imageId,String name,String message,String time){
        this.message = message;
        this.imageId = imageId;
        this.name = name;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }
}
