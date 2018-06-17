package com.example.gankpro.Activity.FirstActivityFragment;

public class Knowledge {
    private String kTitle;
    private String kAbout;

    public Knowledge(String kTitle, String kAbout){
        this.kTitle = kTitle;
        this.kAbout = kAbout;
    }

    public String getkTitle() {
        return kTitle;
    }

    public String getkAbout() {
        return kAbout;
    }
}
