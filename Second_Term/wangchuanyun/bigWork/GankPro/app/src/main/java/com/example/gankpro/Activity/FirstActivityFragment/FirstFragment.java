package com.example.gankpro.Activity.FirstActivityFragment;

import android.content.Intent;
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
import android.widget.Toast;

import com.example.gankpro.Activity.FirstActivity;
import com.example.gankpro.Activity.MainActivity;
import com.example.gankpro.Activity.WebViewActivity;
import com.example.gankpro.Banner.GlideImageLoader;
import com.example.gankpro.HttpUtil;
import com.example.gankpro.R;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;


public class FirstFragment extends Fragment {
    private List<Article>articleTitle = new ArrayList<>();
    private List<String>banner = new ArrayList<>();
    private List<String>Url = new ArrayList<>();
    private RecyclerView recyclerView;
    private  Banner mbanner;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                         @Nullable ViewGroup container,
                         @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_first,container,false);
        initData(view);
        return view;
    }

    public void initData(final View view){
        HttpUtil.sendOkHttpRequest("http://www.wanandroid.com/banner/json", new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                // Toast.makeText(mContext,"请检查您的网络",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                try{
                    JSONObject jsonObject =new JSONObject(responseData);
                    String data = jsonObject.getString("data");
                    JSONArray jsonArray = new JSONArray(data);
                    for(int i =0;i<jsonArray.length();i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        banner.add(jsonObject1.getString("imagePath"));
                        Url.add(jsonObject1.getString("url"));
                       // Log.d("这是url",banner.get(i));
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                    Intent intent =new Intent(getActivity(), NoInternetAtivity.class);
                    startActivity(intent);
                }
            }
        });
        HttpUtil.sendOkHttpRequest("http://www.wanandroid.com/article/list/0/json",new okhttp3.Callback(){
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Intent intent =new Intent(getActivity(), NoInternetAtivity.class);
                startActivity(intent);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                try{
                    JSONObject jsonObject =new JSONObject(responseData);
                    String data = jsonObject.getString("data");
                    JSONObject jsonObject1 =new JSONObject(data);
                    String datas = jsonObject1.getString("datas");
                    JSONArray jsonArray = new JSONArray(datas);
                    for(int i =0;i<jsonArray.length();i++){
                        JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                        Article article = new Article(jsonObject2.getString("title"),jsonObject2.getString("author"),
                                jsonObject2.getString("niceDate"),jsonObject2.getString("link"));
                        articleTitle.add(article);
                        //articleTitle.add(jsonObject1.getString("title"));
                        // Log.d("这是url",banner.get(i));
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView = (RecyclerView)view.findViewById(R.id.article_recycler);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                        recyclerView.setLayoutManager(linearLayoutManager);
                        mbanner = (Banner)view. findViewById(R.id.first_banner);
                        ArticleAdapter articleAdapter = new ArticleAdapter(articleTitle);
                        recyclerView.setAdapter(articleAdapter);
                        mbanner.setImageLoader(new GlideImageLoader()).setImages (banner)
                                .isAutoPlay(true).setDelayTime(3000).start();
                        mbanner.setOnBannerListener(new OnBannerListener() {
                            @Override
                            public void OnBannerClick(int position) {
                                Intent intent = new Intent(getActivity(),WebViewActivity.class);
                                intent.putExtra("link",Url.get(position));
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        });
    }
    public class ArticleAdapter extends  RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
        private List<Article>myarticleList ;
        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView articleTitle;
            TextView articleWriter;
            TextView articleTime;
            ImageView articleImage;
            public ViewHolder(View itemView) {
                super(itemView);
                articleTitle = (TextView)itemView.findViewById(R.id.article_title);
                articleWriter = (TextView)itemView.findViewById(R.id.article_writer);
                articleTime = (TextView)itemView.findViewById(R.id.article_time);
                articleImage = (ImageView)itemView.findViewById(R.id.article_image);
            }
        }
        public ArticleAdapter(List<Article>articleList){
            myarticleList = articleList;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item,parent,false);
            final  ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
        final Article article = myarticleList.get(position);
        holder.articleTitle.setText(article.getTitle());
        holder.articleWriter.setText(article.getWriter());
        holder.articleTime.setText(article.getNicetime());
            holder.articleTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("link",article.getURL());
                    startActivity(intent);
                }
            });
            final boolean[] iszan = {false};
            holder.articleImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   if(iszan[0] == true){
                       holder.articleImage.setImageResource(R.drawable.collection);
                       Toast.makeText(getActivity(),"大佬你取消点赞了！！！",Toast.LENGTH_SHORT).show();
                       iszan[0] =false;
                   }else{holder.articleImage.setImageResource(R.drawable.collection2);
                   Toast.makeText(getActivity(),"大佬你已经点赞了！！！",Toast.LENGTH_SHORT).show();
                   iszan[0] =true;}

                }
            });
        }

        @Override
        public int getItemCount() {
            return myarticleList.size();
        }
    }
}
