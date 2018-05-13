package com.example.qinfenbeen;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by 王辉 on 2018/4/24.
 */

public abstract class EndLessOnScrollListener extends RecyclerView.OnScrollListener{
    private GridLayoutManager gridLayoutManager;
    private  int previousTotal = 0;
    private int currentPage=0;
    private int totalHerCount;
    private int visibleHerCount;
    private int firstVisibleHer;
    private boolean loading =true;
    public EndLessOnScrollListener(GridLayoutManager gridLayoutManager){
        this.gridLayoutManager=gridLayoutManager;
    }
    public  void  onScrolled(RecyclerView recyclerView,int dx,int dy){
        super.onScrolled(recyclerView,dx,dy);
        visibleHerCount =recyclerView.getChildCount();
        totalHerCount = gridLayoutManager.getItemCount();
        firstVisibleHer =gridLayoutManager.findFirstVisibleItemPosition();
        if (loading){
            if(totalHerCount> previousTotal){
                loading =false;
                previousTotal =totalHerCount;
            }
        }
        if(!loading && totalHerCount-visibleHerCount<=firstVisibleHer){
            currentPage ++;
            onLoadMore(currentPage);
            loading =true;
        }
    }
    public  abstract void onLoadMore(int currentPage);
}
