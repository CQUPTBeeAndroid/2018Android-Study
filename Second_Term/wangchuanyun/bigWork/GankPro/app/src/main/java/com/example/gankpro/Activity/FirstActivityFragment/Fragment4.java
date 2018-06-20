package com.example.gankpro.Activity.FirstActivityFragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TableLayout;

import com.example.gankpro.Activity.FirstActivityFragment.ChildrenFragment.ChildrenItem;
import com.example.gankpro.Activity.FirstActivityFragment.ChildrenFragment.MyChildrenFragmentAdapter;
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

public class Fragment4 extends Fragment {
    private boolean isGetData = false;
    private TabLayout tabLayout;
    private ViewPager myViewPager;
    private Context mContext;
    private List<ChildrenItem> childrenItemList1 = new ArrayList<>();
    private List<ChildrenItem>childrenItemList2 = new ArrayList<>();
    private List<ChildrenItem>childrenItemList3 = new ArrayList<>();
   private List<ChildrenItem>childrenItemList4 = new ArrayList<>();
    MyChildrenFragmentAdapter myChildrenFragmentAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment4, container, false);
        mContext = this.getActivity();

        myViewPager = (ViewPager)view.findViewById(R.id.children_viewpager);
        myChildrenFragmentAdapter = new MyChildrenFragmentAdapter(getChildFragmentManager(),mContext,
                childrenItemList1,childrenItemList2,childrenItemList3,childrenItemList4);
        myViewPager.setAdapter(myChildrenFragmentAdapter);
        tabLayout = (TabLayout)view.findViewById(R.id.children_tab);
        tabLayout.setupWithViewPager(myViewPager);
         return view;
    }



    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        //   进入当前Fragment
        if (enter && !isGetData) {
            isGetData = true;
            initData();
        } else {
            isGetData = false;
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public void onResume() {
        if (!isGetData) {
            //   这里可以做网络请求或者需要的数据刷新操作
            initData();
            isGetData = true;
        }
        super.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        isGetData = false;
    }

    public void initData(){ ;
        HttpUtil.sendOkHttpRequest("http://www.wanandroid.com/project/tree/json", new okhttp3.Callback() {
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
                    final JSONArray jsonArray = new JSONArray(data);
                    for(int i =0;i<4;i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        final int finalI = i;
                        HttpUtil.sendOkHttpRequest("http://www.wanandroid.com/project/list/1/json?cid=" + jsonObject1.getString("id"), new okhttp3.Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                e.printStackTrace();
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                String responseData1 = response.body().string();
                                try {
                                    JSONObject jsonObject2 = new JSONObject(responseData1);
                                    String data = jsonObject2.getString("data");
                                    JSONObject jsonObject3 = new JSONObject(data);
                                    String datas = jsonObject3.getString("datas");
                                    JSONArray jsonArray1 = new JSONArray(datas);
                                    for(int j =0;j<jsonArray1.length();j++){
                                        JSONObject jsonObject4 = jsonArray1.getJSONObject(j);
                                        ChildrenItem childrenItem = new ChildrenItem(
                                                jsonObject4.getString("envelopePic"),
                                                jsonObject4.getString("title"),
                                                jsonObject4.getString("desc"),
                                                jsonObject4.getString("author"),
                                                jsonObject4.getString("link"));
                                        if( finalI == 0){
                                            childrenItemList1.add(childrenItem);
                                        }
                                        else if(finalI ==1){
                                            childrenItemList2.add(childrenItem);
                                        }else if(finalI ==2){
                                            childrenItemList3.add(childrenItem);
                                        }else if(finalI ==3){
                                            childrenItemList4.add(childrenItem);
                                        }
                                    }

                                }catch (JSONException e){
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
