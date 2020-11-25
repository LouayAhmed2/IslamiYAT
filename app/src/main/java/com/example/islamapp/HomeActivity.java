package com.example.islamapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.islamapp.fragments.QuranFragment;
import com.example.islamapp.fragments.RadioFragment;
import com.example.islamapp.fragments.SebhaFeragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView.OnNavigationItemSelectedListener
            onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            int id = menuItem.getItemId();
            Fragment fragment = null;
            switch (id) {
                case R.id.navigation_quran: {
                    fragment = new QuranFragment();
                    break;
                }
                case R.id.navigation_tasbeh: {
                    fragment = new SebhaFeragment();
                    break;
                }
                case R.id.navigation_radio: {
                    fragment = new RadioFragment();
                    break;
                }

            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_quran);

    }

}
