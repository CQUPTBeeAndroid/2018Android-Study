package com.example.gankpro.Activity.FirstActivityFragment;

public class Article {
    private String title;
    private String writer;
    private String nicetime;
    private String URL;

    public Article(String title,String writer,String time,String URL){
        this.title = title;
        this.writer = writer;
        this.nicetime = time;
        this.URL = URL;
    }

    public String getTitle(){
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getNicetime() {
        return nicetime;
    }

    public String getURL() {
        return URL;
    }
}
