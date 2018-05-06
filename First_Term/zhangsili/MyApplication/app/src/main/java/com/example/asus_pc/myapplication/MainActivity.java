package com.example.asus_pc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Fruit> FruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit_item);
        initFruits();
        FruitAdapter adapter=new FruitAdapter(MainActivity.this,R.layout.fruit_item,FruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position,long id){
                Fruit Fruit = FruitList.get(position);
                Toast.makeText(MainActivity.this,Fruit.getName(),Toast.LENGTH_SHORT).show();

            }
        });
    }



    private void initFruits(){
        for(int i=0;i<2;i++)
        {

            Fruit Pineapple = new Fruit("Pineapple",R.drawable.pineapple);
            FruitList.add(Pineapple);
            Fruit Pear = new Fruit("Pear",R.drawable.pear);
            FruitList.add(Pear);
            Fruit Mango = new Fruit("Mango",R.drawable.mango);
            FruitList.add(Mango);
            Fruit Cherry = new Fruit("Cherry",R.drawable.cherry);
            FruitList.add(Cherry);
            Fruit Banana = new Fruit("Banana",R.drawable.banana);
            FruitList.add(Banana);
            Fruit Watermelon = new Fruit("Watermelon",R.drawable.watermelon);
            FruitList.add(Watermelon);
            Fruit Grape = new Fruit("Grape",R.drawable.grape);
            FruitList.add(Grape);
            Fruit Strawberry = new Fruit("Strawberry",R.drawable.strawberry);
            FruitList.add(Strawberry);
            Fruit Orange = new Fruit("Orange",R.drawable.orange);
            FruitList.add(Orange);

        }
    }


}


