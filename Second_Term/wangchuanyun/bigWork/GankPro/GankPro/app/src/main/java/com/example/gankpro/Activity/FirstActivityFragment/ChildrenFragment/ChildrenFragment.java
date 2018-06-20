package com.example.gankpro.Activity.FirstActivityFragment.ChildrenFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gankpro.Activity.FirstActivityFragment.Fragment2;
import com.example.gankpro.Activity.WebViewActivity;
import com.example.gankpro.R;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class ChildrenFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<ChildrenItem>mchildrenItemList;
    ChildrenAdapter childrenAdapter;
    private Context context;
    private boolean isGetData = false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_children, container, false);
        context = this.getActivity();
       initView(view);
        return view;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        //   进入当前Fragment
        if (enter && !isGetData) {
            isGetData = true;
           childrenAdapter.notifyDataSetChanged();
        } else {
            isGetData = false;
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public void onResume() {
        if (!isGetData) {
            //   这里可以做网络请求或者需要的数据刷新操作
            childrenAdapter.notifyDataSetChanged();
            isGetData = true;
        }
        super.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        isGetData = false;
    }

   public void getData(List<ChildrenItem>list1){
        mchildrenItemList = list1;
    }
    public void initView(View view){
                recyclerView = view.findViewById(R.id.children_recycler);
                childrenAdapter = new ChildrenAdapter(mchildrenItemList,context);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(childrenAdapter);

    }

    public class ChildrenAdapter extends RecyclerView.Adapter<ChildrenAdapter.ViewHolder>{
        private List<ChildrenItem>childrenItemList;
        private Context mContext;


        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView phonepic;
            TextView title;
            TextView aboutContent;
            TextView aboutWriter;
            public ViewHolder(View itemView) {
                super(itemView);
                phonepic = itemView.findViewById(R.id.phone_pic);
                title = itemView.findViewById(R.id.title);
                aboutContent = itemView.findViewById(R.id.about_content);
                aboutWriter = itemView.findViewById(R.id.about_writer);
            }
        }

        public ChildrenAdapter(List<ChildrenItem>list ,Context context){
            childrenItemList = list;
            mContext =context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.children_item,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final ChildrenItem childrenItem = childrenItemList.get(position);
            holder.title.setText(childrenItem.getTitle());
            holder.aboutContent.setText(childrenItem.getAboutContent());
            holder.aboutWriter.setText(childrenItem.getAboutWriter());
           // Log.d("这是",childrenItem.getPhoneUrl());
            Glide.with(mContext).load(childrenItem.getPhoneUrl()).into(holder.phonepic);
            holder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(),WebViewActivity.class);
                    intent.putExtra("link",childrenItem.getURL());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return childrenItemList.size();
        }
    }
}

