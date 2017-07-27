package com.codingblocks.leadtracker.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.adapters.CentresAdapter;
import com.codingblocks.leadtracker.model.Center;

import java.util.ArrayList;

/**
 * Created by Nimit on 27/7/17.
 */
public class CentreListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CentreListFragment() {
        // Required empty public constructor
    }

    public static CentreListFragment newInstance(String param1, String param2) {
        CentreListFragment fragment = new CentreListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private RecyclerView centerRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_centre_list, container, false);

        Center center = new Center("Pitampura", "47, Nishant Kunj, 1st Floor");
        ArrayList<Center> centerList = new ArrayList<>();

        for(int i=0;i<5;i++){
            centerList.add(center);
        }
        Log.e("Sd", centerList.toString());
        centerRecyclerView = (RecyclerView) rootView.findViewById(R.id.center_recycler_view);
        centerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        centerRecyclerView.setHasFixedSize(true);

        CentresAdapter centresAdapter = new CentresAdapter(centerList);
        centerRecyclerView.setAdapter(centresAdapter);

        return rootView;
    }


}
