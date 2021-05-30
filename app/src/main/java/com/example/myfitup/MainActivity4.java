package com.example.myfitup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import static java.lang.Compiler.disable;

public class MainActivity4 extends AppCompatActivity {

    SwitchCompat wifiswitch;
    SwitchCompat bluetoothswitch;
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    LinearLayout kamera;
    LinearLayout gps;
    private LocationRequest locationRequest;
    public static final int REQUEST_CHECK_SETTING = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        wifiswitch = findViewById(R.id.wifi_button);
        bluetoothswitch = findViewById(R.id.bluetooth_button);
        kamera = findViewById(R.id.camera_akses);
        gps = findViewById(R.id.gps_access);


        if (bluetoothAdapter.isEnabled()){
            bluetoothswitch.setChecked(true);
        }else {
            bluetoothswitch.setChecked(false);
        }

        wifiswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 22){
                    checkPermission();
                }else {
                    wifiswitch();
                }
            }
            private void wifiswitch(){
                if (wifiswitch.isChecked()){
                    WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(true);
                }else {
                    WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(false);
                }
            }
            private void checkPermission(){
                if (ContextCompat.checkSelfPermission(MainActivity4.this,
                        Manifest.permission.ACCESS_WIFI_STATE) != PackageManager.PERMISSION_GRANTED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity4.this,
                            Manifest.permission.ACCESS_WIFI_STATE)){
                        Toast.makeText(MainActivity4.this, "Harap terima ini jika ingin akses wifi", Toast.LENGTH_SHORT).show();
                    }else{
                        ActivityCompat.requestPermissions(MainActivity4.this, new String[]{Manifest.permission.ACCESS_WIFI_STATE}, 100);
                    }
                }else {
                    wifiswitch();
                }
            }
        });

        bluetoothswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bluetoothAdapter == null){
                    Toast.makeText(MainActivity4.this, "Bluetooth Not Supported", Toast.LENGTH_SHORT).show();
                }if (Build.VERSION.SDK_INT >= 22){
                    checkPermission();
                }else {
                    bluetoothswitch();
                }
            }
            private void bluetoothswitch(){
                if (bluetoothswitch.isChecked()){
                    bluetoothAdapter.enable();
                }else {
                    bluetoothAdapter.disable();
                }
            }
            private void checkPermission(){
                if (ContextCompat.checkSelfPermission(MainActivity4.this,
                        Manifest.permission.BLUETOOTH) != PackageManager.PERMISSION_GRANTED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity4.this,
                            Manifest.permission.BLUETOOTH)){
                        Toast.makeText(MainActivity4.this, "Harap terima ini jika ingin akses bluetooth", Toast.LENGTH_SHORT).show();
                    }else {
                        ActivityCompat.requestPermissions(MainActivity4.this, new String[]{Manifest.permission.BLUETOOTH}, 100);
                    }
                }else {
                    bluetoothswitch();
                }
            }
        });

        kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 22){
                    checkPermission();
                }else {
                    kamera();
                }
            }
            private void checkPermission(){
                if (ContextCompat.checkSelfPermission(MainActivity4.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity4.this,
                            Manifest.permission.CAMERA)){
                        Toast.makeText(MainActivity4.this, "Please Allow Required Permission", Toast.LENGTH_SHORT).show();
                    }else {
                        ActivityCompat.requestPermissions(MainActivity4.this, new String[]{Manifest.permission.CAMERA}, 100);
                    }
                }else {
                    kamera();
                }
            }
            private void kamera(){
                Intent cameraIntent = new Intent(MainActivity4.this, ActivityCamera.class);
                startActivity(cameraIntent);
            }
        });

        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                locationRequest = LocationRequest.create();
                locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                locationRequest.setInterval(5000);
                locationRequest.setFastestInterval(2000);

                LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                        .addLocationRequest(locationRequest);
                builder.setAlwaysShow(true);

                Task<LocationSettingsResponse> result = LocationServices.getSettingsClient(getApplicationContext())
                        .checkLocationSettings(builder.build());

                result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
                    @Override
                    public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
                        try {
                            LocationSettingsResponse response = task.getResult(ApiException.class);
                            Toast.makeText(MainActivity4.this, "GPS in On", Toast.LENGTH_SHORT).show();
                        } catch (ApiException e) {
                            switch (e.getStatusCode()){
                                case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                                    try {
                                        ResolvableApiException resolvableApiException = (ResolvableApiException)e;
                                        resolvableApiException.startResolutionForResult(MainActivity4.this,REQUEST_CHECK_SETTING);
                                    } catch (IntentSender.SendIntentException ex) {

                                    }
                                    break;
                                case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                    break;
                            }
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CHECK_SETTING){
            switch (requestCode){
                case Activity.RESULT_OK:
                    Toast.makeText(this, "GPS is Turned on", Toast.LENGTH_SHORT).show();
                    break;

                case Activity.RESULT_CANCELED:
                    Toast.makeText(this, "GPS is required yo be turned on", Toast.LENGTH_SHORT).show();
            }
        }
    }
}