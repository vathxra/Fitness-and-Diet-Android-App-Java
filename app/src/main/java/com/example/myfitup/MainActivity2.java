package com.example.myfitup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RelativeLayout keto = findViewById(R.id.keto);
        RelativeLayout karbo = findViewById(R.id.karbo);
        RelativeLayout vegan = findViewById(R.id.vegan);
        RelativeLayout vege = findViewById(R.id.vege);

        keto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity2.this, ActivityKeto.class);
                startActivity(a);
            }
        });
        karbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MainActivity2.this, ActivityKarbo.class);
                startActivity(b);
            }
        });
        vegan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(MainActivity2.this, ActivityVegan.class);
                startActivity(c);
            }
        });
        vege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(MainActivity2.this, ActivityVege.class);
                startActivity(d);
            }
        });
    }
}