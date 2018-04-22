import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Constellation;
import com.example.myapplication.R;

import java.util.List;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder>{

    private List<Constellation> mPictureList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView PictureImage;
        TextView PictureName;

        public ViewHolder(
                View view)

        {
            super(view);
            PictureImage = (ImageView) view.findViewById(R.id.constellation_image);
            PictureName = (TextView) view.findViewById(R.id.constellation_name);
        }
    }

    public PictureAdapter(List<Constellation> constellationList) {
        mPictureList =constellationList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.constellation, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Constellation constellation = mPictureList.get(position);
        holder.PictureImage.setImageResource(constellation.getImageId());
        holder.PictureName.setText(constellation.getName());
    }

    @Override
    public int getItemCount() {
        return mPictureList.size();
    }
}
