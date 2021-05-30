package com.example.myfitup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        RelativeLayout arms = findViewById(R.id.arms);
        RelativeLayout butty = findViewById(R.id.butty);
        RelativeLayout legs = findViewById(R.id.legs);
        RelativeLayout belly = findViewById(R.id.belly);


        arms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity3.this, ArmsLevel.class);
                startActivity(a);
            }
        });
        butty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MainActivity3.this, BootsLevel.class);
                startActivity(b);
            }
        });
        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(MainActivity3.this, LegsLevel.class);
                startActivity(c);
            }
        });
        belly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(MainActivity3.this, BellyLevel.class);
                startActivity(d);
            }
        });
    }
}