package com.codingblocks.leadtracker.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codingblocks.leadtracker.model.LeadItem;

/**
 * Created by piyush on 27/7/17.
 */

public class LeadsAdapter extends RecyclerView.Adapter{

    private LeadItem[] listOfLeads;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,createdAt,updatedAt,message;
        Button email,call;

        public ViewHolder(View itemView, TextView name, TextView createdAt, TextView updatedAt, TextView message, Button email, Button call) {
            super(itemView);
            this.name = name;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.message = message;
            this.email = email;
            this.call = call;
        }
    }
    public LeadsAdapter(LeadItem[] listOfLeads){
        this.listOfLeads=listOfLeads;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listOfLeads.length;
    }
}
