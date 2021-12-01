package com.example.otimstudentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LecturerDashboard extends AppCompatActivity {

//    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_dashboard);

//        sp = getSharedPreferences("MyLoginUserSharePref", Context.MODE_PRIVATE);

//        String TheFetchedLoggedUser = sp.getString("loggedUser", "defaultValue");
//        String LoggedUserName = sp.getString("LoginUserName", "defaultValue");

//        Toast.makeText(AdminDashboard.this, "AdminD Saved User Info:" + TheFetchedLoggedUser, Toast.LENGTH_SHORT).show();
//        Toast.makeText(AdminDashboard.this, "AdminD And the UserName is:" + LoggedUserName, Toast.LENGTH_SHORT).show();

        Button button15 = findViewById(R.id.button15);
        Button button16 = findViewById(R.id.button16);
        Button button17 = findViewById(R.id.button17);

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminStdt = new Intent(LecturerDashboard.this,result.class);
                startActivity(adminStdt);
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminStdt = new Intent(LecturerDashboard.this,resultsview.class);
                startActivity(adminStdt);
            }
        });

        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminRes = new Intent(LecturerDashboard.this,firstscreen.class);
                startActivity(adminRes);
            }
        });
    }
}