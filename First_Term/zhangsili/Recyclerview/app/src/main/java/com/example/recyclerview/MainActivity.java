package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutMannager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutMannager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }



    private void initFruits(){
        for(int i=0;i<2;i++)
        {

            Fruit Pineapple = new Fruit("Pineapple",R.drawable.pineapple);
            fruitList.add(Pineapple);
            Fruit Pear = new Fruit("Pear",R.drawable.pear);
            fruitList.add(Pear);
            Fruit Mango = new Fruit("Mango",R.drawable.mango);
            fruitList.add(Mango);
            Fruit Cherry = new Fruit("Cherry",R.drawable.cherry);
            fruitList.add(Cherry);
            Fruit Banana = new Fruit("Banana",R.drawable.banana);
            fruitList.add(Banana);
            Fruit Watermelon = new Fruit("Watermelon",R.drawable.watermelon);
            fruitList.add(Watermelon);
            Fruit Grape = new Fruit("Grape",R.drawable.grape);
            fruitList.add(Grape);
            Fruit Strawberry = new Fruit("Strawberry",R.drawable.strawberry);
            fruitList.add(Strawberry);
            Fruit Orange = new Fruit("Orange",R.drawable.orange);
            fruitList.add(Orange);

        }
    }


}


