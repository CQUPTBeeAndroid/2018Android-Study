package com.example.materiatest3;

import android.view.View;


public interface OnItemClickListener1 {
    /**
     * 回调接口
     * @param view
     * @param position
     * @param str

    在Activity中动态设置TextView的隐藏属性
    if (true) {
    //显示
    viewHolder.tvLine.setVisibility(View.INVISIBLE);
    } else {
    //不显示
    viewHolder.tvLine.setVisibility(View.VISIBLE);
    }
     */
    void onItemClick(View view, int position, String str,int position1);
}

