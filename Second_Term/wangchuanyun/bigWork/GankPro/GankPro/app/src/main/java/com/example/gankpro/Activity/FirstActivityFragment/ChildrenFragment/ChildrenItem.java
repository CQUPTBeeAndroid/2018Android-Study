package com.example.gankpro.Activity.FirstActivityFragment.ChildrenFragment;

import android.widget.ImageView;
import android.widget.TextView;

public class ChildrenItem  {
    private String phoneUrl;
    private String title;
   private String aboutContent;
    private String aboutWriter;
    private String URL;

    public ChildrenItem( String phoneUrl,String title, String aboutContent, String aboutWriter,String URL){
        this.phoneUrl = phoneUrl;
        this.title = title;
        this.aboutContent = aboutContent;
        this.aboutWriter = aboutWriter;
        this.URL = URL;
    }

    public String getPhoneUrl() {
        return phoneUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAboutContent() {
        return aboutContent;
    }

    public String getAboutWriter() {
        return aboutWriter;
    }

    public String getURL() {
        return URL;
    }
}
