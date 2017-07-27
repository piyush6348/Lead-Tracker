package com.codingblocks.leadtracker.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.model.Center;

import java.util.ArrayList;

/**
 * Created by nimit on 28/7/17.
 */

public class CentresAdapter extends RecyclerView.Adapter<CentresAdapter.ViewHolder> {

    ArrayList<Center> centerList;

    public CentresAdapter(ArrayList<Center> centerList) {
        this.centerList = centerList;
    }

    @Override
    public CentresAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.centers_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CentresAdapter.ViewHolder holder, int position) {

        //Setting name and address in view
        holder.centerName.setText(centerList.get(position).getName());
        holder.centerAddress.setText(centerList.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return centerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView centerName, centerAddress;
        public ViewHolder(View itemView) {
            super(itemView);

            centerName = (TextView) itemView.findViewById(R.id.center_name);
            centerAddress = (TextView) itemView.findViewById(R.id.center_address);
        }
    }
}
