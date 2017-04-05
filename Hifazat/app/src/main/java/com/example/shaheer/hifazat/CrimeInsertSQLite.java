package com.example.shaheer.hifazat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shaheer on 01-Mar-17.
 */

public class CrimeInsertSQLite extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "insertCrime.db";
    public static final String TABLE_NAME = "crimeDetail";

    public static final String LATITUDE = "Latitude";
    public static final String LONGITUDE = "Longitude";
    public static final String LANDMARK = "Landmark";
    public static final String TYPE_OF_CRIME = "crimetype";
    public static final String DISCRIPTION = "Discription";

    public CrimeInsertSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table" + TABLE_NAME + "LATITUDE TEXT, LONGITUDE TEXT, LANDMARK TEXT,CRIMETYPE TEXT, DISCRIPTION TEXT");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exist " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String latitude,String longitude,String landmark,String crimetype,String discription){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LATITUDE,latitude);
        contentValues.put(LONGITUDE,longitude);
        contentValues.put(LANDMARK,landmark);
        contentValues.put(TYPE_OF_CRIME,crimetype);
        contentValues.put(DISCRIPTION,discription);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

}
