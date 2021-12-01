package com.example.otimstudentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class Studentcourseunits extends AppCompatActivity {


    String[] courseUnitItems = {"Calculus","Data Structures","WorldViews","Health and Wholeness","Cyber Security","Artificial Intelligence"};

    AutoCompleteTextView autoCompleteTxtCourse1;

    ArrayAdapter<String> adapterCourseItems;

    EditText studReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentcourseunits);

        studReg = findViewById(R.id.StudRegNo);

        SharedPreferences sp = getSharedPreferences("MyLoginUserSharePref", Context.MODE_PRIVATE);
        String TheFetchedLoggedUser = sp.getString("loggedUser", "defaultValue");

        Toast.makeText(getApplicationContext(), "New Toast Login : " + TheFetchedLoggedUser, Toast.LENGTH_LONG).show();


//        Course Unit 1
        autoCompleteTxtCourse1 = findViewById(R.id.auto_complete_txt_course1);

        adapterCourseItems = new ArrayAdapter<String>(this, R.layout.list_item, courseUnitItems);

        autoCompleteTxtCourse1.setAdapter(adapterCourseItems);

        autoCompleteTxtCourse1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Course1 = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Course 1 : " + Course1, Toast.LENGTH_LONG).show();
            }
        });
//        Course Unit 2
        AutoCompleteTextView autoCompleteTxtCourse2 = findViewById(R.id.auto_complete_txt_course2);

        adapterCourseItems = new ArrayAdapter<String>(this, R.layout.list_item, courseUnitItems);

        autoCompleteTxtCourse2.setAdapter(adapterCourseItems);

        autoCompleteTxtCourse2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Course2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Course 2 : " + Course2, Toast.LENGTH_LONG).show();
            }
        });
//        course unit 3
        AutoCompleteTextView autoCompleteTxtCourse3 = findViewById(R.id.auto_complete_txt_course3);

        adapterCourseItems = new ArrayAdapter<String>(this, R.layout.list_item, courseUnitItems);

        autoCompleteTxtCourse3.setAdapter(adapterCourseItems);

        autoCompleteTxtCourse2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Course3 = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Course 3 : " + Course3, Toast.LENGTH_LONG).show();
            }
        });
//        course unit 4
        AutoCompleteTextView autoCompleteTxtCourse4 = findViewById(R.id.auto_complete_txt_course4);

        adapterCourseItems = new ArrayAdapter<String>(this, R.layout.list_item, courseUnitItems);

        autoCompleteTxtCourse4.setAdapter(adapterCourseItems);

        autoCompleteTxtCourse4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Course4 = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Course 4 : " + Course4, Toast.LENGTH_LONG).show();
            }
        });
//        course unit 5
        AutoCompleteTextView autoCompleteTxtCourse5 = findViewById(R.id.auto_complete_txt_course5);

        adapterCourseItems = new ArrayAdapter<String>(this, R.layout.list_item, courseUnitItems);

        autoCompleteTxtCourse5.setAdapter(adapterCourseItems);

        autoCompleteTxtCourse5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Course5 = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Course 5 : " + Course5, Toast.LENGTH_LONG).show();
            }
        });
//        course unit 6
        AutoCompleteTextView autoCompleteTxtCourse6 = findViewById(R.id.auto_complete_txt_course6);

        adapterCourseItems = new ArrayAdapter<String>(this, R.layout.list_item, courseUnitItems);

        autoCompleteTxtCourse6.setAdapter(adapterCourseItems);

        autoCompleteTxtCourse6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Course6 = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Course 6 : " + Course6, Toast.LENGTH_LONG).show();
            }
        });
    }
}