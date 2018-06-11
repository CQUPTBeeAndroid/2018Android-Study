package com.example.zhangfan.work6.RecyclerView;

public class NewsBean {
    public String newsIconUrl;
    public String newsTitle;
    public String newsContent;
    public String newsTime;
    public NewsBean(String newsTitle,String newsContent,String newsTime){
        this.newsContent = newsContent;
        this.newsTitle = newsTitle;
        this.newsTime = newsTime;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public String getNewsTitle(){
        return newsTitle;
    }
    public String getNewsContent(){
        return  newsContent;
    }
}