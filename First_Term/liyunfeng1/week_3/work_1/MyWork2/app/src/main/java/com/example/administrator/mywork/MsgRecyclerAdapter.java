package com.example.administrator.mywork;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class MsgRecyclerAdapter extends RecyclerView.Adapter<MsgRecyclerAdapter.ViewHolder> {
    private List<Msg> msgList;
    public MsgRecyclerAdapter(List<Msg> msgList){
        this.msgList=msgList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg=msgList.get(position);
        if (msg.getType()==Msg.Type_RECEIVED){
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        }else if(msg.getType()==Msg.TYPE_SEND){
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout=(LinearLayout)itemView.findViewById(R.id.left_layout);
            rightLayout=(LinearLayout)itemView.findViewById(R.id.right_layout);
            leftMsg=(TextView)itemView.findViewById(R.id.left_msg);
            rightMsg=(TextView)itemView.findViewById(R.id.right_msg);

        }
    }
}
