package com.example.bmi_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Recipes extends AppCompatActivity {

    EditText bmi;
    TextView resulttext;
    String calculation;
    Button send_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        bmi = findViewById(R.id.bmi);
        resulttext = findViewById(R.id.recipe);
        send_button = findViewById(R.id.send_button);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provideRecipes();
            }
        });


        //initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.recipes);

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
                        startActivity(new Intent(getApplicationContext(), Bmr.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.recipes:
                        return true;
                }
                return false;
            }
        });
    }
    public void provideRecipes() {
        String S1 = bmi.getText().toString();

        if(TextUtils.isEmpty(S1)) {
            bmi.setError("Please provide your int Bmi value");
            return;
        }

        float bmiValue = Float.parseFloat(S1);
        String proposedDish;
        if (bmiValue < 18.5){
            proposedDish = "Small Kebab";
        }
        else if (bmiValue >= 18.5 && bmiValue <= 24.9) {
            proposedDish = "Normal Kebab";
        }
        else if (bmiValue >=25 && bmiValue <=29.9){
            proposedDish = "Big Kebab";
        }
        else {
            proposedDish = "KingSize kebab, twice";
        }

        calculation = "Proposed dish: \n\n" + proposedDish + "\n";
        resulttext.setText(calculation);
    }
}
