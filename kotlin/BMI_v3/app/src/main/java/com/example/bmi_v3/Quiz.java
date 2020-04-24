package com.example.bmi_v3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

public class Quiz extends AppCompatActivity {
    Button answear1, answear2, answear3, answear4;

    TextView score, question;

    private Questions mQuestions = new Questions();

    private String mAnswear;

    private int mScore = 0;
    private int mQuestionsLenght = mQuestions.mQuestions.length;

    Random r;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.quiz);

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
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bmr:
                        startActivity(new Intent(getApplicationContext(), Bmr.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.recipes:
                        startActivity(new Intent(getApplicationContext(), Recipes.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.quiz:
                        return true;

                }
                return false;
            }
        });

        r = new Random();
        answear1=findViewById(R.id.answear1);
        answear2=findViewById(R.id.answear2);
        answear3=findViewById(R.id.answear3);
        answear4=findViewById(R.id.answear4);

        score = findViewById(R.id.score);
        question = findViewById(R.id.question);

        score.setText("Score: " + mScore);

        updateQuestion(r.nextInt(mQuestionsLenght));

        answear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answear1.getText() == mAnswear){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));
                }
                else {
                    gameOver();
                }
            }}
        );
        answear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answear2.getText() == mAnswear){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));
                }
                else {
                    gameOver();
                }
            }}
        );
        answear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answear3.getText() == mAnswear){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));
                }
                else {
                    gameOver();
                }
            }}
        );
        answear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answear4.getText() == mAnswear){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));
                }
                else {
                    gameOver();
                }
            }}
        );


    }


    private void updateQuestion(int num) {
        question.setText(mQuestions.getQuestion(num));
        answear1.setText(mQuestions.getChoice1(num));
        answear2.setText(mQuestions.getChoice2(num));
        answear3.setText(mQuestions.getChoice3(num));
        answear4.setText(mQuestions.getChoice4(num));

        mAnswear = mQuestions.getCorrectAnswear(num);
    }
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Quiz.this);
        alertDialogBuilder.setMessage("Game Over. Your score is " + mScore + "points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface DialogInterface, int i) {
                        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        startActivity(new Intent(getApplicationContext(), Quiz.class));
                        finish();

                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface DialogInterface, int i) {
                        finish();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
