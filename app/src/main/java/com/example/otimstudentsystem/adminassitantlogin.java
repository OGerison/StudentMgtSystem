package com.example.otimstudentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminassitantlogin extends AppCompatActivity {

    Button button11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminassitantlogin);

        button11 = findViewById(R.id.button11);
        EditText AName = findViewById(R.id.editTextTextPersonName13);
        EditText Apass = findViewById(R.id.editTextTextPassword3);

        button11.setOnClickListener(view -> {

            if (AName.getText().toString().trim().length() <= 0 || Apass.getText().toString().length() <= 0){
                Toast.makeText(adminassitantlogin.this, "No field can be left Empty.",
                        Toast.LENGTH_LONG).show();
            }
            else if(AName.getText().toString().equals("admin2") && Apass.getText().toString().equals("admin2")){
                Toast.makeText(adminassitantlogin.this, "Logged in as Admin Assistant.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), assistantview.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(adminassitantlogin.this, "Wrong Credentials for Admin Assistant. Try Again", Toast.LENGTH_SHORT).show();
            }

        });
    }
}