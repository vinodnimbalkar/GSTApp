package com.example.acer.gstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Aditya on 10/27/2017.
 */

public class Menu extends AppCompatActivity {

    ListView lv;
    int []Images={R.drawable.magnifier,R.drawable.cart,R.drawable.dinnerbell,R.drawable.about,R.drawable.icon};
    String [] options= {"Search","Tax Rates:Goods","Tax Rates:Services","About Us","Disclaimer"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lv=(ListView) findViewById(R.id.list);
        MyAdapter myAdapter= new MyAdapter(Menu.this,options,Images);
        lv.setAdapter(myAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0) {
                    Intent intent = new Intent(Menu.this, Search.class);

                    startActivity(intent);
                }
                if(i==1){
                    Intent intent= new Intent(Menu.this,Goods.class);
                    startActivity(intent);
                }

                if(i==2){
                    Intent intent= new Intent(Menu.this,Services.class);
                    startActivity(intent);
                }

                if(i==4){
                    AlertDialog.Builder mybuilder= new AlertDialog.Builder(Menu.this);
                    mybuilder.setTitle("Disclaimer");
                    mybuilder.setIcon(R.drawable.inf);
                    mybuilder.setMessage("GST stands for General Service Tax. The information contained in the mobile app is simplified representation of complete Rules and Regulation");
                    mybuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    AlertDialog alertDialog= mybuilder.create();
                    alertDialog.show();
                }

                if (i==3){
                    AlertDialog.Builder mybuilder= new AlertDialog.Builder(Menu.this);
                    mybuilder.setTitle("Connect us");
                    mybuilder.setIcon(R.drawable.connect);

                    mybuilder.setMessage("omvinod24@gmail.com rahulsawant@gmail.com");

                    mybuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    AlertDialog alertDialog= mybuilder.create();
                    alertDialog.show();
                }

            }
        });
    }



    public void onBackPressed() {


    }


}