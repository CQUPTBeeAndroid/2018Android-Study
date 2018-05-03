package activitytest.com.example.refreshtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleviewActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_layout);
        initFruit();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter2 adapter2 = new FruitAdapter2(fruitList);
        recyclerView.setAdapter(adapter2);
    }

    private void initFruit(){
        for(int i =0; i<2;i++){
            Fruit apple = new Fruit("Apple",R.drawable.apple);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.banana);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.orange);
            fruitList.add(orange);
            Fruit watermelon= new Fruit("Watermelon",R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear",R.drawable.pear);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape",R.drawable.grape);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Apple",R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit mango = new Fruit("Mango",R.drawable.mango);
            fruitList.add(mango);
        }
    }
}