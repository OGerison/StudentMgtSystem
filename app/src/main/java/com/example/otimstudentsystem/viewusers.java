package com.example.otimstudentsystem;


import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

public class viewusers extends AppCompatActivity {
    private TableLayout tableLayout;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewusers);

        tableLayout = findViewById(R.id.tableLayoutUsers);

        registeruser.UserDetailsDbHelper dbHelper = new registeruser.UserDetailsDbHelper(getApplicationContext());

        //Fetching my data from my database

        SQLiteDatabase dbbb = dbHelper.getReadableDatabase();

        cursor = dbbb.query(
                registeruser.UserDetailsContract.UserEntry.TABLE_NAME,   // The table to query
                null,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The s+ort order
        );

        while (cursor.moveToNext()) {
            View tableRow = LayoutInflater.from(this).inflate(R.layout.useritemtable, null, false);

            TextView tttuser = (TextView) tableRow.findViewById(R.id.tuuser);
            TextView tttregno = (TextView) tableRow.findViewById(R.id.turegno);
            TextView tttname = (TextView) tableRow.findViewById(R.id.tuname);
            TextView tttemail = (TextView) tableRow.findViewById(R.id.tuemail);
            TextView tttcourseunit = (TextView) tableRow.findViewById(R.id.tucourseunit);


            tttuser.setText(cursor.getString(1));
            tttregno.setText(cursor.getString(2));
            tttname.setText(cursor.getString(3));
            tttemail.setText(cursor.getString(4));
            tttcourseunit.setText(cursor.getString(6));
            tableLayout.addView(tableRow);

        }
        cursor.close();
    }
}