package com.codingblocks.leadtracker.adapters;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.fragments.LeadDetailsMain;
import com.codingblocks.leadtracker.model.LeadItem;

/**
 * Created by piyush on 27/7/17.
 */

public class LeadsAdapter extends RecyclerView.Adapter<LeadsAdapter.ViewHolder> implements
        View.OnClickListener{

    private LeadItem[] listOfLeads;

    @Override
    public void onClick(View v) {
       // Log.e("onClick: ", );
        int id=v.getId();
        if(id==R.id.lead_call){
            setUpCall();
        }
        else if(id== R.id.lead_email){
            setUpEmail();
        }
        else if(id== R.id.lead_card){
            FragmentManager fragmentManager = ((AppCompatActivity)v.getContext()).getSupportFragmentManager();
            fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.content, new LeadDetailsMain()).commit();
        }
    }

    private void setUpEmail() {
        Log.e("setUpEmail: ","DEBUG " );
    }

    private void setUpCall() {
        Log.e("setUpCall: ", "DEBUG ");
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name,createdAt,updatedAt,message;
        public ImageButton email,call;
        public CardView leadCard;
        public ViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.lead_name);

            this.createdAt = (TextView) itemView.findViewById(R.id.lead_createdAt);
            this.updatedAt = (TextView) itemView.findViewById(R.id.lead_updatedAt);
            leadCard=(CardView) itemView.findViewById(R.id.lead_card);
            //this.message = ()itemView.findViewById(R.id.lead_message);
            this.email = (ImageButton)itemView.findViewById(R.id.lead_email);
            this.call = (ImageButton)itemView.findViewById(R.id.lead_call);
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
        holder.createdAt.setText(leadItem.getCreatedAt());
        holder.updatedAt.setText(leadItem.getUpdatedAt());
        holder.call.setOnClickListener(this);
        holder.email.setOnClickListener(this);
        holder.leadCard.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return listOfLeads.length;
    }
}
