package com.example.hp.empowerilliterate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HireeHome extends AppCompatActivity {
    Button hupdate,hits,logout;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiree_home);
        hupdate= (Button) findViewById(R.id.hupdate);
        hits= (Button) findViewById(R.id.hits);
        logout= (Button) findViewById(R.id.logout);
        phone=getIntent().getStringExtra("phone");
        hupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(HireeHome.this,HireeUpdate.class);
                i.putExtra("phone",phone);
                startActivity(i);
            }
        });
        hits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HireeHome.this,HireeHits.class);
                i.putExtra("phone",phone);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HireeHome.this, HireeLogin.class);
                i.putExtra("phone",phone);
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {

    }
}
