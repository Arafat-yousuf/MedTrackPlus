package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Adatabase adatabase;

    private CardView medicineCard,bmiCard,emergencyCard,feedbackCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adatabase = new Adatabase(this);
        SQLiteDatabase db =  adatabase.getWritableDatabase();



        medicineCard = findViewById(R.id.medicine_id);
        bmiCard = findViewById(R.id.bmi_id);
        emergencyCard = findViewById(R.id.emergency_id);
        feedbackCard = findViewById(R.id.feedback_id);

        medicineCard.setOnClickListener(this);
        bmiCard.setOnClickListener(this);
        emergencyCard.setOnClickListener(this);
        feedbackCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.medicine_id)
        {
            Intent intent = new Intent(MainActivity.this,MedActivity.class);
            startActivity(intent);

        }
        else if(v.getId()==R.id.bmi_id)
        {
            Intent intent = new Intent(MainActivity.this,BMIActivity.class);
            startActivity(intent);

        }
        else if(v.getId()==R.id.emergency_id)
        {
            Intent intent = new Intent(MainActivity.this,EmergencyActivity.class);
            startActivity(intent);

        }
        else if(v.getId()==R.id.feedback_id)
        {
            Intent intent = new Intent(MainActivity.this,FeedbackActivity.class);
            startActivity(intent);

        }

    }
}
