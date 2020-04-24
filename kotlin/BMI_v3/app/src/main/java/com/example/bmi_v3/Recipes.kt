package com.example.bmi_v3

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_recipes.*

class Recipes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)

        send_button.setOnClickListener{ provideRecipes() }
        //initialize and assign variable
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        //set Home Selected
        bottomNavigationView.selectedItemId = R.id.recipes
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
                R.id.bmr -> {
                    startActivity(Intent(applicationContext, Bmr::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.recipes -> return@OnNavigationItemSelectedListener true
                R.id.quiz -> {
                    startActivity(Intent(applicationContext, Quiz::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }

    private fun provideRecipes() {
        val s1 = bmi.text.toString()
        val calculation: String

        if (TextUtils.isEmpty(s1)) {
            bmi.error = "Please provide your int Bmi value"
            return
        }
        val bmiValue = s1.toFloat()
        val proposedDish: String

        proposedDish = when (bmiValue.toInt()){
            in 0..19 -> "Small Kebab"
            in 19..25 -> "Normal Kebab"
            in 25..30 -> "Big Kebab"
            else -> "KingSize kebab, twice"
        }
        calculation = "Proposed dish: \n\n$proposedDish\n"
        recipe.text=calculation    }
}