package activitytest.example.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/*public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder>{
        private List<Animal> mAnimalList;
        static class ViewHolder extends RecyclerView.ViewHolder{
            ImageView animalImage;
            TextView animalName;

            public ViewHolder(View view){
                super(view);
                animalImage=(ImageView) view.findViewById(R.id.animal_image);
                animalName = (TextView)view.findViewById(R.id.animal_name);
            }
        }

        public AnimalAdapter(List<Animal> animalList){
            mAnimalList=animalList;

        }

        public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override

        public void onBindViewHolder(ViewHolder holder,int position){
            Animal animal=mAnimalList.get(position);
            holder.animalImage.setImageResource(animal.getImageId());
            holder.animalName.setText(animal.getName());
        }

    @Override
    public int getItemCount(){
            return mAnimalList.size();
    }
}

*/
/*import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;*/

/**
 * Created by asus-pc on 2018/5/5.
 */

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    private List<Animal> mAnimalList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View animalView;
        ImageView animalImage;
        TextView animalName;

        public ViewHolder(View view) {
            super(view);
            animalView = view;
            animalImage = (ImageView) view.findViewById(R.id.animal_image);
            animalName = (TextView) view.findViewById(R.id.animal_name);
        }
    }
    public AnimalAdapter(List<Animal> animalList) {
        mAnimalList = animalList;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.
                animal_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.animalView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int position =holder.getAdapterPosition();
                Animal animal = mAnimalList.get(position);
                Toast.makeText(v.getContext(),"you clicked view"+animal.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.animalImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int position =holder.getAdapterPosition();
                Animal animal = mAnimalList.get(position);
                Toast.makeText(v.getContext(),"you clicked image"+animal.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override


    public void onBindViewHolder(ViewHolder holder, int position) {
        Animal animal = mAnimalList.get(position);
        holder.animalImage.setImageResource(animal.getImageId());
        holder.animalName.setText(animal.getName());
    }
    public int getItemCount(){
        return mAnimalList.size();
    }


}
