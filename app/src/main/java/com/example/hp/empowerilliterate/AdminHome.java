package com.example.hp.empowerilliterate;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHome extends AppCompatActivity {
    Button hirers,hirees,search,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        final Activity activity=this;
        this.setTitle("Admin Home");

        hirers= (Button) findViewById(R.id.hirers);
        hirees= (Button) findViewById(R.id.hirees);
        search= (Button) findViewById(R.id.search);
        logout= (Button) findViewById(R.id.logout);

        hirers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (AdminHome.this,HirerDetails.class);
                startActivity(intent);
            }
        });
        hirees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (AdminHome.this,HireeDetails.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (AdminHome.this,SearchDetails.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, AdminLogin.class);
                startActivity(intent);
            }
        });
    }
}
