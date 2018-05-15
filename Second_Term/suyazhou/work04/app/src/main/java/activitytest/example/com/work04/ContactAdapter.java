package activitytest.example.com.work04;

import android.support.v7.widget.RecyclerView;
import android.text.StaticLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private List<Contact> mcontactList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView contactName;

        public ViewHolder(View view) {
            super(view);
            contactName = (TextView) view.findViewById(R.id.contact_name);
            }
        }

    public ContactAdapter(List<Contact> contactList) {
        mcontactList = contactList;
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item , parent , false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder , int position) {
        Contact contact = mcontactList.get(position);
        holder.contactName.setText(contact.getName());
    }

    @Override
    public int getItemCount() {
        return mcontactList.size();
    }
}
