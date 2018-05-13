package com.example.zhangfan.work2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment {
        private List<Contacts> contactsList = new ArrayList<>();
        static class ContactsAdapter extends RecyclerView.Adapter<ContactsFragment.ContactsAdapter.ViewHolder> {
            private List<Contacts> mContactsList;

            @Override
            public ContactsFragment.ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_item, parent, false);
                ContactsFragment.ContactsAdapter.ViewHolder holder = new ContactsFragment.ContactsAdapter.ViewHolder(view);
                return holder;
            }

            @Override
            public void onBindViewHolder(@NonNull ContactsFragment.ContactsAdapter.ViewHolder holder, int position) {
               Contacts contacts = mContactsList.get(position);
                holder.contactsName.setText(contacts.getName());
                holder.contactsId.setImageResource(contacts.getImageId());

            }

            @Override
            public int getItemCount() {
                return mContactsList.size();
            }

            static class ViewHolder extends RecyclerView.ViewHolder {
                ImageView contactsId;
                TextView contactsName;

                public ViewHolder(View view) {
                    super(view);
                    contactsId = (ImageView) view.findViewById(R.id.contacts_image);
                    contactsName = (TextView) view.findViewById(R.id.contacts_name);

                }
            }

            public ContactsAdapter(List<Contacts> ContactsList) {
                mContactsList = ContactsList;
            }
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
            View contactsLayout = inflater.inflate(R.layout.contacts_layout, container, false);
            initContacts();
            RecyclerView recyclerView = (RecyclerView) contactsLayout.findViewById(R.id.contacts_recycler_view);
            recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(),DividerItemDecoration.VERTICAL));

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
            recyclerView.setLayoutManager(linearLayoutManager);
            ContactsFragment.ContactsAdapter adapter = new ContactsFragment.ContactsAdapter(contactsList);
            recyclerView.setAdapter(adapter);
            return contactsLayout;
        }
        private void initContacts() {
            for (int i=0;i<1;i++){
                Contacts apple = new Contacts( R.drawable.apple,"苹果");
                contactsList.add(apple);
                Contacts banana = new Contacts ( R.drawable.banana,"香蕉");
                contactsList.add(banana);
                Contacts orange = new Contacts( R.drawable.orange,"橘子");
                contactsList.add(orange);
                Contacts watermalon = new Contacts( R.drawable.watermlon,"西瓜");
                contactsList.add(watermalon);
                Contacts pear = new Contacts( R.drawable.pear,"梨子");
                contactsList.add(pear);
                Contacts grape = new Contacts( R.drawable.grape,"葡萄");
                contactsList.add(grape);
                Contacts pineapple = new Contacts( R.drawable.pineapple,"菠萝");
                contactsList.add(pineapple);
                Contacts strawberry = new Contacts( R.drawable.strawberry,"草莓");
                contactsList.add(strawberry);
                Contacts cherry = new Contacts( R.drawable.cherry,"樱桃");
                contactsList.add(cherry);
                Contacts mango = new Contacts( R.drawable.mango,"芒果");
                contactsList.add(mango);
            }
        }
    }

