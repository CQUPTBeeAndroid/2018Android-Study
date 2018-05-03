package com.example.administrator.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button startSecondActivity,startphone,startMail,startWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.Name);
        startMail=(Button)findViewById(R.id.startMail);
        startSecondActivity=(Button)findViewById(R.id.startSecondActivity);
        startWeb=(Button)findViewById(R.id.startWeb);
        startphone=(Button)findViewById(R.id.startphone);
        startphone.setOnClickListener(new Myclicklistener());
        startWeb.setOnClickListener(new Myclicklistener());
        startSecondActivity.setOnClickListener(new Myclicklistener());
        startMail.setOnClickListener(new Myclicklistener());
    }
    class Myclicklistener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.startMail:
                    Uri uri=Uri.parse("smsto:123456");
                    Intent intent3=new Intent(Intent.ACTION_SENDTO,uri);
                    intent3.putExtra("sms_body","发送短信");
                    startActivity(intent3);
                    break;
                case R.id.startphone:
                    Intent intent2=new Intent();
                    intent2.setAction(Intent.ACTION_DIAL);
                    intent2.setData(Uri.parse("tel:10086"));
                    startActivity(intent2);
                    break;
                case R.id.startSecondActivity:
                    String data=editText.getText().toString();
                    Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra(data,"data");
                    startActivity(intent);
                    break;
                case R.id.startWeb:
                    Intent intent1=new Intent();
                    intent1.setAction(Intent.ACTION_VIEW);
                    intent1.setData(Uri.parse("https://www.baidu.com"));
                    startActivity(intent1);
                    break;
                default:
                    break;
            }
        }

    }
}
