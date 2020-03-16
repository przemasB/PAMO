package com.example.bmi_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bmr extends AppCompatActivity {
    EditText weight, height, age;
    TextView resulttext;
    String calculation;
    Button calculate_button;
    //radio buttons
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);



        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);
        resulttext = findViewById(R.id.result);
        calculate_button = findViewById(R.id.calculate_button);

        radioGroup = findViewById(R.id.radioGroup);

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMR();
            }
        });


        //initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.bmr);

        //perform itemselectedlistener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.bmi:
                        startActivity(new Intent(getApplicationContext(), Bmi.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bmr:

                        return true;
                    case R.id.recipes:
                        startActivity(new Intent(getApplicationContext(), Recipes.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }




    public void calculateBMR() {
        String S1 = weight.getText().toString();
        String S2 = height.getText().toString();
        String S3 = age.getText().toString();


        float weightValue = Float.parseFloat(S1);
        float heightValue = Float.parseFloat(S2);
        float ageValue = Float.parseFloat(S3);

        //radio buttons
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        double bmr;
        if (radioButton.getText().toString().equals("male"))
            bmr = 66.5 + 13.75 * weightValue + 5.003 * heightValue - 6.775 * ageValue;
        else
            bmr = 655.1 + 9.563 * weightValue + 1.85 * heightValue - 4.676 * ageValue;


        calculation = "Your BMR result (equated by Harris–Benedict principle) is: \n" + String.format("%.2f", bmr) + " calories";
        resulttext.setText(calculation);
    }

}

