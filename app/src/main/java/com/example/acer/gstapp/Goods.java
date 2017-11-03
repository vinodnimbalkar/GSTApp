package com.example.acer.gstapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Goods extends AppCompatActivity {

    ListView goodlv1;
    String [] suboptions= {"Goods @0%","Goods @0.25%","Goods @3%","Goods @5%","Goods @12%","Goods @18%","Goods @28%"};
    int []Images={R.drawable.cartl,R.drawable.cartl,R.drawable.cartl,R.drawable.cartl,R.drawable.cartl,R.drawable.cartl,R.drawable.cartl};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        goodlv1=(ListView)findViewById(R.id.goodlv);
        MyAdapterr goodadp= new MyAdapterr(Goods.this,suboptions,Images);
        goodlv1.setAdapter(goodadp);
        goodlv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0) {
                    Intent intent = new Intent(Goods.this, Goods0.class);

                    startActivity(intent);
                }
                if(i==1){
                    Intent intent= new Intent(Goods.this,Goods2.class);
                    startActivity(intent);
                }

                if(i==2){
                    Intent intent= new Intent(Goods.this,Goods3.class);
                    startActivity(intent);
                }

                if(i==3){
                    Intent intent= new Intent(Goods.this,Goods5.class);
                    startActivity(intent);
                }

                if(i==4){
                    Intent intent= new Intent(Goods.this,Goods12.class);
                    startActivity(intent);
                }

                if(i==5){
                    Intent intent= new Intent(Goods.this,Goods18.class);
                    startActivity(intent);
                }

                if(i==6){
                    Intent intent= new Intent(Goods.this,Goods28.class);
                    startActivity(intent);
                }

            }
        });
    }
}
