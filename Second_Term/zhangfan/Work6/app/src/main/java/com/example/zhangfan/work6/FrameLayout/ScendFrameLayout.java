package com.example.zhangfan.work6.FrameLayout;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhangfan.work6.Activities.AheadActivity;
import com.example.zhangfan.work6.Activities.AllActivity;
import com.example.zhangfan.work6.Activities.AndroidActivity;
import com.example.zhangfan.work6.Activities.AppActivity;
import com.example.zhangfan.work6.Activities.IosActivity;
import com.example.zhangfan.work6.Activities.RecommentActivity;
import com.example.zhangfan.work6.Activities.ResourceActivity;
import com.example.zhangfan.work6.Activities.VideoActivity;
import com.example.zhangfan.work6.Activities.WelFareActivity;
import com.example.zhangfan.work6.R;

public class ScendFrameLayout extends Fragment implements View.OnClickListener{
    private TextView allText;
    private TextView iosText;
    private TextView androidText;
    private TextView appText;
    private TextView aheadText;
    private TextView recommentText;
    private TextView resourceText;
    private TextView videoText;
    private TextView welfareText;

    private ImageView allImageView;
    private ImageView iosImageView;
    private ImageView androidImageView;
    private ImageView appImageView;
    private ImageView aheadImageView;
    private ImageView recommentImageView;
    private ImageView resourceImageView;
    private ImageView videoImageView;
    private ImageView welfareImageView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View scendLayout = inflater.inflate(R.layout.fragme_scend, container, false);
        allImageView = scendLayout.findViewById(R.id.scend_image_all);
        iosImageView = scendLayout.findViewById(R.id.scend_image_ios);
        androidImageView = scendLayout.findViewById(R.id.scend_image_android);
        appImageView = scendLayout.findViewById(R.id.scend_image_app);
        aheadImageView = scendLayout.findViewById(R.id.scend_image_ahead);
        recommentImageView = scendLayout.findViewById(R.id.scend_image_recommend);
        resourceImageView = scendLayout.findViewById(R.id.scend_image_resource);
        videoImageView = scendLayout.findViewById(R.id.scend_image_video);
        welfareImageView = scendLayout.findViewById(R.id.scend_image_welfare);

        allText = scendLayout.findViewById(R.id.scend_text_all);
        iosText = scendLayout.findViewById(R.id.text_ios);
        androidText =scendLayout.findViewById(R.id.scend_text_android);
        appText =scendLayout.findViewById(R.id.scend_text_app);
        aheadText = scendLayout.findViewById(R.id.scend_text_ahead);
        resourceText = scendLayout.findViewById(R.id.scend_text_resuorce);
        recommentText = scendLayout.findViewById(R.id.scend_text_recommend);
        videoText = scendLayout.findViewById(R.id.scend_text_video);
        welfareText=scendLayout.findViewById(R.id.scend_text_welfare);

        allImageView.setOnClickListener(this);
        iosImageView.setOnClickListener(this);
        androidImageView.setOnClickListener(this);
        appImageView.setOnClickListener(this);
        aheadImageView.setOnClickListener(this);
        resourceImageView.setOnClickListener(this);
        recommentImageView.setOnClickListener(this);
        videoImageView.setOnClickListener(this);
        welfareImageView.setOnClickListener(this);

        allText.setOnClickListener(this);
        iosText.setOnClickListener(this);
        androidText.setOnClickListener(this);
        appText.setOnClickListener(this);
        aheadText.setOnClickListener(this);
        resourceText.setOnClickListener(this);
        recommentText.setOnClickListener(this);
        videoText.setOnClickListener(this);
        welfareText.setOnClickListener(this);

        return scendLayout;


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scend_image_all:
            case R.id.scend_text_all:
                Intent intent9 = new Intent(this.getActivity(), AllActivity.class);
                intent9.putExtra("title","全部");
                startActivity(intent9);
                break;
            case R.id.scend_image_ios:
            case R.id.text_ios:
                Intent intent1 = new Intent(this.getActivity(), IosActivity.class);
                intent1.putExtra("title","iOS");
                startActivity(intent1);
                break;
            case R.id.scend_image_android:
            case R.id.scend_text_android:
                Intent intent2 = new Intent(this.getActivity(), AndroidActivity.class);
                intent2.putExtra("title","Android");
                startActivity(intent2);
                break;
            case R.id.scend_image_app:
            case R.id.scend_text_app:
                Intent intent3 = new Intent(this.getActivity(), AppActivity.class);
                intent3.putExtra("title","App");
                startActivity(intent3);
                break;
            case R.id.scend_image_ahead:
            case R.id.scend_text_ahead:
                Intent intent4 = new Intent(this.getActivity(), AheadActivity.class);
                intent4.putExtra("title","前端");
                startActivity(intent4);
                break;
            case R.id.scend_image_recommend:
            case R.id.scend_text_recommend:
                Intent intent5 = new Intent(this.getActivity(), RecommentActivity.class);
                intent5.putExtra("title","瞎推荐");
                startActivity(intent5);
                break;
            case R.id.scend_image_resource:
            case R.id.scend_text_resuorce:
                Intent intent6 = new Intent(this.getActivity(), ResourceActivity.class);
                intent6.putExtra("title","资源拓展");
                startActivity(intent6);
                break;
            case R.id.scend_image_video:
            case R.id.scend_text_video:
                Intent intent7 = new Intent(this.getActivity(), VideoActivity.class);
                intent7.putExtra("title","休息视频");
                startActivity(intent7);
                break;
            case R.id.scend_image_welfare:
            case R.id.scend_text_welfare:
                Intent intent8 = new Intent(this.getActivity(), WelFareActivity.class);
                intent8.putExtra("title","福利");
                startActivity(intent8);
                break;
        }

    }
}
