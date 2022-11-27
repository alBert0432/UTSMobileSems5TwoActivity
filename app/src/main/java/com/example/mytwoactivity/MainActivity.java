package com.example.mytwoactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputFullName;
    Spinner inputAge;
    RadioGroup inputGender;
    RadioButton chooseGender;
    AutoCompleteTextView inputUniversity;
    CheckBox inputTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFullName = findViewById(R.id.inputFullName);
        inputAge = findViewById(R.id.inputAge);
        inputGender = findViewById(R.id.inputGender);
        inputUniversity = findViewById(R.id.inputUniversity);
        inputTerms = findViewById(R.id.inputTerms);

        String [] UniversityName = {"Kemanggisan", "Syahdan", "Kijang", "Alam Sutra", "Bandung"};
        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, UniversityName);
        inputUniversity.setAdapter(arrayAdapter);

        String [] AgeSpinner = {"17", "18", "19", "20", "21", "22", "23", "24"};
        ArrayAdapter <String> arrayAdapter1 = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, AgeSpinner);
        inputAge.setAdapter(arrayAdapter1);

        Toast.makeText(this, "fungsi onCreate", Toast.LENGTH_SHORT).show();
    }

    public void send(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation").setMessage("Are you sure want to fill this ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String fullname = inputFullName.getText().toString();
                chooseGender = findViewById(inputGender.getCheckedRadioButtonId()) ;
                String gender = chooseGender.getText().toString();
                String univ = inputUniversity.getText().toString();
                String age = inputAge.getSelectedItem().toString();
                String terms = inputTerms.isChecked() ? "Agree" : "Disagree";

                Intent openActivity = new Intent(MainActivity.this, MainActivity2nd.class);
                openActivity.putExtra("name", fullname);
                openActivity.putExtra("gender", gender);
                openActivity.putExtra("university", univ);
                openActivity.putExtra("age", age);
                openActivity.putExtra("terms", terms);
                startActivity(openActivity);

                Toast.makeText(MainActivity.this, "Data Confirm", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}