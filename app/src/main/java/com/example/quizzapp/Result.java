package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    RatingBar ratingBar;
    private TextView questionNumber;
    ArrayList<QuestionModel> questionModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        ratingBar = findViewById(R.id.rating_bar);

        questionModelArrayList = this.getIntent().getParcelableArrayListExtra("Pairs");
        ListView listView = findViewById(R.id.listView);
        QuestionAdapter questionAdapter = new QuestionAdapter(Result.this, questionModelArrayList);
        listView.setAdapter(questionAdapter);
//        listView.setVisibility(View.INVISIBLE);

        questionNumber = findViewById(R.id.idTVQuestionAttempted);
        String scores = getIntent().getStringExtra("Scores");
        questionNumber.setText(scores);


        switch (scores) {
            case "1":
                ratingBar.setRating((float) 0.5);
                break;
            case "2":
                ratingBar.setRating((float) 1.0);
                break;
            case "3":
                ratingBar.setRating((float) 1.5);
                break;
            case "4":
                ratingBar.setRating((float) 2.0);
                break;
            case "5":
                ratingBar.setRating((float) 2.5);
                break;
            case "6":
                ratingBar.setRating((float) 3.0);
                break;
            case "7":
                ratingBar.setRating((float) 3.5);
                break;
            case "8":
                ratingBar.setRating((float) 4.0);
                break;
            case "9":
                ratingBar.setRating((float) 4.5);
                break;
            case "10":
                ratingBar.setRating((float) 5.0);
                break;
        }

        TextView rightAnswers = (TextView) findViewById(R.id.your_answers);
        rightAnswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this, YourAnswers.class);
                intent.putParcelableArrayListExtra("Pairs", questionModelArrayList);
                startActivity(intent);
            }
        });

        TextView help = (TextView) findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(Result.this,Help.class);
//                startActivity(intent);
            }
        });


        ImageView retryQuizz = (ImageView) findViewById(R.id.reTryingQuizz);
        retryQuizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Result.this, YourAnswers.class);
//                intent.putExtra("Scores",scores);
//                startActivity(intent);
//                finish();
//
                Intent intent = new Intent(Result.this, Subjects.class);
                startActivity(intent);
                finish();
            }
        });
        ImageView appHomeScreen = (ImageView) findViewById(R.id.homeScreen);
        appHomeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}