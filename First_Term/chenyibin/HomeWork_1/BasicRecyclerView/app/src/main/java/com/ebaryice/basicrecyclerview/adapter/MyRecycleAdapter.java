package com.ebaryice.basicrecyclerview.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ebaryice.basicrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EbaryIce on 2018/4/13/013.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter {

    private List<String> datas = new ArrayList<>();
    private Context context;
    private boolean openAnimationEnable = true;
    private int lastPosition = -1;
    private int duration = 500;
    private final int TYPE_FOOTER = 1;
    private final int TYPE_NORMAL = 2;
    private int load_more_status = 0;
    public static final int SHOW_FOOTER = 0;
    public static final int LOADING_MORE = 1;

    public MyRecycleAdapter(Context context, List<String> datas){
        this.context = context;
        this.datas = datas;
    }

    /**
     * 是否开启item加载动画
     * @param b
     */
    public void setOpenItemAnimationEnable(boolean b){
        this.openAnimationEnable = b;
    }

    /**
     * 设置动画时间
     * @param duration
     */
    public void setItemAnimationDuration(int duration){
        this.duration = duration;
    }


    /**
     * 下拉刷新调用
     * @param newDatas
     */
    public void addItem(List<String> newDatas){
        newDatas.addAll(datas);
        datas.clear();
        datas.addAll(newDatas);
        notifyDataSetChanged();
    }

    /**
     * 上拉加载调用
     * @param loadMoreDatas
     */
    public void addMoreItem(List<String> loadMoreDatas){
        datas.addAll(loadMoreDatas);
        notifyDataSetChanged();
    }

    /**
     * 改变footer的状态
     * @param status
     */
    public void changeLoadMoreStatus(int status){
        load_more_status = status;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()){//添加一个footer
            return TYPE_FOOTER;
        }else{
            return TYPE_NORMAL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==TYPE_NORMAL){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
            return new MyViewHolder(view);
        }else{
            return new FooterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_view,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
            bindListView((MyViewHolder)holder,position);
        }else if(holder instanceof FooterViewHolder){
            bindFooter((FooterViewHolder)holder,position);
        }
    }

    /**
     * 绑定footerView
     * @param holder
     * @param position
     */
    private void bindFooter(FooterViewHolder holder, int position) {
        switch (load_more_status){
            case SHOW_FOOTER:
                holder.progressBar.setVisibility(View.INVISIBLE);
                holder.textView.setText("上拉加载更多");
                break;
            case LOADING_MORE:
                holder.progressBar.setVisibility(View.VISIBLE);
                holder.textView.setText("loading...");
                break;
        }
    }

    /**
     * 绑定普通View
     * @param holder
     * @param position
     */
    private void bindListView(MyViewHolder holder, final int position) {
        holder.button.setText(datas.get(position));
        if (openAnimationEnable){
            if (holder.getLayoutPosition()>lastPosition){
                Animator animator = ObjectAnimator.ofFloat(holder.itemView,
                        "translationX",
                        holder.itemView.getRootView().getWidth(),0);
                animator.setInterpolator(new LinearInterpolator());
                animator.setDuration(duration);
                animator.start();
                lastPosition = holder.getLayoutPosition();
            }
        }
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"点击了第"+(position+1)+"个button",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        Button button;
        public MyViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
        }
    }


    class FooterViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ProgressBar progressBar;
        public FooterViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_footer);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}
