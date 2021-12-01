package com.example.otimstudentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String[] items = {"HOD","Student","Lecturer"};

    AutoCompleteTextView autoCompleteTxt;

    ArrayAdapter<String> adapterItems;

    SharedPreferences sp;
    String loginAs;
    Cursor cursor;
    EditText LName;
    EditText Lpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTxt = findViewById(R.id.auto_complete_txt);

        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, items);

        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loginAs = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Logging in as: " + loginAs, Toast.LENGTH_LONG).show();
            }
        });

//        Shared preference
        sp = getSharedPreferences("MyLoginUserSharePref", Context.MODE_PRIVATE);

//        Login Logic
        Button loginbutton = findViewById(R.id.loginbtn);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LName = findViewById(R.id.LoginName);

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("loggedUser", loginAs);
                editor.putString("LoginUserName", LName.getText().toString());

                editor.commit();

                String TheFetchedLoggedUser = sp.getString("loggedUser", "defaultValue");

                Toast.makeText(MainActivity.this, "Shared Pref Info Saved :" + TheFetchedLoggedUser, Toast.LENGTH_SHORT).show();

                // Login function starts from here.

                if (TheFetchedLoggedUser.equals("Student")) {

                    // Opening SQLite database write permission.
                    registeruser.UserDetailsDbHelper dbHelper = new registeruser.UserDetailsDbHelper(getApplicationContext());

                    //Fetching my data from my database

                    SQLiteDatabase dbbb = dbHelper.getWritableDatabase();

                    // Adding search email query to cursor.
//                        cursor = dbbb.query(SQLiteOpenHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);

                    String selection = "name = ? and password = ?";

                    LName = findViewById(R.id.LoginName);
                    Lpass = findViewById(R.id.LoginPass);

                    String[] selectionArgs = {LName.getText().toString(), Lpass.getText().toString()};

                    String[] columns = {"name", "password"};
                    cursor = dbbb.query("users", columns, selection, selectionArgs, null, null, null);
                    int count = cursor.getCount();

                    cursor.close();


                    if (count > 0) {
                        Toast.makeText(MainActivity.this, "Logged in as Student: "+LName.getText().toString(), Toast.LENGTH_SHORT).show();

                        Intent loginIntent = new Intent(MainActivity.this,StudentView.class);
                        startActivity(loginIntent);

                    } else {
                        Toast.makeText(MainActivity.this, "Wrong Password for user :", Toast.LENGTH_SHORT).show();

                    }

//                Intent loginIntent = new Intent(MainActivity.this,RegisterUser.class);
//                startActivity(loginIntent);
                }

                else if(TheFetchedLoggedUser.equals("HOD")){

                    LName = findViewById(R.id.LoginName);
                    Lpass = findViewById(R.id.LoginPass);

                    if (LName.getText().toString().trim().length() <= 0 || Lpass.getText().toString().length() <= 0){
                        Toast.makeText(MainActivity.this, "Username or password must not be empty",
                                Toast.LENGTH_LONG).show();
                    }
                    else if(LName.getText().toString().equals("admin") && Lpass.getText().toString().equals("admin")){

                        Toast.makeText(MainActivity.this, "Logged in as Admin: "+TheFetchedLoggedUser, Toast.LENGTH_SHORT).show();
                        //explicit intent
                        Intent loginintentL = new Intent(MainActivity.this, adminview.class);

                        startActivity(loginintentL);

                    }
                    else{
                        Toast.makeText(MainActivity.this, "Wrong Credentials for Admin: "+TheFetchedLoggedUser, Toast.LENGTH_SHORT).show();

                    }

                }

                else if(TheFetchedLoggedUser.equals("Lecturer")){

                    // Opening SQLite database write permission.
                    registeruser.UserDetailsDbHelper dbHelper = new registeruser.UserDetailsDbHelper(getApplicationContext());

                    //Fetching my data from my database

                    SQLiteDatabase dbbb = dbHelper.getWritableDatabase();

                    // Adding search email query to cursor.
//                        cursor = dbbb.query(SQLiteOpenHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);

                    String selection = "name = ? and password = ?";

                    LName = findViewById(R.id.LoginName);
                    Lpass = findViewById(R.id.LoginPass);

                    String[] selectionArgs = {LName.getText().toString(), Lpass.getText().toString()};

                    String[] columns = {"name", "password","user"};
                    cursor = dbbb.query("users", columns, selection, selectionArgs, null, null, null);
                    int count = cursor.getCount();

                    cursor.close();


                    if (count > 0) {
                        Toast.makeText(MainActivity.this, "Logged in as Lecturer: "+LName.getText().toString(), Toast.LENGTH_SHORT).show();

                        Intent loginIntentLec = new Intent(MainActivity.this,LecturerDashboard.class);
                        startActivity(loginIntentLec);

                    } else {
                        Toast.makeText(MainActivity.this, "Wrong Password for lecturer", Toast.LENGTH_SHORT).show();

                    }

                }
                else {
                    Toast.makeText(MainActivity.this, "Chosen Else :", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}