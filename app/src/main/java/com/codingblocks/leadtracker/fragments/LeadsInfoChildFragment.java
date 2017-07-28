package com.codingblocks.leadtracker.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.leadtracker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeadsInfoChildFragment extends Fragment {


    public LeadsInfoChildFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leads_info_child, container, false);
    }

}
