package com.example.hp.level_3.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hp.level_3.R;
import com.example.hp.level_3.activity.Main3Activity;

/**
 * 聊天界面,不过只做了读取照片,偷懒...
 * @data:2018/5/5
 */
public class ChatFragment extends android.support.v4.app.Fragment {

    private Main3Activity activity;     //获取context

    public static final int CHOOSE_PHOTO = 2;     //常量,用于打开相册时传入的id.

    private ImageView picture;

    private Button chatImageBtn;        //用于获取照片的按钮

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.chat_fragment,container,false);

        activity = (Main3Activity)getActivity();

        picture = (ImageView)view.findViewById(R.id.chat_image);

        chatImageBtn = (Button)view.findViewById(R.id.chat_image_btn);

//        实现读取相册.
        chatImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                获取权限
                if(ContextCompat.checkSelfPermission(activity, Manifest.permission
                        .WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission
                            .WRITE_EXTERNAL_STORAGE},1);
                }else {
                    openAlbum();
                }
            }
        });

        return view;
    }

//    打开相册
    private void openAlbum(){
        Log.d("TAG","OPEN");
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,CHOOSE_PHOTO);
    }

//    获取权限,有权限打开相册.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions
            , @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openAlbum();
                }else {
                    Toast.makeText(activity,"无访问权限！",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

//    获取从相册返回的数据
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == CHOOSE_PHOTO){
            Log.d("TAG","返回数据成功！");
            if(Build.VERSION.SDK_INT >= 19) {
                Log.d("TAG","4.4以上版本");     //未增加对4.4以下版本的区分
                handleImageOnKitKat(data);
            }
        }
    }

//处理从相册获取的数据,判断是哪种类型.
    @SuppressLint("NewApi")
    private void handleImageOnKitKat(Intent data){

        String imagePath = null;
        Uri uri = data.getData();

        if(DocumentsContract.isDocumentUri(activity,uri)){
            String docId = DocumentsContract.getDocumentId(uri);

            if("com.android.providers.media.documents".equals(uri.getAuthority())){

                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);

            }else if("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public" +
                        "_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);

            }
        }else if("file".equalsIgnoreCase(uri.getScheme())){
            imagePath = uri.getPath();

//            一般会执行下面这一个
        }else if("content".equalsIgnoreCase(uri.getScheme())){
            imagePath = getImagePath(uri,null);

        }

        displayImage(imagePath);
    }

//    获取图片的标准地址
    private String getImagePath(Uri uri,String selection){
        String path = null;
        Cursor cursor = activity.getContentResolver().query(uri,null,selection,
                null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

//    根据地址读取图片,并展示
    private void displayImage(String imagePath){
        if(imagePath != null){
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            picture.setImageBitmap(bitmap);
            Log.d("TAG","Bit"+bitmap.getHeight());
        }else {
            Toast.makeText(activity,"No discover!",Toast.LENGTH_SHORT).show();
        }
    }
}
