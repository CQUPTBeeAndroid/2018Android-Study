package com.example.gankpro.Activity.FirstActivityFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.gankpro.HttpUtil;
import com.example.gankpro.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class Fragment2 extends Fragment {
    private List<Knowledge>knowledgeList = new ArrayList<>();
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        initData(view);
        return view;
    }

    public void initData(final View view){
        HttpUtil.sendOkHttpRequest("http://www.wanandroid.com/tree/json",new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                e.printStackTrace();
                Intent intent =new Intent(getActivity(), NoInternetAtivity.class);
                startActivity(intent);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
             String responseData = response.body().string();
             try {
                 JSONObject jsonObject = new JSONObject(responseData);
                 String data = jsonObject.getString("data");
                 JSONArray jsonArray = new JSONArray(data);
                 for(int i =0;i<jsonArray.length();i++){
                     JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                     String title = jsonObject1.getString("name");
                     String children = jsonObject1.getString("children");
                     JSONArray jsonArray1 = new JSONArray(children);
                     String content = "";
                     for(int j = 0;j<jsonArray1.length();j++){
                         JSONObject jsonObject2 =jsonArray1.getJSONObject(j);
                         content =content + jsonObject2.getString("name")+ "    ";
                     }
                     Knowledge knowledge =new Knowledge(title,content);
                     knowledgeList.add(knowledge);
                 }
             } catch (JSONException e) {
             }
             getActivity().runOnUiThread(new Runnable() {
                 @Override
                 public void run() {
                     recyclerView = view.findViewById(R.id.knowledge_recycler);
                     LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                     recyclerView.setLayoutManager(linearLayoutManager);
                     KnowledgeAdapter knowledgeAdapter = new KnowledgeAdapter(knowledgeList);
                     recyclerView.setAdapter(knowledgeAdapter);
                 }
             });
            }
        });
    }

    public class KnowledgeAdapter extends RecyclerView.Adapter<KnowledgeAdapter.ViewHolder>{
        private List<Knowledge>myknowledgeList;
        public class ViewHolder extends RecyclerView.ViewHolder{
         TextView knowledgeTitle;
         TextView content;
            public ViewHolder(View itemView) {
                super(itemView);
                knowledgeTitle = itemView.findViewById(R.id.knowledgetitle);
                content = itemView.findViewById(R.id.content);
            }
        }
        public KnowledgeAdapter(List<Knowledge>knowledgeList){
            myknowledgeList = knowledgeList;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.knowledgetitle,parent,false);
            final  ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
        Knowledge knowledge = myknowledgeList.get(position);
        holder.knowledgeTitle.setText(knowledge.getkTitle());
        holder.content.setText(knowledge.getkAbout());

            holder.content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        @Override
        public int getItemCount() {
            return myknowledgeList.size();
        }

    }
}
