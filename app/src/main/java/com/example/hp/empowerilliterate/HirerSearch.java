package com.example.hp.empowerilliterate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HirerSearch extends AppCompatActivity {
    EditText sch;
    Button find;
    String content,phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hirer_search);
        sch= (EditText) findViewById(R.id.sch);
        find= (Button) findViewById(R.id.find);
        phone=getIntent().getStringExtra("phone");

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content=sch.getText().toString();
                Intent intent = new  Intent (getApplicationContext(),HirerSearch1.class);
                content =sch.getText().toString();
                intent.putExtra("content",content);
                intent.putExtra("phone",phone);
                startActivity(intent);
                Toast.makeText(HirerSearch.this,"content:"+content,Toast.LENGTH_LONG).show();
                }
        });

    }
}
