package com.example.acer.gstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Goods3 extends AppCompatActivity {
    public static EditText searchText;
    Button click;
    public  static TextView data;
    ArrayList<String> numberlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods3);
        data = (TextView) findViewById(R.id.goods3data);
        get_json();
    }

    public void get_json(){
        String json;
        String result = "";
        try {
            InputStream is = getAssets().open("G3.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

//                numberlist.add("Type : " + obj.getString("type") + "\n" +
//                        "Description : " + obj.getString("description") + "\n" +
//                        "GST Rate : " + obj.getString("rate") + "\n" +
//                        "HSN : " + obj.getString("hsn") + "\n" +
//                        "Language : " + obj.getString("lang") + "\n");

                result +=  "Category : " + obj.get("type") + "\n"+
                        "Description : " + obj.get("description") + "\n"+
                        "GST Rate : " + obj.get("rate") + "\n"+
                        "HSN : " + obj.get("hsn") + "\n"+
                        "Language : " + obj.get("lang") + "\n\n";
            }

            Goods3.data.setText(result);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}
