package com.faveoffate.databasehelper;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    protected EditText searchText;
    protected SQLiteDatabase db;
    protected Cursor cursor;
    protected ListAdapter adapter;
    protected ListView employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseHelper myDbHelper;
        myDbHelper = new DataBaseHelper(this);

        try {

            myDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            myDbHelper.openDataBase();

        }catch(SQLException sqle){

            throw sqle;

        }

        db = (new DataBaseHelper(this)).getReadableDatabase();
        searchText = (EditText) findViewById (R.id.searchText);
        employeeList = (ListView) findViewById (R.id.list);

        Button button =(Button)findViewById(R.id.viewDBButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent dbmanager = new Intent(MainActivity.this,AndroidDatabaseManager.class);
                startActivity(dbmanager);
            }
        });

    }

    public void search(View view) {
        // || is the concatenation operation in SQLite
        cursor = db.rawQuery("SELECT _id, barcode, product FROM Contacts WHERE barcode || ' ' || product LIKE ?",
                new String[]{"%" + searchText.getText().toString() + "%"});
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.employee_list_item,
                cursor,
                new String[] {"barcode", "product"},
                new int[] {R.id.barcode, R.id.product});
        employeeList.setAdapter(adapter);
    }

}


