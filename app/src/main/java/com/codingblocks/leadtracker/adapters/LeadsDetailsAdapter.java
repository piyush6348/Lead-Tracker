package com.codingblocks.leadtracker.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.codingblocks.leadtracker.fragments.LeadsCommentsChildFragment;
import com.codingblocks.leadtracker.fragments.LeadsInfoChildFragment;

/**
 * Created by piyush on 28/7/17.
 */

public class LeadsDetailsAdapter extends FragmentPagerAdapter {
    public static final int NUM_PAGES=2;

    public LeadsDetailsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return "Info";
        return "Comments";
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return new LeadsInfoChildFragment();
        return new LeadsCommentsChildFragment();
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
