package com.example.hp.ourgank.Assets;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/9 18:20
 * @简述:
 */
public class ActivityCollector {

    private static List<Activity>activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeBeforeAcivity(){
        int i = activities.size() - 1;
        for(int j = 0;j < i;j++){
            if(activities.get(j) != null){
                activities.get(j).finish();
            }
        }
    }

    public static void finishAll(){
        for(Activity a:activities){
            if(a != null){
                a.finish();
            }
        }
    }
}
