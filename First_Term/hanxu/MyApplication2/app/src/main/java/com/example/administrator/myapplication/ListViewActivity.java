package com.example.administrator.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.MenuPopupWindow;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.security.spec.DSAPrivateKeySpec;
import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private String[] date = {"Apple", "Banana", "Orange", "Watermelon", "pear", "Grape", "Pineapple",
            "Strawberry", "Cherry", "Mango", "Apple", "Banana", "Orange", "Watermelon", "pear", "Grape"
            , "Pineapple", "Strawberry", "Cherry", "Mango"};

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        initFruit();
        FruitAdapter adapter=new FruitAdapter(ListViewActivity.this,R.layout.fruit_name,fruitList);
        //R.layout.fruit_name 什么情况

        //   ArrayAdapter<String> adapter = new ArrayAdapter<String>
        //     (ListViewActivity.this, android.R.layout.simple_expandable_list_item_1, date);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }


    //创建自定义适配器，继承ArrayAdapter，将泛型指定为Fruit
    public class FruitAdapter extends ArrayAdapter<Fruit> {
        private int resourceId;

        public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
            super(context, textViewResourceId, objects);
            resourceId = textViewResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Fruit fruit = getItem(position);//获取当前项的fruit实例

            View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
            fruitImage.setImageResource(fruit.getImageId());
            fruitName.setText(fruit.getName());
            return view;
        }
    }

    private void initFruit() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("为", R.drawable.orange);
            fruitList.add(apple);//将数据add到ArrayList<Fruit>中
            Fruit banana = new Fruit("什", R.drawable.orange);
            fruitList.add(banana);
            Fruit orange = new Fruit("么", R.drawable.orange);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("都", R.drawable.orange);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("是", R.drawable.orange);
            fruitList.add(pear);
            Fruit grape = new Fruit("水", R.drawable.orange);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("果", R.drawable.orange);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.orange);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.orange);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.orange);
            fruitList.add(mango);
        }

    }
}
