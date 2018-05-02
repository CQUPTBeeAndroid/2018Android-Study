package activitytest.example.com.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Toast;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Animal> animalList=new ArrayList<>();
    //private String [] data={"dog","goat","zebra","panda","cat","pig","bee","sheep","fish","cow","hen","fly","rat","rabbit","line","tiger","wolf","horse","deer"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        initAnimals();
        AnimalAdapter adapter=new AnimalAdapter(MainActivity.this,R.layout.animal_item,animalList);
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, data);*/
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position,long id){
                Animal animal = animalList.get(position);
                Toast.makeText(MainActivity.this,animal.getName(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initAnimals(){
        for(int i=0;i<2;i++)
        {

            Animal bee = new Animal("bee",R.drawable.bee);
            animalList.add(bee);
            Animal cat = new Animal("cat",R.drawable.cat);
            animalList.add(cat);
            Animal cow = new Animal("cow",R.drawable.cow);
            animalList.add(cow);
            Animal dog = new Animal("dog",R.drawable.dog);
            animalList.add(dog);
            Animal fish = new Animal("fish",R.drawable.fish);
            animalList.add(fish);
            Animal fly = new Animal("fly",R.drawable.fly);
            animalList.add(fly);
            Animal goat = new Animal("goat",R.drawable.goat);
            animalList.add(goat);
            Animal hen = new Animal("hen",R.drawable.hen);
            animalList.add(hen);
            Animal panda = new Animal("panda",R.drawable.panda);
            animalList.add(panda);
            Animal pig = new Animal("pig",R.drawable.pig);
            animalList.add(pig);
            Animal sheep = new Animal("sheep",R.drawable.sheep);
            animalList.add(sheep);
            Animal zebra = new Animal("zebra",R.drawable.zebra);
            animalList.add(zebra);

        }
    }


}
