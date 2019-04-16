package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MedActivity extends AppCompatActivity implements View.OnClickListener {

    private Button addButton;

    private Adatabase adatabase;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med);

        adatabase = new Adatabase(this);

        addButton = findViewById(R.id.addmed);
        addButton.setOnClickListener(this);
        listView = findViewById(R.id.medviewid);
        loadData();

    }

    public void loadData()
    {
        ArrayList<String> listData = new ArrayList<>();

        Cursor cursor = adatabase.displayAllData();

        if(cursor.getCount() == 0)
        {
            Toast.makeText(getApplicationContext(),"Yay! You Are Healthy",Toast.LENGTH_LONG);
        }
        else {
            while(cursor.moveToNext()){
                listData.add(cursor.getString(0)+"\t\t\t\t\t"+cursor.getString(1)+"\t\t\t\t\t\t\t\t\t\t"+cursor.getString(2)+"\t\t\t"+cursor.getString(3)+"\t\t\t"+cursor.getString(4));
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.medviewid,listData);
        listView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.addmed)
        {
            Intent intent = new Intent(MedActivity.this,AddMed.class);
            startActivity(intent);

        }
    }
}
