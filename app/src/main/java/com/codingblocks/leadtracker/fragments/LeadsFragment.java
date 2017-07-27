package com.codingblocks.leadtracker.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.adapters.LeadsAdapter;
import com.codingblocks.leadtracker.model.LeadItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeadsFragment extends Fragment {

    private RecyclerView leadsRecyclerView;
    private LinearLayoutManager leadsLayoutManager;
    private LeadsAdapter leadsAdapter;

    public LeadsFragment() {
        // Required empty public constructor
    }

    private LeadItem[] listOfLeads;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View row= inflater.inflate(R.layout.fragment_leads, container, false);

        LeadItem leadItem=new LeadItem("My Name is Khan","piyush6348@gmail.com",
                "8587072927","27/07/2017","27/08/2017");

        listOfLeads=new LeadItem[1];
        listOfLeads[0]=leadItem;

        leadsRecyclerView=(RecyclerView) row.findViewById(R.id.leads_recycler_view);
        leadsRecyclerView.setHasFixedSize(true);
        leadsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        leadsAdapter=new LeadsAdapter(listOfLeads);
        leadsRecyclerView.setAdapter(leadsAdapter);
        return row;
    }

}
