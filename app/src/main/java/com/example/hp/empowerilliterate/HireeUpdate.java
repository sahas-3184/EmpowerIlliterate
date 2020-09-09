package com.example.hp.empowerilliterate;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class HireeUpdate extends AppCompatActivity {
    EditText name,email,addr,exp,work;
    Button update;
    String phn;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiree_update);
        this.setTitle("Update Details");
        name= (EditText) findViewById(R.id.name);
        email= (EditText) findViewById(R.id.email);
        addr= (EditText) findViewById(R.id.addr);
        exp= (EditText) findViewById(R.id.exp);
        work= (EditText) findViewById(R.id.work);
        update= (Button) findViewById(R.id.update);
        phn=getIntent().getStringExtra("phone");
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")||email.getText().toString().equals("")||addr.getText().toString().equals("")||exp.getText().toString().equals("")||work.getText().toString().equals(""))
                {
                    Toast.makeText(HireeUpdate.this, "Enter All Fields", Toast.LENGTH_LONG).show();
                }else {
                    db = openOrCreateDatabase("empower", SQLiteDatabase.CREATE_IF_NECESSARY, null);
                    Cursor c = db.rawQuery("select * from hiree where phn='" + phn + "'", null);
                    if (c.moveToFirst()) {
                        db.execSQL("update hiree  set name ='" + name.getText().toString() + "', email='" + email.getText().toString() + "', addr ='" + addr.getText().toString() + "',yow='" + exp.getText().toString() + "',work='" + work.getText().toString() + "'");
                        Intent intent=new Intent(getApplicationContext(),HireeHome.class);
                        Toast.makeText(HireeUpdate.this, "Updated Successfully", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(HireeUpdate.this, "Updation Failed", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

}
}
