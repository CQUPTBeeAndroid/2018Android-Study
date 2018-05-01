package activitytest.example.com.work02_lv3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FruitAdapter1 extends RecyclerView.Adapter<FruitAdapter1.ViewHolder> {

    private List<Fruit> mFruitList;
    private Context context;
    private int normalType = 0;
    private int footType = 1;
    private boolean hasMore = true;
    private boolean fadeTips = false;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view ) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image1);
            fruitName = (TextView) view.findViewById(R.id.fruit_name1);
        }
    }

    public FruitAdapter1(List<Fruit> fruitList , Context context , boolean hasMore) {
        this.mFruitList = fruitList;
        this.context = context;
        this.hasMore = hasMore;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewtype) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item1, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        if(viewtype == normalType) {
            return new NormalHolder(LayoutInflater.from(context).inflate(R.layout.item, null));
        }else {
            return new FootHolder(LayoutInflater.from(context).inflate(R.layout.footview) , null);
        }

        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posotion = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(posotion);
                Toast.makeText(view.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posotion = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(posotion);
                Toast.makeText(view.getContext(), "you clicked image" + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder , int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());

        if (holder instanceof NormalHolder) {
            ((NormalHolder) holder).textView.setText(mFruitList.get(position));
        } else {
            ((FootHolder) holder).tips.setVisibility(View.VISIBLE);
            if (hasMore == true) {
                fadeTips = false;
                if (mFruitList.size() > 0) {
                    ((FootHolder) holder).tips.setText("正在加载更多...");
                }
            } else {
                if (mFruitList.size() > 0) {
                    ((FootHolder) holder).tips.setText("没有更多数据了");
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ((FootHolder) holder).tips.setVisibility(View.GONE);
                            fadeTips = true;
                            hasMore = true;
                        }
                    }, 500);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    public int getRealLastPosition() {
        return mFruitList.size();
    }


    public void updateList(List<String> newDatas, boolean hasMore) {
        if (newDatas != null) {
            mFruitList.addAll(newDatas);
        }
        this.hasMore = hasMore;
        notifyDataSetChanged();
    }

    class NormalHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public NormalHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv);
        }
    }

    class FootHolder extends RecyclerView.ViewHolder {
        private TextView tips;
        public FootHolder(View itemView) {
            super(itemView);
            tips = (TextView) itemView.findViewById(R.id.tips);
        }
    }

    public boolean isFadeTips() {
        return fadeTips;
    }

    public void resetDatas() {
        mFruitList = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return footType;
        } else {
            return normalType;
        }
    }
}

