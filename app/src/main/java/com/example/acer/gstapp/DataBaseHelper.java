package com.example.acer.gstapp;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataBaseHelper
        extends SQLiteAssetHelper
{

    private static final String DATABASE_NAME = "gstlatest.db";
    private static final int DATABASE_VERSION = 3;



    public DataBaseHelper(Context context)
    {
        super(context, "gstlatest.db", null, 3);

        String json = null;
        try {
            InputStream is = context.getAssets().open("gstlatest.db");
            int size = is.available();
            OutputStream myoutput = new FileOutputStream("/data/data/-----PACKAGE NAME------/databases/gstlatest.db");

            byte[] buffer = new byte[size];
            int length;
            while ((length = is.read(buffer)) > 0) {
                myoutput.write(buffer, 0, length);
            }

            //Close the streams
            myoutput.flush();
            myoutput.close();
            is.close();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
           // return null;
        }
       // return json;
    }
}