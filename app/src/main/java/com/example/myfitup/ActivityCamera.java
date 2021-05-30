package com.example.myfitup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityCamera extends AppCompatActivity {

    ImageView image_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Button opencamera = findViewById(R.id.opencamera);
        image_view = findViewById(R.id.image_view);

        opencamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opencameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(opencameraintent,100);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            image_view.setImageBitmap(captureImage);
        }
    }
}