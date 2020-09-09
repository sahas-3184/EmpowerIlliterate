package com.example.hp.empowerilliterate;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HirerUpdate extends AppCompatActivity {

    EditText name,email,addr;
    Button updt;
    String phn;
    SQLiteDatabase db,db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hirer_update);
        this.setTitle("Update Details");
        name= (EditText) findViewById(R.id.name);
        email= (EditText) findViewById(R.id.email);
        addr= (EditText) findViewById(R.id.addr);
        updt= (Button) findViewById(R.id.updt);
        phn=getIntent().getStringExtra("phone");
        updt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")||email.getText().toString().equals("")||addr.getText().toString().equals(""))
                {
                    Toast.makeText(HirerUpdate.this, "Enter All Fields", Toast.LENGTH_LONG).show();
                }else {
                    db = openOrCreateDatabase("empower", SQLiteDatabase.CREATE_IF_NECESSARY, null);
                    Cursor c = db.rawQuery("select * from hirer where phn='" + phn + "'", null);
                    if (c.moveToFirst()) {
                        db.execSQL("update hirer  set name ='" + name.getText().toString() + "', email='" + email.getText().toString() + "', addr ='" + addr.getText().toString() + "'");
                        Toast.makeText(HirerUpdate.this, "Updated Successfully", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(HirerUpdate.this, "Updation Failed", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });



    }
}
