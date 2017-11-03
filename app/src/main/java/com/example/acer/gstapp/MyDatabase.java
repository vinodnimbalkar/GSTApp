package com.example.acer.gstapp;

/**
 * Created by Acer on 01-11-2017.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "gstlatest.db";
    private static final int DATABASE_VERSION = 3;
    public static final String GST_DESC = "description";
    public static final String GST_HSN = "hsn";
    public static final String GST_RATE = "rate";
    public static final String GST_TABLE = "gst_data";
    public static final String GST_TYPE = "type";
    private static final String GST_APP="gst_data";
    private SQLiteDatabase database;
    private DataBaseHelper dbHelper;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.dbHelper = new DataBaseHelper(context);
        this.database = this.dbHelper.getWritableDatabase();
    }

    public ArrayList<Poses> getPoses(){
        SQLiteDatabase db=getWritableDatabase();
        String[] columns={MyDatabase.GST_DESC,MyDatabase.GST_HSN,MyDatabase.GST_RATE,MyDatabase.GST_TABLE,MyDatabase.GST_TYPE};
        Cursor cursor=db.query(MyDatabase.GST_APP, columns, null, null, null, null, null);
        ArrayList<Poses> questionsArrayList=new ArrayList<>();

        while(cursor.moveToNext()){
            Poses questions=new Poses();
            questions.description=cursor.getString(cursor.getColumnIndex(MyDatabase.GST_DESC));
            questions.hsn=cursor.getString(cursor.getColumnIndex(MyDatabase.GST_HSN));
            questions.rate=cursor.getString(cursor.getColumnIndex(MyDatabase.GST_RATE));
            questions.gst_data=cursor.getString(cursor.getColumnIndex(MyDatabase.GST_TABLE));
            questions.type=cursor.getString(cursor.getColumnIndex(MyDatabase.GST_TYPE));
            questionsArrayList.add(questions);
        }
        return questionsArrayList;
    }
}
