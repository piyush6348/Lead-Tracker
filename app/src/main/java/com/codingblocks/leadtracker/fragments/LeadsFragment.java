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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View row= inflater.inflate(R.layout.fragment_leads, container, false);

        leadsRecyclerView.setHasFixedSize(true);
        leadsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        leadsAdapter=new LeadsAdapter(/* Data Model Class*/);
        leadsRecyclerView.setAdapter(leadsAdapter);
        return row;
    }

}
