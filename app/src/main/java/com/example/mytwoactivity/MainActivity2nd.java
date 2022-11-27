package com.example.mytwoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2nd extends AppCompatActivity{
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2nd);

        TextView output = findViewById(R.id.textView);
        Intent getIntent = getIntent();

        String name = getIntent.getStringExtra("name");
        String gender = getIntent.getStringExtra("gender");
        String university = getIntent.getStringExtra("university");
        String age = getIntent.getStringExtra("age");
        String terms = getIntent.getStringExtra("terms");

        output.setText(
                "FullName :" + name + "\n" +
                        "Gender :" + gender + "\n" +
                        "University :" + university + "\n" +
                        "Age :" + age + "\n" +
                        "Terms :" + terms + "\n"
        );
    }
}