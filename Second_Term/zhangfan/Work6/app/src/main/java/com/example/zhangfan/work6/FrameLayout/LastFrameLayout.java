package com.example.zhangfan.work6.FrameLayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.zhangfan.work6.R;

public class LastFrameLayout extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View lastFrameLayout = inflater.inflate(R.layout.fragme_last, container, false);
        return lastFrameLayout;
    }
}
