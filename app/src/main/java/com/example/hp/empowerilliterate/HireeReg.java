package com.example.hp.empowerilliterate;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HireeReg extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText name,email,pass,phone,addr,yob,yow;
    Spinner occ;
    Button sub;
    SQLiteDatabase sb;
    String hocc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiree_reg);
        final Activity activity=this;
        this.setTitle("Hiree Registration");
        name= (EditText) findViewById(R.id.name);
        email= (EditText) findViewById(R.id.email);
        pass= (EditText) findViewById(R.id.pass);
        phone= (EditText) findViewById(R.id.phone);
        addr= (EditText) findViewById(R.id.addr);
        yob= (EditText) findViewById(R.id.yob);
        yow= (EditText) findViewById(R.id.yow);
        occ= (Spinner) findViewById(R.id.occ);
        sub= (Button) findViewById(R.id.sub);

        occ.setOnItemSelectedListener(this);
        List<String> rname = new ArrayList<String>();
        rname.add("agriculture ");
        rname.add("blacksmith");
        rname.add("carpenter");
        rname.add("chef");
        rname.add("construction");
        rname.add("laundry");
        rname.add("mason");
        rname.add("mechanic");
        rname.add("plumber");
        rname.add("salesperson");
        rname.add("watchman");
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,rname);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        occ.setAdapter(adp);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")||email.getText().toString().equals("")||pass.getText().toString().equals("")||phone.getText().toString().equals("")||addr.getText().toString().equals("")||yob.getText().toString().equals("")||yow.getText().toString().equals(""))
                {
                    Toast.makeText(HireeReg.this,"Enter All Fields",Toast.LENGTH_LONG).show();

                }else
                {
                    DBcon db= new DBcon(HireeReg.this);
                    HashMap<String,String> map=new HashMap<String, String>();
                    map.put("name", name.getText().toString());
                    map.put("email", email.getText().toString());
                    map.put("pass", pass.getText().toString());
                    map.put("phn", phone.getText().toString());
                    map.put("addr", addr.getText().toString());
                    map.put("doy", yob.getText().toString());
                    map.put("yow", yow.getText().toString());
                    map.put("work", hocc);
                    db.insert_hiree(map);
                    Intent i=new Intent(getApplicationContext(),HireeLogin.class);
                    Toast.makeText(getApplicationContext(),"name:"+name.getText().toString()+"\nemail:"+email.getText().toString()+"pass:"+pass.getText().toString()+"\nphone"+phone.getText().toString()+"\naddr:"+addr.getText().toString()+"\nyob:"+ yob.getText().toString()+"\nyow:"+yow.getText().toString()+"\nocc:"+hocc,Toast.LENGTH_LONG).show();
                    startActivity(i);
                }
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        hocc=parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}