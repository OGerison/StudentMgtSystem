package com.example.otimstudentsystem;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class assistantview extends AppCompatActivity {


//    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistantview);

//        sp = getSharedPreferences("MyLoginUserSharePref", Context.MODE_PRIVATE);

//        String TheFetchedLoggedUser = sp.getString("loggedUser", "defaultValue");
//        String LoggedUserName = sp.getString("LoginUserName", "defaultValue");

//        Toast.makeText(AdminDashboard.this, "AdminD Saved User Info:" + TheFetchedLoggedUser, Toast.LENGTH_SHORT).show();
//        Toast.makeText(AdminDashboard.this, "AdminD And the UserName is:" + LoggedUserName, Toast.LENGTH_SHORT).show();

        Button vUser2 = findViewById(R.id.manageViewUserBtn2);
        Button vStdRes2 = findViewById(R.id.manageViewResultBtn2);
        Button button12 = findViewById(R.id.button12);

        vStdRes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminRes = new Intent(assistantview.this,resultsview.class);
                startActivity(adminRes);
            }
        });

        vUser2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminVUser = new Intent(assistantview.this,viewusers.class);
                startActivity(adminVUser);
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(assistantview.this,firstscreen.class);
                startActivity(intent);
            }
        });

    }
}