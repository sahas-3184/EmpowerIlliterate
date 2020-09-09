package com.example.hp.empowerilliterate;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HirerSearch1 extends ListActivity {
    ArrayList<String> result=new ArrayList<String>();
    private SQLiteDatabase newDB;
    String content,phone;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openAndQueryDatabase();
        displayResultList();

    }

    private void displayResultList() {
        TextView tView=new TextView(this);
        tView.setText("Search");
        getListView().addHeaderView(tView);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, result));
        final ListView lv=getListView();
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent (HirerSearch1.this,HirerSearch2.class);
                String email= (String)(lv.getItemAtPosition(position));
                intent.putExtra("email",email);
                intent.putExtra("content",content);
                intent.putExtra("phone",phone);
                i++;
                startActivity(intent);



            }
        });


    }

    private void openAndQueryDatabase() {
        content=getIntent().getStringExtra("content");
        phone=getIntent().getStringExtra("phone");
        DBcon dbHelper= new DBcon(this.getApplicationContext());
        newDB =dbHelper.getWritableDatabase();
        Cursor c=newDB.rawQuery("select *from hiree where work='" + content + "'", null);
        if (c != null) {

            if (c.moveToFirst()) {

                do {

                    String email = c.getString(c.getColumnIndex("email"));
                    result.add(email);

                } while (c.moveToNext());

            }



        }

    }
}
