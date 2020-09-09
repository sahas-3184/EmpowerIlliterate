package com.example.hp.empowerilliterate;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class HirerReg extends AppCompatActivity {
    EditText uname,pass,email,phone,add;
    Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Activity activity=this;
        this.setTitle("Hirer Registration");
        setContentView(R.layout.activity_hirer_reg);
        uname= (EditText) findViewById(R.id.uname);
        pass= (EditText) findViewById(R.id.pass);
        email= (EditText) findViewById(R.id.email);
        phone= (EditText) findViewById(R.id.phone);
        add= (EditText) findViewById(R.id.add);
        sub= (Button) findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uname.getText().toString().equals("")||email.getText().toString().equals("")|| pass.getText().toString().equals("")||phone.getText().toString().equals("")||add.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Enter all fields", Toast.LENGTH_LONG).show();

                }else{
                    DBcon db= new DBcon(HirerReg.this);
                    HashMap<String,String> map=new HashMap<String, String>();
                    map.put("name", uname.getText().toString());
                    map.put("email", email.getText().toString());
                    map.put("pwd", pass.getText().toString());
                    map.put("phn", phone.getText().toString());
                    map.put("add", add.getText().toString());
                    db.insert_hirer(map);
                    Intent i=new Intent(getApplicationContext(),HirerLogin.class);
                    Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_LONG).show();
                    startActivity(i);

                }




            }
        });
    }
}
