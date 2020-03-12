package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity {
    EditText weight, height;
    TextView resulttext;
    String calculation, BMIresult;
    Button calculate_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resulttext = findViewById(R.id.result);
        calculate_button = findViewById(R.id.calculate_button);

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    public void calculateBMI() {
        String S1 = weight.getText().toString();
        String S2 = height.getText().toString();

        float weightValue = Float.parseFloat(S1);
        float heightValue = Float.parseFloat(S2);

        float bmi = weightValue / (heightValue/100 * heightValue/100);

        if (bmi < 18.5){
            BMIresult = "Under Weight";
        }
        else if (bmi >= 18.5 && bmi <= 24.9) {
            BMIresult = "Your Weight is fine";
        }
        else if (bmi >=25 && bmi <=29.9){
            BMIresult = "Over Weight";
        }
        else {
            BMIresult = "U are really FAT";
        }

        calculation = "Result: \n\n" + bmi + "\n" + BMIresult;
        resulttext.setText(calculation);
    }

}
