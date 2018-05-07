package com.example.pengfeiteng.recyclerviewtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    private ImageView imageView;
    private TextView nameTextView;
    private TextView textView;

    public static void startAction(Context context,Data data) {
        Intent intent = new Intent(context,Detail.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data",data);
        intent.putExtra("data",bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        initView();
        getData();
    }

    private void getData() {
        Data data = (Data) getIntent().getBundleExtra("data").getSerializable("data");
        assert data != null;
        imageView.setImageResource(data.getImageID());
        nameTextView.setText(data.getName());
        textView.setText(data.getmContext());

    }

    private void initView() {
        imageView = findViewById(R.id.imgPortraitDetail);
        nameTextView = findViewById(R.id.tvNameDetail);
        textView = findViewById(R.id.tvContentDetail);
    }

}
