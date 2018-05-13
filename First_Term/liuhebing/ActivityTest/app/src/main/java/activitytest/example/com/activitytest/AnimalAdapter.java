package activitytest.example.com.activitytest;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class AnimalAdapter extends ArrayAdapter<Animal> {

    private int resourceId;

    public AnimalAdapter(Context context, int textViewResourceId, List<Animal> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Animal animal=getItem(position);
        View view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        }
        else{
            view = convertView;
        }
        ImageView animalImage=(ImageView) view.findViewById(R.id.animal_image);
        TextView animalName=(TextView) view.findViewById(R.id.animal_name);
        animalImage.setImageResource(animal.getImageId());
        animalName.setText(animal.getName());
        return view;
    }

    /*@Override

    public View getview(int position,View convertView,ViewGroup parent){
        Animal animal=getItem(position);
        View view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        }
        else{
            view = convertView;
        }
        ImageView animalImage=(ImageView) view.findViewById(R.id.animal_image);
        TextView animalName=(TextView) view.findViewById(R.id.animal_name);
        animalImage.setImageResource(animal.getImageId());
        animalName.setText(animal.getName());
        return view;
    }*/
}
