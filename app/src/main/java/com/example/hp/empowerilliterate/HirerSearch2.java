package com.example.hp.empowerilliterate;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class HirerSearch2 extends AppCompatActivity {
    TextView hename, email, phn, addr, yob, exp, work;
    String a, b, c, d, e, f, g, em, p, hremail;
    private SQLiteDatabase newDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hirer_search2);
        final Activity activity = this;
        this.setTitle("Hirer Details");
        hename = (TextView) findViewById(R.id.hename);
        email = (TextView) findViewById(R.id.email);
        phn = (TextView) findViewById(R.id.phone);
        addr = (TextView) findViewById(R.id.addr);
        yob = (TextView) findViewById(R.id.yob);
        exp = (TextView) findViewById(R.id.exp);
        work = (TextView) findViewById(R.id.work);


        openAndQueryDatabase();
        showDetails();
    }

    private void showDetails() {

        hename.setText(a);
        email.setText(b);
        phn.setText(c);
        addr.setText(d);
        yob.setText(e);
        exp.setText(f);
        work.setText(g);


    }

    private void openAndQueryDatabase() {
        em = getIntent().getStringExtra("email");
        DBcon dbHelper = new DBcon(getApplicationContext());
        newDb = dbHelper.getWritableDatabase();
        Cursor cc = newDb.rawQuery("select *from hiree where email='" + em + "'", null);
        if (cc != null) {
            if (cc.moveToNext()) {
                do {

                    a = cc.getString(cc.getColumnIndex("name"));
                    b = cc.getString(cc.getColumnIndex("email"));
                    c = cc.getString(cc.getColumnIndex("phn"));
                    d = cc.getString(cc.getColumnIndex("addr"));
                    e = cc.getString(cc.getColumnIndex("doy"));
                    f = cc.getString(cc.getColumnIndex("yow"));
                    g = cc.getString(cc.getColumnIndex("work"));


                } while (cc.moveToNext());
            }
        }
        p = getIntent().getStringExtra("phone");
        Cursor c1 = newDb.rawQuery("select *from hirer where phn='" + p + "'", null);
        if (c1 != null) {

            if (c1.moveToFirst()) {

                do {
                    hremail = c1.getString(c1.getColumnIndex("name"));

                } while (c1.moveToNext());

            }


        }
        DBcon db = new DBcon(HirerSearch2.this);
        HashMap<String, String> map = new HashMap<String, String>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = new Date();
        map.put("hr", hremail);
        map.put("he", a);
        map.put("date", df.format(dt));
        map.put("phn", c);
        db.insert_search(map);
        Toast.makeText(HirerSearch2.this, "Hirer:" + hremail.toString() + "\nHiree:" + a.toString() + "Date:" + df.format(dt).toString() + "phone:" + c.toString() , Toast.LENGTH_LONG).show();
    }

}