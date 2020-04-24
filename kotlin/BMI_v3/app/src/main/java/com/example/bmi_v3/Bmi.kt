package com.example.bmi_v3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bmi.*

class Bmi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        calculate_button.setOnClickListener { calculateBMI() }

        //initialize and assign variable
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        //set Home Selected
        bottomNavigationView.selectedItemId = R.id.bmi
        //perform itemselectedlistener
        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bmi -> return@OnNavigationItemSelectedListener true
                R.id.home -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.bmr -> {
                    startActivity(Intent(applicationContext, Bmr::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
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

    private fun calculateBMI() {
        val s1 = weight.text.toString()
        val s2 = height.text.toString()
        val bmiResult:String
        val calculation:String

        val weightValue = s1.toFloat()
        val heightValue = s2.toFloat()

        val bmi = weightValue / (heightValue / 100 * heightValue / 100)

        when (bmi.toInt()){
            in 0..19 -> bmiResult = "Under Weight"
            in 19..25 -> bmiResult = "Your Weight is fine"
            in 25..30 -> bmiResult = "Over Weight"
            else -> bmiResult = "U are really FAT"}
            calculation = "Result: \n\n" + String.format("%.2f", bmi) + "\n" + bmiResult
            result.text = calculation
    }
}