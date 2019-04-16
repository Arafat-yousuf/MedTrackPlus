package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Adatabase extends SQLiteOpenHelper {

    private static final String Database_Name = "Medicine.db";
    private static final String Table_Name = "Medicines";
    private static final String Med_Name = "Name";
    private static final String ID = "_No";
    private static final String Time1 = "Morning";
    private static final String Time2 = "Noon";
    private static final String Time3 = "Evening";
    private static final int Version_Number = 1;
    private static final String Create_Table = "CREATE TABLE "+Table_Name+"( "+ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+Med_Name+" VARCHAR(255),"+Time1+" INTEGER,"+Time2+" INTEGER,"+Time3+" INTEGER );";
    private static final String Drop_Table = "DROP TABLE IF EXISTS "+ Table_Name;
    private static final String Select_All = "SELECT * FROM "+ Table_Name;
    private Context context;


    public Adatabase(Context context) {
        super(context, Database_Name, null, Version_Number);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            Toast.makeText(context, "onCreate Method Is Created",Toast.LENGTH_LONG).show();
            db.execSQL(Create_Table);

        }catch (Exception e)
        {
            Toast.makeText(context, "Exception : "+e,Toast.LENGTH_LONG).show();

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        /*try{
            Toast.makeText(context, "onUpgrade Method Is Created",Toast.LENGTH_LONG).show();
            db.execSQL(Drop_Table);
            onCreate(db);

        }catch (Exception e)
        {
            Toast.makeText(context, "Exception : "+e,Toast.LENGTH_LONG).show();

        }*/
    }

    public long insertData(String name, int morn, int noon , int even)
    {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Med_Name,name);
        contentValues.put(Time1,morn);
        contentValues.put(Time2,noon);
        contentValues.put(Time3,even);
        long rowID = sqLiteDatabase.insert(Table_Name,null,contentValues);

        return rowID;

    }

    public Cursor displayAllData()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(Select_All,null);
        return cursor;
    }
}
