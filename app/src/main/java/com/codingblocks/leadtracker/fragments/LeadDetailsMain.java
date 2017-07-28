package com.codingblocks.leadtracker.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.adapters.LeadsDetailsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeadDetailsMain extends Fragment {

    private ViewPager leadsDetailsViewPager;
    private LeadsDetailsAdapter leadsDetailsAdapter;
    private PagerTitleStrip pagerTitleStrip;
    public LeadDetailsMain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView= inflater.inflate(R.layout.fragment_lead_details_main, container, false);
        leadsDetailsViewPager= (ViewPager) mainView.findViewById(R.id.leads_details_viewpager);
        pagerTitleStrip= (PagerTitleStrip) mainView.findViewById(R.id.leads_details_viewpager_fragment_title);
        leadsDetailsAdapter= new LeadsDetailsAdapter(getChildFragmentManager());
        leadsDetailsViewPager.setAdapter(leadsDetailsAdapter);
        return mainView;
    }

}
