package com.example.hp.empowerilliterate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button admin,hirer,hiree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        admin= (Button) findViewById(R.id.admin);
        hirer= (Button) findViewById(R.id.hirer);
        hiree= (Button) findViewById(R.id.hiree);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),AdminLogin.class);
                startActivity(intent);
            }
        });
        hirer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HirerLogin.class);
                startActivity(intent);
            }
        });
        hiree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HireeLogin.class);
                startActivity(intent);
            }
        });
    }
}
