package com.example.materiatest3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder> {

    private static int Main_Item=1;
    private int Last_Item_state = 100;


    public class DemoViewHolder extends RecyclerView.ViewHolder {

        private TextView view;


        public DemoViewHolder(View itemView) {



            super(itemView);
            view = (TextView) itemView.findViewById(R.id.item_view);
        }

        public TextView getView() {
            return view;
        }
    }

    private List<String> data;

    public DemoAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {




            DemoViewHolder holder = new DemoViewHolder(LayoutInflater.from(
                    parent.getContext()).inflate(R.layout.item, parent,
                    false));
            return holder;
        }


    @Override
    public void onBindViewHolder(final DemoViewHolder holder, int position) {


            holder.getView().setText(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    @Override
    public int getItemViewType(int position) {
        if (position+1 == getItemCount()){
            return Last_Item_state;
        }else {
            return Main_Item;
        }
    }

    public class LastViewHolder extends RecyclerView.ViewHolder {
        TextView tvBottom;
        ProgressBar mProgressBar;
        public LastViewHolder(View itemView) {
            super(itemView);
            mProgressBar = itemView.findViewById(R.id.progressbar);
            tvBottom = itemView.findViewById(R.id.tvBottom);
        }
    }
}