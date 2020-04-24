package com.example.bmi_v3

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bmr.*

class Bmr : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmr)

        calculate_button.setOnClickListener{ calculateBMR() }

        //initialize and assign variable
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        //set Home Selected
        bottomNavigationView.selectedItemId = R.id.bmr
        //perform itemselectedlistener
        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bmi -> {
                    startActivity(Intent(applicationContext, Bmi::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.home -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.bmr -> return@OnNavigationItemSelectedListener true
                R.id.recipes -> {
                    startActivity(Intent(applicationContext, Recipes::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.quiz -> {
                    startActivity(Intent(applicationContext, Quiz::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }

    private fun calculateBMR() {
        val s1 = weight.text.toString()
        val s2 = height.text.toString()
        val s3 = age.text.toString()
        val calculation: String
        //val radioButton


        val weightValue = s1.toFloat()
        val heightValue = s2.toFloat()
        val ageValue = s3.toFloat()

        //radio buttons
        val radioId = radioGroup.checkedRadioButtonId
        val radioButton = findViewById<RadioButton>(radioId)
        val bmr: Double
        bmr = if (radioButton.text.toString() == "male") 66.5 + 13.75 * weightValue + 5.003 *
                heightValue - 6.775 * ageValue else 655.1 + 9.563 * weightValue + 1.85 *
                heightValue - 4.676 * ageValue

        calculation = "Your BMR result (equated by Harris–Benedict principle) is: \n" +
                String.format("%.2f", bmr) + " calories"
        result.text = calculation
    }
}