package com.example.materiatest3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author 14512
 */

public class ContactsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Contact> mContacts;
    private OnItemClickListener1 mOnItemClickListener;

    private static int Main_Item=1;
    private int Last_Item_state = 100;

    public void setOnItemClickListener(OnItemClickListener1 onItemClickListener1) {
        this.mOnItemClickListener = onItemClickListener1;
    }

    public ContactsAdapter(ArrayList<Contact> contacts) {
        this.mContacts = contacts;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Last_Item_state) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_footer_view, parent, false);
            return new LastViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recycler_view, parent, false);
            return new ContactViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LastViewHolder) {
            ((LastViewHolder) holder).tvBottom.setText("上拉加载更多...");

        } else {
            final ContactViewHolder holder1 = (ContactViewHolder) holder;
            final Contact contact = mContacts.get(position);
            holder1.mImageView.setText(contact.getPortraitId());
            holder1.mTextView.setText(contact.getName());

        }
    }

    @Override
    public int getItemCount() {
        return mContacts.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position+1 == getItemCount()){
            return Last_Item_state;
        }else {
            return Main_Item;
        }
    }

    public void swipeAddData(ArrayList<Contact> addData) {
       mContacts.addAll(0, addData);
       notifyDataSetChanged();
    }

    public void upAddData(ArrayList<Contact> addData) {
        mContacts.addAll(addData);
        notifyDataSetChanged();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView mImageView;
        TextView mTextView;

        public ContactViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mImageView = itemView.findViewById(R.id.imgPortrait);
            mTextView = itemView.findViewById(R.id.tvName);
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
