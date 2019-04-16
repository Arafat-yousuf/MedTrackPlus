package com.example.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMed extends AppCompatActivity implements View.OnClickListener {

    private EditText mededit,mornedit,noonedit,evenedit;
    private Button addButton, cancelButton;

    Adatabase adatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_med);

        adatabase = new Adatabase(this);
        SQLiteDatabase sqLiteDatabase = adatabase.getWritableDatabase();

        mededit = findViewById(R.id.medid);
        mornedit = findViewById(R.id.mornid);
        noonedit = findViewById(R.id.noonid);
        evenedit = findViewById(R.id.eveid);
        addButton = findViewById(R.id.addid);
        cancelButton = findViewById(R.id.cancelid);

        mededit.setOnClickListener(this);
        mornedit.setOnClickListener(this);
        noonedit.setOnClickListener(this);
        evenedit.setOnClickListener(this);
        addButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        String med = mededit.getText().toString();
        int morn = Integer.parseInt(mornedit.getText().toString());
        int noon = Integer.parseInt(noonedit.getText().toString());
        int even = Integer.parseInt(evenedit.getText().toString());

        if(v.getId()==R.id.addid)
        {

            long rowid = adatabase.insertData(med,morn,noon,even);
            if(rowid == -1)
            {
                Toast.makeText(getApplicationContext(), "Error When Adding",Toast.LENGTH_LONG).show();
            }
            else Toast.makeText(getApplicationContext(), "Medicine Added",Toast.LENGTH_LONG).show();
        }

        if(v.getId()==R.id.cancelid)
        {

            Intent intent = new Intent(AddMed.this,MainActivity.class);
            startActivity(intent);
        }


    }
}
