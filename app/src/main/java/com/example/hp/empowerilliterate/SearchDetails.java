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

public class SearchDetails extends ListActivity {
    ArrayList<String> result= new ArrayList<String>();
    private SQLiteDatabase newDB;
    int i=0;
    String hirer=null,hiree=null,date=null,content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openAndQueryDatabase();
        displayResultList();
    }

    private void displayResultList() {

        TextView tView = new TextView(this);
        tView.setText("Search Details");
        getListView().addHeaderView(tView);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,result));
        final ListView lv =getListView();
        lv.setTextFilterEnabled(true);

    }

    private void openAndQueryDatabase() {
        DBcon dbHelper = new DBcon(this.getApplicationContext());
        newDB= dbHelper.getWritableDatabase();
        Cursor c=newDB.rawQuery("select *from search ",null);
        if(c!=null)
        {
            if(c.moveToFirst())
            {
                do {

                    hirer = c.getString(c.getColumnIndex("hr"));
                    hiree = c.getString(c.getColumnIndex("he"));
                    date = c.getString(c.getColumnIndex("date"));
                    content = "Hirer:"+hirer+"\nHiree:"+hiree+"\nDate:"+date;
                    result.add(content);
                }while(c.moveToNext());
            }
        }



    }

}
