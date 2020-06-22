package com.example.droidcaffev1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpger);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);

        setSupportActionBar(toolbar);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tablabel_1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tablabel_2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tablabel_3));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.pizza:

                Intent Pintent = new Intent(this, PizzaActivity.class);
                startActivity(Pintent);
                break;
            case R.id.burger:
                Intent Bintent = new Intent(this, BurgerActivity.class);
                startActivity(Bintent);
                break;
            case R.id.specials:
                Intent Sintent = new Intent(this, BurgerActivity.class);
                startActivity(Sintent);
                break;
            case R.id.contact:
                Toast.makeText(getApplicationContext(),"contacts are not offered today",Toast.LENGTH_LONG).show();
                break;
            case R.id.help:
                Toast.makeText(getApplicationContext(),"Reach out through droid@mail.ke",Toast.LENGTH_LONG).show();
                break;
            case R.id.logout:
                Toast.makeText(getApplicationContext(),"Logout successful",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
