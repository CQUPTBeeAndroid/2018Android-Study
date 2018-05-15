package com.example.pengfeiteng.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ListView;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

public class UltraRefreshListView extends ListView implements PtrUIHandler, AbsListView.OnScrollListener {

    private UltraRefreshListener mUltraRefreshListener;

    private View footView;

    private boolean isLoadData = false;

    /**
     * 是否是下拉刷新，主要在处理结果时使用
     */
    private boolean isRefresh = false;

    public UltraRefreshListView(Context context) {
        this(context,null);
    }

    public UltraRefreshListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public UltraRefreshListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化布局，及添加一个跟布局
        initView();
    }
    private void initView() {
        footView = LayoutInflater.from(getContext()).inflate(R.layout.footview, null);

        setOnScrollListener((OnScrollListener) this);
    }


    @Override
    public void onUIReset(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame){

        isLoadData  =true;
        isRefresh =true;
        //下拉刷新的回调
        if(mUltraRefreshListener!=null){

            mUltraRefreshListener.onRefresh();
        }
    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {

    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {

    }

    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        //  PtrHandler 的接口回调，是否能够加载数据的判断
        return !isLoadData&&checkContentCanBePulledDown(frame, content, header);
    }

    // 从PtrHandler的默认实现类 PtrDefaultHandler中找到的，用以判断是否可以下拉刷新
    public static boolean checkContentCanBePulledDown(PtrFrameLayout frame, View content, View header) {
        return !canChildScrollUp(content);

    }

    // 从PtrHandler的默认实现类 PtrDefaultHandler中找到的，用以判断是否可以下拉刷新
    public static boolean canChildScrollUp(View view) {
        if (android.os.Build.VERSION.SDK_INT < 14) {
            if (view instanceof AbsListView) {
                final AbsListView absListView = (AbsListView) view;
                return absListView.getChildCount() > 0
                        && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0)
                        .getTop() < absListView.getPaddingTop());
            } else {
                return view.getScrollY() > 0;
            }
        } else {
            return view.canScrollVertically(-1);
        }
    }


    /**
     * 设置ListView的监听回调
     */
    public void setUltraRefreshListener(UltraRefreshListener mUltraRefreshListener) {
        this.mUltraRefreshListener = mUltraRefreshListener;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        /*Log.i("info","isLoadData:"+isLoadData+" totalItemCount "+totalItemCount+" firstVisibleItem "+
                firstVisibleItem+" visibleItemCount "+ visibleItemCount);
*/
        //加载更多的判断
        if(totalItemCount>1&&!isLoadData&&totalItemCount==firstVisibleItem+visibleItemCount){
            isRefresh =false;
            isLoadData = true;
            addFooterView(footView);
            mUltraRefreshListener.addMore();
        }
    }



    //刷新完成的后调用此方法还原布局
    public void refreshComplete(){
        isLoadData = false;
        if(isRefresh){
            //获取其父控件，刷新
            ViewParent parent = getParent();
            if(parent instanceof PtrClassicFrameLayout){
                ((PtrClassicFrameLayout) parent).refreshComplete();
            }
        }else{
            removeFooterView(footView);
        }
    }
}
