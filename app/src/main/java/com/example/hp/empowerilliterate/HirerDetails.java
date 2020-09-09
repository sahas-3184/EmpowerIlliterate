package com.example.hp.empowerilliterate;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HirerDetails extends ListActivity {
    ArrayList<String> result = new ArrayList<String>();
    private SQLiteDatabase newDB;
    String name , email,cnt, addr,content;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openAndQueryDatabase();
        displayResultList();
    }

    private void openAndQueryDatabase() {
        DBcon dbHelper = new DBcon(this.getApplicationContext());
        newDB= dbHelper.getWritableDatabase();
        Cursor c= newDB.rawQuery("select *from hirer",null);
                if(c!=null)
                {
                    if(c.moveToFirst())
                    {
                        do
                        {
                            name=c.getString(c.getColumnIndex("name"));
                            email=c.getString(c.getColumnIndex("email"));
                            cnt=c.getString(c.getColumnIndex("phn"));
                            addr=c.getString(c.getColumnIndex("addr"));
                            content="Name:"+name+"\nEmail:"+email+"\nContact No:"+cnt+"\nAddress:"+addr;
                            result.add(content);
                        } while (c.moveToNext());
                    }


                }




    }

    private void displayResultList() {
        TextView tView = new TextView(this);
        tView.setText("Hirers Details");
        getListView().addHeaderView(tView);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,result));
        final ListView lv =getListView();
        lv.setTextFilterEnabled(true);


    }
}
