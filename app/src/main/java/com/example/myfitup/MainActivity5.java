package com.example.myfitup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);

        bottomNav.setSelectedItemId(R.id.about_us);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.creator:
                        startActivity(new Intent(getApplicationContext(),
                                Creator.class));
                        overridePendingTransition(0, 0 );
                        return true;
                    case R.id.about_us:
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