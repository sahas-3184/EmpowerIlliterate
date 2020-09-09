package com.example.hp.empowerilliterate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    Button reset,signin;
    EditText name,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        reset= (Button) findViewById(R.id.reset);
        name= (EditText) findViewById(R.id.name);
        pass= (EditText) findViewById(R.id.pass);
        signin= (Button) findViewById(R.id.signin);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                pass.setText("");

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().equals("admin")&&pass.getText().toString().equals("admin"))
                {
                    Intent intent=new Intent(AdminLogin.this,AdminHome.class);
                    Toast.makeText(AdminLogin.this,"Welcome!",Toast.LENGTH_LONG).show();
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(AdminLogin.this,"Incorrect Details",Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
