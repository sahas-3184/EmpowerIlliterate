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
import android.widget.TextView;
import android.widget.Toast;

public class HireeLogin extends AppCompatActivity {

    Button reset,signin;
    EditText phone,pass;
    TextView newh;
    String hphn,hpass;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiree_login);

        final Activity activity = this;
        this.setTitle("Hiree Login");

        reset= (Button) findViewById(R.id.reset);
        signin= (Button) findViewById(R.id.signin);
        phone= (EditText) findViewById(R.id.phone);
        pass= (EditText) findViewById(R.id.pass);
        newh= (TextView) findViewById(R.id.newh);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone.setText("");
                pass.setText("");
            }
        });

        newh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HireeReg.class);
                startActivity(intent);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phone.getText().toString().equals("") || pass.getText().toString().equals("")) {
                    Toast.makeText(HireeLogin.this, "PLz enter the fields..!", Toast.LENGTH_LONG).show();
                } else {
                    hphn = phone.getText().toString();
                    hpass = pass.getText().toString();
                    try {

                        db = openOrCreateDatabase("empower", SQLiteDatabase.CREATE_IF_NECESSARY, null);

                    } catch (Exception exception) {

                        exception.printStackTrace();
                    }
                    try {
                        Cursor cc = db.rawQuery("select * from hiree where phn = '" + hphn + "' and pass = '" + hpass + "'", null);
                        cc.moveToFirst();

                        if (cc != null) {
                            if (cc.getCount() > 0) {
                                Intent i = new Intent(getApplicationContext(), HireeHome.class);
                                Toast.makeText(HireeLogin.this, "Welcome Hiree " + cc.getString(cc.getColumnIndex("name")), Toast.LENGTH_LONG).show();
                                i.putExtra("phone", phone.getText().toString());
                                startActivity(i);
                            } else {
                                Toast.makeText(getApplicationContext(), "You cant login", Toast.LENGTH_LONG).show();
                            }
                        }
                        //	return false;

                    } catch (Exception exception) {

                        exception.printStackTrace();

                    }

                }
            }
        });



    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent (HireeLogin.this,MainActivity.class);
        startActivity(i);
    }
}
