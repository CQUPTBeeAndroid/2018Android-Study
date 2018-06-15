package com.example.zhangfan.work6.RecyclerView;

import android.graphics.Bitmap;

import java.io.Serializable;

public class AndroidItem implements Serializable {
    private String title;
    private String writer;
    private String data;
    private Bitmap bitmap;

    public AndroidItem(String responsetitle, String responsewriter, String responsedata,Bitmap bitmap) {
        this.title = responsetitle;
        this.writer = responsewriter;
        this.data = responsedata;
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getData() {
        return data;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

}
