package activitytest.com.example.viewpagetest.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import activitytest.com.example.viewpagetest.Adapter.AdressList;
import activitytest.com.example.viewpagetest.R;

/**
 * Created by 问荆 on 2018/5/10.
 */

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pic2, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.message_recycler2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        AdressListAdapter adressListAdapter= new AdressListAdapter(getData());
        recyclerView.setAdapter(adressListAdapter);
        return view;
    }
    private List<AdressList> getData(){
        List<AdressList>adressLists = new ArrayList<>();
        AdressList newFriends = new AdressList("新的朋友",R.drawable.newfriends);
        adressLists.add(newFriends);
        AdressList qunliao = new AdressList("群聊",R.drawable.qunliao);
        adressLists.add(qunliao);
        AdressList mark = new AdressList("标签",R.drawable.mark);
        adressLists.add(mark);
        AdressList gongzhonghao = new AdressList("公众号",R.drawable.gongzhonghao);
        adressLists.add(gongzhonghao);
        AdressList mingren = new AdressList("鸣人",R.drawable.mingren);
        adressLists.add(mingren);
        AdressList zuozhu = new AdressList("佐助",R.drawable.zuozhu);
        adressLists.add(zuozhu);
        AdressList sishen = new AdressList("死神",R.drawable.sishen);
        adressLists.add(sishen);
        AdressList wukong = new AdressList("悟空",R.drawable.wukong);
        adressLists.add(wukong);
        return adressLists;
    }

    public  class AdressListAdapter extends RecyclerView.Adapter<AdressListAdapter.ViewHolder> {
        private List<AdressList> myadressList;
        class ViewHolder extends RecyclerView.ViewHolder{
            ImageView adressListView;
            TextView adressListName;
            public ViewHolder(View view){
                super(view);
                adressListView = (ImageView)view.findViewById(R.id.image2);
                adressListName = (TextView)view.findViewById(R.id.text3);
            }
        }
        public AdressListAdapter(List<AdressList>adressLists){
            myadressList = adressLists;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adresslist_item,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
           AdressList adressList = myadressList.get(position);
            holder.adressListView.setImageResource(adressList.getImageId());
            holder.adressListName.setText(adressList.getName());
        }

        @Override
        public int getItemCount() {
            return myadressList.size();
        }
    }

}


