package com.example.hp.empowerilliterate;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HirerHome extends AppCompatActivity {
    Button update,search,logout;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hirer_home);
        final Activity activity = this;
        this.setTitle("Hirer Home");
        update= (Button) findViewById(R.id.update);
        search= (Button) findViewById(R.id.search);
        logout= (Button) findViewById(R.id.logout);

        phone=getIntent().getStringExtra("phone");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HirerHome.this,HirerUpdate.class);
                intent.putExtra("phone", phone);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HirerHome.this,HirerSearch.class);
                intent.putExtra("phone",phone);
                startActivity(intent);
            }
        });



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HirerHome.this, HirerLogin.class);
                startActivity(intent);
            }
        });


    }
}
