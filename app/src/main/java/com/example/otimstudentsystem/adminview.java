package com.example.otimstudentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class adminview extends AppCompatActivity {

//    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminview);

//        sp = getSharedPreferences("MyLoginUserSharePref", Context.MODE_PRIVATE);

//        String TheFetchedLoggedUser = sp.getString("loggedUser", "defaultValue");
//        String LoggedUserName = sp.getString("LoginUserName", "defaultValue");

//        Toast.makeText(AdminDashboard.this, "AdminD Saved User Info:" + TheFetchedLoggedUser, Toast.LENGTH_SHORT).show();
//        Toast.makeText(AdminDashboard.this, "AdminD And the UserName is:" + LoggedUserName, Toast.LENGTH_SHORT).show();


        Button mgUser = findViewById(R.id.manageUserBtn);
        Button mgStdtRes = findViewById(R.id.manageResultBtn);
        Button vUser = findViewById(R.id.manageViewUserBtn);
        Button vStdRes = findViewById(R.id.manageViewResultBtn);
        Button button12 = findViewById(R.id.button12);

        mgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminReg = new Intent(adminview.this,registeruser.class);
                startActivity(adminReg);
            }
        });
        mgStdtRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminStdt = new Intent(adminview.this,result.class);
                startActivity(adminStdt);
            }
        });

        vStdRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminRes = new Intent(adminview.this,resultsview.class);
                startActivity(adminRes);
            }
        });

        vUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminVUser = new Intent(adminview.this,viewusers.class);
                startActivity(adminVUser);
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminview.this,firstscreen.class);
                startActivity(intent);
            }
        });

    }
}