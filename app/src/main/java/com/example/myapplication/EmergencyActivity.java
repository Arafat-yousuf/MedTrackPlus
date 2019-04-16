package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EmergencyActivity extends AppCompatActivity implements View.OnClickListener{


    private static final int REQUEST_CALL = 1;
    private TextView hos1num1,hos1num2,hos1num3,amb1num1,amb1num2,amb1num3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);


        hos1num1 = findViewById(R.id.h1n1);
        hos1num2 = findViewById(R.id.h1n2);
        hos1num3 = findViewById(R.id.h1n3);
        amb1num1 = findViewById(R.id.a1n1);
        amb1num2 = findViewById(R.id.a1n2);
        amb1num3 = findViewById(R.id.a1n3);

        hos1num1.setOnClickListener(this);
        hos1num2.setOnClickListener(this);
        hos1num3.setOnClickListener(this);

        amb1num1.setOnClickListener(this);
        amb1num2.setOnClickListener(this);
        amb1num3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.h1n1)
        {
            makePhoneCall(hos1num1);
        }
        else if(v.getId()==R.id.h1n2)
        {
            makePhoneCall(hos1num2);
        }
        else if(v.getId()==R.id.h1n3)
        {
            makePhoneCall(hos1num3);
        }
        else if(v.getId()==R.id.a1n1)
        {
            makePhoneCall(amb1num1);
        }
        else if(v.getId()==R.id.a1n2)
        {
            makePhoneCall(amb1num2);
        }
        else if(v.getId()==R.id.a1n3)
        {
            makePhoneCall(amb1num3);
        }
    }
    private void makePhoneCall(TextView num) {

        String number = num.getText().toString();

            if (ContextCompat.checkSelfPermission(EmergencyActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(EmergencyActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }


    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall(String number);
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }*/


}
