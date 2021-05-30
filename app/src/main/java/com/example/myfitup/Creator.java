package com.example.myfitup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Creator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creator);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);

        bottomNav.setSelectedItemId(R.id.creator);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.creator:
                        return true;
                    case R.id.about_us:
                        startActivity(new Intent(getApplicationContext(),
                                MainActivity5.class));
                        overridePendingTransition(0, 0 );
                        return true;
                    case R.id.contact_us:
                        startActivity(new Intent(getApplicationContext(),
                                ContactUs.class));
                        overridePendingTransition(0, 0 );
                        return true;
                }
                return false;
            }
        });
    }
}