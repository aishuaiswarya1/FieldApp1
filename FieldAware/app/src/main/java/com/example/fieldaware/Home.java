package com.example.fieldaware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FragmentManager manager;
    ProfileFragment profileFragment;
    HomeFragment homeFragment;
    SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        manager = getSupportFragmentManager();
        profileFragment = new ProfileFragment();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frag_container, new HomeFragment());
                    transaction.commit();
                    return true;
                case R.id.navigation_profile:
                    FragmentTransaction transaction1 = manager.beginTransaction();
                    transaction1.replace(R.id.frag_container, new ProfileFragment());
                    transaction1.commit();
                    return true;
                case R.id.mSetting:
                    FragmentTransaction transaction2 = manager.beginTransaction();
                    transaction2.replace(R.id.frag_container, new SettingsFragment());
                    transaction2.commit();
                    return true;
            }
            return false;
        }
    };
}