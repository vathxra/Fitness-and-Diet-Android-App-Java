package com.example.myfitup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);

        bottomNav.setSelectedItemId(R.id.contact_us);

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
                        startActivity(new Intent(getApplicationContext(),
                                MainActivity5.class));
                        overridePendingTransition(0, 0 );
                        return true;
                    case R.id.contact_us:
                        return true;
                }
                return false;
            }
        });
    }
}