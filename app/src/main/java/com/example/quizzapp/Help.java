package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Help extends AppCompatActivity {

    public static final String helpAnwser="HELP_ANSWER";

    String help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        TextView textView=(TextView) findViewById(R.id.helping_txt_view);
        String help=getIntent().getStringExtra("help");

        textView.setText(help);
//        questionModelArrayList=(ArrayList<QuestionModel>) getIntent().getSerializableExtra(helpAnwser);
//
//        TextView textView=(TextView) findViewById(R.id.help);
//
//        textView.setText(questionModelArrayList.get(Questions).getAnswer());
    }
}