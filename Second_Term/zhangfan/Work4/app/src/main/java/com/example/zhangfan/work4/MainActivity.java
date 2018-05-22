package com.example.zhangfan.work4;

import android.Manifest;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ImageView imageView;
    public static final int TAKE_PHOTO = 1;
    public static final int CHOOSE_PHOTO =2;
    private Button videoBtn;
    private Uri imageUri;
    private TextView cancal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.icon_image);
        videoBtn = (Button)findViewById(R.id.video_button);
        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VideoActivity.class);
                startActivity(intent);
            }
        });
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.icons);
        }
        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_call:
                    case R.id.nav_friends:
                    case R.id.nav_mail:
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_task:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        final AlertDialog dialog = builder.create();
                        View view = View.inflate(MainActivity.this, R.layout.dialog_selection, null);
                        cancal = (TextView)findViewById(R.id.cancal);
                        TextView choosePhoto = (TextView) view.findViewById(R.id.choose_photo);
                        TextView takePhoto = (TextView) view.findViewById(R.id.take_photo);
                        choosePhoto.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                                    }, 1);
                                } else {
                                    openAlbum();
                                }
                            }
                        });
                        takePhoto.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                File outputImage = new File(getExternalCacheDir(),"out_image.jpg");
                                try{
                                    if (outputImage.exists()){
                                        outputImage.delete();
                                    }
                                    outputImage.createNewFile();
                                }catch (IOException e){
                                    e.printStackTrace();
                                }
                                if (Build.VERSION.SDK_INT>=24){
                                    imageUri = FileProvider.getUriForFile(MainActivity.this,
                                            "com.example.zhangfan.work4.fileprovider",outputImage);
                                }else {
                                    imageUri = Uri.fromFile(outputImage);
                                }
                                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                                startActivityForResult(intent,TAKE_PHOTO);
                            }
                        });

                        dialog.setCancelable(true);
                        dialog.setView(view);
                        dialog.show();
                        break;
                        default:
                }
                return true;
            }
        });
    }

                @Override
                public void onRequestPermissionsResult ( int requestCode,@NonNull String[] permissions, @NonNull int[] grantResults){
                    switch (requestCode) {
                        case 1:
                            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                                openAlbum();
                            } else {
                                Toast.makeText(this, "拒绝权限无法使用程序", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            break;
                        default:
                    }
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                }

                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                protected void onActivityResult ( int requestCode, int resultCode, Intent data){
                    switch (requestCode) {
                        case CHOOSE_PHOTO:
                            if (resultCode == RESULT_OK) {
                                if (Build.VERSION.SDK_INT >= 19) {
                                    handleImageOnKitKat(data);
                                } else {
                                    handleImageBeforeKitKat(data);
                                }
                            }
                            break;
                        case TAKE_PHOTO:
                            if (requestCode == RESULT_OK){
                                Bitmap bitmap = null;
                                try {
                                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                                imageView.setImageBitmap(bitmap);
                            }
                            break;
                        default:
                            break;
                    }
                }

                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                private void handleImageBeforeKitKat (Intent data){
                    Uri uri = data.getData();
                    String imagePath = getImagePath(uri, null);
                    displayImage(imagePath);


                }

                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                private void handleImageOnKitKat (Intent data){
                    String imagePath = null;
                    Uri uri = data.getData();
                    if (DocumentsContract.isDocumentUri(this, uri)) {
                        String docId = DocumentsContract.getDocumentId(uri);
                        if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                            String id = docId.split(":")[1];
                            String seletion = MediaStore.Images.Media._ID + "=" + id;
                            imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, seletion);
                        } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                            Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                            imagePath = getImagePath(contentUri, null);
                        }
                    } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                        imagePath = uri.getPath();
                    }
                    displayImage(imagePath);
                }

                private void displayImage (String imagePath ){
                    if (imagePath != null) {
                        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
                        imageView.setImageBitmap(bitmap);
                    } else {
                        Toast.makeText(this, "无法读取图片", Toast.LENGTH_LONG).show();
                    }
                }

                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                private String getImagePath (Uri uri, String selection){
                    String path = null;
                    Cursor cursor = getContentResolver().query(uri, null, selection, null, null, null);
                    if (cursor != null) {
                        if (cursor.moveToFirst()) {
                            path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                        }
                        cursor.close();
                    }
                    return path;
                }

                private void openAlbum () {
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.setType("image/*");
                    startActivityForResult(intent, CHOOSE_PHOTO);
                }

                @Override
                public boolean onCreateOptionsMenu (Menu menu){
                    getMenuInflater().inflate(R.menu.nav_menu, menu);
                    return true;
                }

                @Override
                public boolean onOptionsItemSelected (MenuItem item){
                    switch (item.getItemId()) {
                        case android.R.id.home:
                            if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                            } else {
                                mDrawerLayout.openDrawer(GravityCompat.START);
                            }
                            break;
                        default:
                    }
                    return true;
                }
            }


