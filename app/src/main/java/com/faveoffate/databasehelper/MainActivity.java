package com.faveoffate.databasehelper;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

        db = (new DataBaseHelper(this)).getReadableDatabase();
        searchText = (EditText) findViewById (R.id.searchText);
        employeeList = (ListView) findViewById (R.id.list);
    }

    public void search(View view) {
        // || is the concatenation operation in SQLite
        cursor = db.rawQuery("SELECT _id, fname, lname FROM Contacts WHERE fname || ' ' || lname LIKE ?",
                new String[]{"%" + searchText.getText().toString() + "%"});
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.employee_list_item,
                cursor,
                new String[] {"fname", "lname"},
                new int[] {R.id.firstName, R.id.lastName, R.id.title});
        employeeList.setAdapter(adapter);
    }

}


