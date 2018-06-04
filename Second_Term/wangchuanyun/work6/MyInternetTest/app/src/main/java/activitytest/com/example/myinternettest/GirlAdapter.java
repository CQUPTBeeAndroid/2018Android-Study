package activitytest.com.example.myinternettest;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DialogTitle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 问荆 on 2018/5/30.
 */

public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.ViewHolder> {
    private List<String>mgirlPicUrl;
    private LayoutInflater mInflater;
    private Context mcontext;
    private Dialog dialog;

    public GirlAdapter( Context context,List<String>girlPicUrl){
        mgirlPicUrl = girlPicUrl;
        mcontext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.meizi_nihao,parent,false);
        ViewHolder holder = new ViewHolder(view);//加载出来的布局传入构造函数中
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ///holder.girlPic.setImageResource(girl.getImageId());
        Glide.with(mcontext).load(mgirlPicUrl.get(position)).into(holder.girlPic);
        dialog =new Dialog(mcontext);
        dialog.setContentView(R.layout.dialog);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.x = 0;
        layoutParams.y = 40;
        dialog.onWindowAttributesChanged(layoutParams);
        holder.girlPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ImageView imageView = (ImageView)dialog.findViewById(R.id.dialog);
                Glide.with(mcontext).load(mgirlPicUrl.get(position)).into(imageView);
                dialog.show();
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return mgirlPicUrl.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         ImageView girlPic;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView;
            girlPic = (ImageView)itemView.findViewById(R.id.girl_pic1);
        }
    }
}
