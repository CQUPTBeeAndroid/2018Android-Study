package com.example.yemian;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MessageFragment messageFragment;
    private ContactsFragment contactsFragment;
    private NewsFragment newsFragment;
    private SettingFragment settingFragment;
    private View messageLayout;
    private View contactsLayout;
    private View newsLayout;
    private View settingLayout;
    private ImageView messageImage;
    private  ImageView contactsImage;
    private ImageView newsImage;
    private ImageView settingImage;
    private TextView messageText;
    private TextView contactsText;
    private TextView newsText;
    private TextView settingText;
    private android.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getFragmentManager();
        setTabSelection(0);
    }
    private void initViews(){
        messageLayout=findViewById(R.id.message_layout);
        contactsLayout=findViewById(R.id.contacts_layout);
        newsLayout=findViewById(R.id.news_layout);
        settingLayout=findViewById(R.id.setting_layout);
        messageImage=(ImageView)findViewById(R.id.message_image);
        contactsImage=(ImageView)findViewById(R.id.contacts_image);
        newsImage=(ImageView)findViewById(R.id.news_image);
        settingImage=(ImageView)findViewById(R.id.setting_image);
        messageText=(TextView)findViewById(R.id.message_text);
        contactsText=(TextView)findViewById(R.id.contacts_text);
        newsText=(TextView)findViewById(R.id.news_text);
        settingText=(TextView)findViewById(R.id.setting_text);
        messageLayout.setOnClickListener(this);
        contactsLayout.setOnClickListener(this);
        newsLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.message_layout:
                setTabSelection(0);
                break;
            case R.id.contacts_layout:
                setTabSelection(1);
                break;
            case R.id.news_layout:
                setTabSelection(2);
                break;
            case R.id.setting_layout:
                setTabSelection(3);
                break;
                default:
                    break;
        }
    }
    private void setTabSelection(int index){
        clearSelection();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index){
            case 0:
                messageImage.setImageResource(R.mipmap.message);
                messageText.setTextColor(Color.RED);
                if(messageFragment == null){
                    messageFragment = new MessageFragment();
                    //放到content中
                    transaction.add(R.id.content,messageFragment);
                }
                else{
                    transaction.show(messageFragment);
                }
                break;
            case 1:
                messageImage.setImageResource(R.mipmap.message);
                messageText.setTextColor(Color.RED);
                if(contactsFragment == null){
                    contactsFragment = new ContactsFragment();
                    transaction.add(R.id.content,contactsFragment);
                }
                else{
                    transaction.show(contactsFragment);
                }
                break;
            case 2:
                messageImage.setImageResource(R.mipmap.message);
                messageText.setTextColor(Color.RED);
                if(newsFragment == null){
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.content,newsFragment);
                }
                else{
                    transaction.show(newsFragment);
                }
                break;
            case 3:
                messageImage.setImageResource(R.mipmap.message);
                messageText.setTextColor(Color.RED);
                if(settingFragment == null){
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.content,settingFragment);
                }
                else{
                    transaction.show(settingFragment);
                }
                break;
        }
        transaction.commit();
    }
    private void clearSelection(){
        messageImage.setImageResource(R.mipmap.message);
    }
    private void hideFragments(FragmentTransaction transaction){
        if(messageFragment != null){
            transaction.hide(messageFragment);
        }
        if(contactsFragment != null){
            transaction.hide(contactsFragment);
        }
        if(newsFragment != null){
            transaction.hide(newsFragment);
        }
        if(settingFragment != null){
            transaction.hide(settingFragment);
        }
    }
}
