package com.example.materiatest3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class MyFragment4 extends Fragment {

    private List<Meizi> meiziList ;
    private Activity activity;
    public Context getContext(){
        if(activity==null){
            return MyApplication.getInstance();
        }
        return activity;
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        activity=getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page4, null);

        meiziList = new ArrayList<>();
        view3();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view222);
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);//getContext()就是Context对象
        recyclerView.setLayoutManager(layoutManager);
        MeiziAdapter adapter = new MeiziAdapter(meiziList);
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void view3(){
        Meizi a1 = new Meizi("全", R.drawable.meizi01);
        meiziList.add(a1);
        Meizi a2 = new Meizi("部", R.drawable.meizi02);
        meiziList.add(a2);
        Meizi a3 = new Meizi("都", R.drawable.meizi03);
        meiziList.add(a3);
        Meizi a4 = new Meizi("是", R.drawable.meizi04);
        meiziList.add(a4);
        Meizi a5 = new Meizi("你", R.drawable.meizi05);
        meiziList.add(a5);
        Meizi a6 = new Meizi("的", R.drawable.meizi06);
        meiziList.add(a6);
        Meizi b1 = new Meizi("重", R.drawable.view01);
        meiziList.add(b1);
        Meizi b2 = new Meizi("邮", R.drawable.view02);
        meiziList.add(b2);
        Meizi b3 = new Meizi("的", R.drawable.view03);
        meiziList.add(b3);
        Meizi b4 = new Meizi("樱", R.drawable.view04);
        meiziList.add(b4);
        Meizi b5 = new Meizi("花", R.drawable.view05);
        meiziList.add(b5);
        Meizi b6 = new Meizi("全部都给你", R.drawable.view06);
        meiziList.add(b6);

        Meizi d01 = new Meizi("动", R.drawable.dmdm01);
        meiziList.add(d01);
        Meizi d02 = new Meizi("漫", R.drawable.dmdm02);
        meiziList.add(d02);

        Meizi c1 = new Meizi("", R.drawable.dm01);
        meiziList.add(c1);
        Meizi c2 = new Meizi("", R.drawable.dm02);
        meiziList.add(c2);
        Meizi c3 = new Meizi("", R.drawable.dm03);
        meiziList.add(c3);
        Meizi c4 = new Meizi("", R.drawable.dm04);
        meiziList.add(c4);
        Meizi c5 = new Meizi("", R.drawable.dm05);
        meiziList.add(c5);
        Meizi c6 = new Meizi("", R.drawable.dm06);
        meiziList.add(c6);

        Meizi c8 = new Meizi("愿", R.drawable.dm08);
        meiziList.add(c8);
        Meizi c9 = new Meizi("归", R.drawable.dm09);
        meiziList.add(c9);
        Meizi c10 = new Meizi("你", R.drawable.dm10);
        meiziList.add(c10);
        Meizi c11 = new Meizi("来", R.drawable.dm11);
        meiziList.add(c11);
        Meizi c12 = new Meizi("走", R.drawable.dm12);
        meiziList.add(c12);

        Meizi c13 = new Meizi("仍", R.drawable.dm13);
        meiziList.add(c13);
        Meizi c14 = new Meizi("出", R.drawable.dm14);
        meiziList.add(c14);
        Meizi c15 = new Meizi("是", R.drawable.dm15);
        meiziList.add(c15);
        Meizi c16 = new Meizi("半", R.drawable.dm16);
        meiziList.add(c16);
        Meizi c17 = new Meizi("少", R.drawable.dm17);
        meiziList.add(c17);
        Meizi c18 = new Meizi("生", R.drawable.dm18);
        meiziList.add(c18);
        Meizi c19 = new Meizi("年", R.drawable.dm19);
        meiziList.add(c19);
        Meizi c7 = new Meizi("", R.drawable.dm07);
        meiziList.add(c7);
        Meizi c20 = new Meizi("", R.drawable.dm20);
        meiziList.add(c20);
        Meizi c21 = new Meizi("", R.drawable.dm21);
        meiziList.add(c21);
        Meizi c22 = new Meizi("", R.drawable.dm22);
        meiziList.add(c22);
        Meizi c23 = new Meizi("", R.drawable.dm23);
        meiziList.add(c23);
        Meizi c24 = new Meizi("", R.drawable.dm24);
        meiziList.add(c24);

        Meizi c25 = new Meizi("", R.drawable.dm25);
        meiziList.add(c25);
        Meizi c26 = new Meizi("", R.drawable.dm26);
        meiziList.add(c26);
        Meizi c27 = new Meizi("", R.drawable.dm27);
        meiziList.add(c27);
        Meizi c28 = new Meizi("", R.drawable.dm28);
        meiziList.add(c28);
        Meizi c29 = new Meizi("", R.drawable.dm29);
        meiziList.add(c29);
        Meizi c30 = new Meizi("", R.drawable.dm30);
        meiziList.add(c30);
    }
}

