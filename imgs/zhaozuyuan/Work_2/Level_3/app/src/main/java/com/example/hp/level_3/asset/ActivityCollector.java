package com.example.hp.level_3.asset;

import android.app.Activity;

import java.util.ArrayList;

public class ActivityCollector {
    private static ArrayList<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void finishAll(){
        for(Activity a:activities){
            if(a != null){
                a.finish();
            }
        }
    }
}
