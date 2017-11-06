package com.example.flavius.customcontactsapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flavius on 02-Nov-17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CardViewHolder> {


    public static class CardViewHolder extends RecyclerView.ViewHolder {

        public TextView contactName;
        public TextView phoneNumber;

        public CardViewHolder(View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.NameID);
            phoneNumber = itemView.findViewById(R.id.NumberID);
        }
    }

    List<ContactsCard> contactsData;


    public MyAdapter(List<ContactsCard> contactsData) {
        this.contactsData = new ArrayList<>(contactsData);
    }


    public void setNewList(ArrayList newList) {
        contactsData.clear();
        contactsData = new ArrayList<>(newList);
        notifyDataSetChanged();
    }
    

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_cardview_layout, parent, false);
        CardViewHolder myViewHolder = new CardViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int i) {
        holder.contactName.setText(contactsData.get(i).name);
        holder.phoneNumber.setText(contactsData.get(i).telephoneNumber);
    }

    @Override
    public int getItemCount() {

        return contactsData.size();
    }

}
