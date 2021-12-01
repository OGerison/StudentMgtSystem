package com.example.otimstudentsystem;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StudentView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);

        Button button13 = findViewById(R.id.button13);
        Button button14 = findViewById(R.id.button14);

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminRes = new Intent(StudentView.this,resultsview.class);
                startActivity(adminRes);
            }
        });

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminVUser = new Intent(StudentView.this,firstscreen.class);
                startActivity(adminVUser);
            }
        });
    }
}