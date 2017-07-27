package com.codingblocks.leadtracker.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.fragments.LeadsFragment;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_dehaze_white_24dp);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView drawer = (NavigationView) findViewById(R.id.nvView);

        ActionBarDrawerToggle drawerToggle = setupDrawerToggle();
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        setUpDrawer(drawer);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }


    private void setUpDrawer(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItem(item);
                return true;
            }
        });
    }

    private void selectItem(MenuItem menuItem) {
        Fragment fragment = null;
        Class fragmentClass = null;
        switch (menuItem.getItemId()) {
            case R.id.leads_fragment:
                fragmentClass = LeadsFragment.class;
                break;
//            case R.id.dashboard_fragment:
//                fragmentClass = SecondFragment.class;
//                break;
//            case R.id.centers_fragment:
//                fragmentClass = ThirdFragment.class;
//                break;
//            case R.id.courses_fragment:
//                fragmentClass = ThirdFragment.class;
//                break;
            default:
                fragmentClass = LeadsFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();


        menuItem.setChecked(true);

        setTitle(menuItem.getTitle());

        drawerLayout.closeDrawers();
    }

}
