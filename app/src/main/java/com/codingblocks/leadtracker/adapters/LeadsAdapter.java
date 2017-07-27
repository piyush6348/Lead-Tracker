package com.codingblocks.leadtracker.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.model.LeadItem;

/**
 * Created by piyush on 27/7/17.
 */

public class LeadsAdapter extends RecyclerView.Adapter<LeadsAdapter.ViewHolder>{

    private LeadItem[] listOfLeads;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name,createdAt,updatedAt,message;
        public Button email,call;

        public ViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.lead_name);
            /*
            this.createdAt = itemView.findViewById(R.id.lead_createdAt);
            this.updatedAt = itemView.findViewById(R.id.lead_updatedAt);
            this.message = itemView.findViewById(R.id.lead_message);
            this.email = itemView.findViewById(R.id.lead_email);
            this.call = itemView.findViewById(R.id.lead_call);*/
        }
    }
    public LeadsAdapter(LeadItem[] listOfLeads){
        this.listOfLeads=listOfLeads;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lead_list_row_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LeadItem leadItem=listOfLeads[position];
        holder.name.setText(leadItem.getName());
    }

    @Override
    public int getItemCount() {
        return listOfLeads.length;
    }
}
