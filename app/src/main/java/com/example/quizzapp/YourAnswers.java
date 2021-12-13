package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class YourAnswers extends AppCompatActivity {

    public static final String ExtraData="EXTRA_DATA";

    public TextView question1,question2,question3,question4,question5,question6,question7,question8,question9,question10;
    public TextView answer1,answer2,answer3,answer4,answer5,answer6,answer7,answer8,answer9,answer10;
    EnglishLanguage englishLanguage;
    public ArrayList<QuestionModel> questionModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_answers);

//        question1=findViewById(R.id.question1);
//        answer1=findViewById(R.id.answer1);
//        question2=findViewById(R.id.question2);
//        answer2=findViewById(R.id.answer2);
//        question3=findViewById(R.id.question3);
//        answer3=findViewById(R.id.answer3);
//        question4=findViewById(R.id.question4);
//        answer4=findViewById(R.id.answer4);
//        question5=findViewById(R.id.question5);
//        answer5=findViewById(R.id.answer5);
//        question6=findViewById(R.id.question6);
//        answer6=findViewById(R.id.answer6);
//        question7=findViewById(R.id.question7);
//        answer7=findViewById(R.id.answer7);
//        question8=findViewById(R.id.question8);
//        answer8=findViewById(R.id.answer8);
//        question9=findViewById(R.id.question9);
//        answer9=findViewById(R.id.answer9);
//
//
//        questionModelArrayList=(ArrayList<QuestionModel>) getIntent().getSerializableExtra(ExtraData);
//
//        question1.setText(questionModelArrayList.get(0).getQuestion());
//        answer1.setText(questionModelArrayList.get(0).getAnswer());
//        question2.setText(questionModelArrayList.get(1).getQuestion());
//        answer2.setText(questionModelArrayList.get(1).getAnswer());
//        question3.setText(questionModelArrayList.get(2).getQuestion());
//        answer3.setText(questionModelArrayList.get(2).getAnswer());
//        question4.setText(questionModelArrayList.get(3).getQuestion());
//        answer4.setText(questionModelArrayList.get(3).getAnswer());
//        question5.setText(questionModelArrayList.get(4).getQuestion());
//        answer5.setText(questionModelArrayList.get(4).getAnswer());
//        question6.setText(questionModelArrayList.get(5).getQuestion());
//        answer6.setText(questionModelArrayList.get(5).getAnswer());
//        question7.setText(questionModelArrayList.get(6).getQuestion());
//        answer7.setText(questionModelArrayList.get(6).getAnswer());
//        question8.setText(questionModelArrayList.get(7).getQuestion());
//        answer8.setText(questionModelArrayList.get(7).getAnswer());
//        question9.setText(questionModelArrayList.get(8).getQuestion());
//        answer9.setText(questionModelArrayList.get(8).getAnswer());
//
////        questionModelArrayList=new ArrayList<>();
////        questionModelArrayList.get(englishLanguage.questionAttempted);
////        String questionsArray=questionModelArrayList.toString();
////
////        TextView questions=(TextView) findViewById(R.id.questions);
////        questions.setText(questionsArray);

//        Intent intent=getIntent();
//        String str=intent.getStringExtra("Scores");
//
//        TextView t=findViewById(R.id.answer1);
//        t.setText(str);

        questionModelArrayList=this.getIntent().getParcelableArrayListExtra("Pairs");
        ListView listView=findViewById(R.id.listView);
        QuestionAdapter questionAdapter=new QuestionAdapter(YourAnswers.this,questionModelArrayList);
        listView.setAdapter(questionAdapter);
    }
}