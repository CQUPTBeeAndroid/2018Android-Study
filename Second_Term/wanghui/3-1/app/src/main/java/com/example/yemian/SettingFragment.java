package com.example.yemian;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SettingFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View messageLayout = inflater.inflate(R.layout.setting_layout,container,false);
        return messageLayout;
    }
}
