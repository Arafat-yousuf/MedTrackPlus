package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BMIActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioButton malebutton, femalebutton;
    private double bmi;
    private EditText weight, height;
    private Button okbutton;
    private TextView resultview;
    private String state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        //malebutton = findViewById(R.id.malebuttonid);
        //femalebutton = findViewById(R.id.femalebuttonid);
        weight = findViewById(R.id.weightid);
        height = findViewById(R.id.heightid);
        okbutton = findViewById(R.id.okbuttonid);
        resultview = findViewById(R.id.resultid);

        //malebutton.setOnClickListener(this);
        //femalebutton.setOnClickListener(this);
        weight.setOnClickListener(this);
        height.setOnClickListener(this);
        okbutton.setOnClickListener(this);
        resultview.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String weightnum = weight.getText().toString();
        String heightnum = height.getText().toString();

        double weight1 = Double.parseDouble(weightnum);
        double height1 = Double.parseDouble(heightnum);
        if(v.getId()==R.id.okbuttonid)
        {
            double bmi = weight1 / (height1*height1);
            if(bmi<18.5)
            {
                state = "Underweight";
            }
            else if(bmi>=18.5 && bmi<=25)
            {
                state = "Normal";
            }
            else if(bmi>25 && bmi<=30)
            {
                state = "Overweight";
            }
            else if(bmi>30 && bmi<=35)
            {
                state = "Moderately Obese";
            }
            else if(bmi>35)
            {
                state = "Severely Obese";
            }

            resultview.setText("Your BMI is "+new DecimalFormat("##.##").format(bmi)+"\nwhich is "+state);



        }

    }
}
