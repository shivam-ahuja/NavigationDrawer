package com.letsmath.navigationdrawer_or_slidingpanel.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.letsmath.navigationdrawer_or_slidingpanel.R;
import com.letsmath.navigationdrawer_or_slidingpanel.fragments.Recycler_Fragment;
import com.letsmath.navigationdrawer_or_slidingpanel.fragments.Recycler_Grid;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private Recycler_Grid recyclerfragment2;
    private Recycler_Fragment recyclerfragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("views");
        mFragmentManager=getSupportFragmentManager();

        recyclerfragment1=new Recycler_Fragment();
        recyclerfragment2=new Recycler_Grid();
        drawer=(DrawerLayout)findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

   drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.listview) {
                    Toast.makeText(MainActivity.this,"listview selected",Toast.LENGTH_LONG).show();
                    mFragmentTransaction=mFragmentManager.beginTransaction();
                    mFragmentManager.popBackStack();

                } else if (id == R.id.recyclerview) {
                    Toast.makeText(MainActivity.this,"recycler view selected",Toast.LENGTH_LONG).show();
                    mFragmentTransaction=mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.myframelayout,recyclerfragment1);
                    mFragmentTransaction.addToBackStack(null);
                    mFragmentTransaction.commit();


                } else if(id==R.id.recyclergridview){
                    Toast.makeText(MainActivity.this,"grid recycler selected",Toast.LENGTH_LONG).show();
                    mFragmentTransaction=mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.myframelayout,recyclerfragment2);
                    mFragmentTransaction.addToBackStack(null);
                    mFragmentTransaction.commit();

                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }}
}
