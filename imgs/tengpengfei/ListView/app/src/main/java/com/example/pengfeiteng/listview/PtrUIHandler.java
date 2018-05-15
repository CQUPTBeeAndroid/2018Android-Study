package com.example.pengfeiteng.listview;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

public interface PtrUIHandler {

    public void onUIReset(PtrFrameLayout frame);

    public void onUIRefreshPrepare(PtrFrameLayout frame);

    public void onUIRefreshBegin(PtrFrameLayout frame);

    public void onUIRefreshComplete(PtrFrameLayout frame);

    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator);
}
