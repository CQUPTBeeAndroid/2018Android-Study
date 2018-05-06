package activitytest.example.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Animal> animalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        initAnimals();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        AnimalAdapter adapter= new AnimalAdapter(animalList);
        recyclerView.setAdapter(adapter);
    }

    private void initAnimals(){
        for(int i=0;i<2;i++) {

            /*Animal bee = new Animal("bee", R.drawable.bee);
            animalList.add(bee);*/
            Animal cat = new Animal(getRandomLengthName("bee"), R.mipmap.ic_launcher);
            animalList.add(cat);
            Animal cow = new Animal(getRandomLengthName("cow"),R.mipmap.ic_launcher);
            animalList.add(cow);
            Animal dog = new Animal(getRandomLengthName("dog"), R.mipmap.ic_launcher);
            animalList.add(dog);
            Animal fish = new Animal(getRandomLengthName("fish"), R.mipmap.ic_launcher);
            animalList.add(fish);
            Animal fly = new Animal(getRandomLengthName("fly"), R.mipmap.ic_launcher);
            animalList.add(fly);
            Animal goat = new Animal(getRandomLengthName("goat"), R.mipmap.ic_launcher);
            animalList.add(goat);
            Animal hen = new Animal(getRandomLengthName("hen"), R.mipmap.ic_launcher);
            animalList.add(hen);
            Animal panda = new Animal(getRandomLengthName("panda"), R.mipmap.ic_launcher);
            animalList.add(panda);
            Animal pig = new Animal(getRandomLengthName("pig"), R.mipmap.ic_launcher);
            animalList.add(pig);
            Animal sheep = new Animal(getRandomLengthName("sheep"), R.mipmap.ic_launcher);
            animalList.add(sheep);
            Animal zebra = new Animal(getRandomLengthName("zebra"), R.mipmap.ic_launcher);
            animalList.add(zebra);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int langth = random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();

        int length=20;
        for(int i = 0; i< length; i++){
            builder.append(name);
        }
        return builder.toString();
    }

}
