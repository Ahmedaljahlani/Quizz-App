package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MachineLearning extends AppCompatActivity {

    int REQUEST_CODE_1;
    private TextView questionTV, questionNumber;
    private Button optionBtnTrue, optionBtnFalse;
    ArrayList<QuestionModel> questionModelArrayList;

    ArrayList<QuestionModel> passedQuestions;
    ArrayList<QuestionModel> previousQuestions;
    Random random;
    int currentScore = 0, questionAttempted = 0, current = 0, previous;

    private ImageView backward, forward, help;
    int chance = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_learning);


        questionTV = findViewById(R.id.idTVQuestions);
        questionNumber = findViewById(R.id.idTVQuestionAttempted);
        optionBtnTrue = findViewById(R.id.optionTrue);
        optionBtnFalse = findViewById(R.id.optionFalse);
        help = findViewById(R.id.help);


        questionModelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(questionModelArrayList);

        current = random.nextInt(questionModelArrayList.size());
        setDataToView(current);

        passedQuestions = new ArrayList<QuestionModel>();
//        passedQuestions=questionModelArrayList;

        previousQuestions = new ArrayList<>();


        QuestionAdapter questionAdapter = new QuestionAdapter(this, questionModelArrayList);
        ListView listView = findViewById(R.id.listView);
        listView.setVisibility(View.INVISIBLE);
        listView.setAdapter(questionAdapter);

        backward = (ImageView) findViewById(R.id.backward);
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionAttempted >= 1 && questionAttempted <= 10) {
                    questionAttempted = questionAttempted - 1;
                    previous = random.nextInt(passedQuestions.size());
//                    questionNumber.setText("Question Attempted:" + questionAttempted + "/10");
                    questionTV.setText(passedQuestions.get(previous).getQuestion());

                } else {
                    Toast.makeText(MachineLearning.this, "No passed Questions" +
                            "", Toast.LENGTH_SHORT).show();
                }

            }
        });

        forward = findViewById(R.id.forward);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionAttempted > 1 || optionBtnTrue.isPressed() && optionBtnFalse.isPressed()) {
                    getQuizQuestion(questionModelArrayList);
                    current = random.nextInt(passedQuestions.size());
                    questionNumber.setText("Question Attempted:" + questionAttempted + "/10");
                    questionTV.setText(passedQuestions.get(current).getQuestion());
                } else {
                    Toast.makeText(MachineLearning.this, "Please check your answers", Toast.LENGTH_SHORT).show();
                }
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //helping answer
                if (chance <= 1) {
                    chance++;
                    String helpAnswer;
                    helpAnswer = questionModelArrayList.get(current).getAnswer().trim().toString();
                    Intent intent = new Intent(MachineLearning.this, Help.class);
                    intent.putExtra("help", helpAnswer);
                    startActivity(intent);
                } else {
                    Toast.makeText(MachineLearning.this, "No More chance", Toast.LENGTH_SHORT).show();

                }
            }
        });

        optionBtnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionModelArrayList.get(current).getAnswer().trim().toLowerCase().equals(optionBtnTrue.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                passedQuestions.add(questionModelArrayList.get(current));
                previousQuestions.add(questionModelArrayList.get(current));
                questionAttempted++;
                current = random.nextInt(questionModelArrayList.size());
                setDataToView(current);
            }
        });

        optionBtnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionModelArrayList.get(current).getAnswer().trim().toLowerCase().equals(optionBtnFalse.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                passedQuestions.add(questionModelArrayList.get(current));
                previousQuestions.add(questionModelArrayList.get(current));
                questionAttempted++;
                current = random.nextInt(questionModelArrayList.size());
                setDataToView(current);
            }
        });
    }

    private void setDataToView(int current) {
        questionNumber.setText("Question Attempted:" + questionAttempted + "/10");
        TextView scores = (TextView) findViewById(R.id.scores);
        scores.setVisibility(View.INVISIBLE);
        //displaying scores
        scores.setText("" + currentScore);
        if (questionAttempted == 10) {
            Intent intent = new Intent(MachineLearning.this, Result.class);
            intent.putParcelableArrayListExtra("Pairs", passedQuestions);
            intent.putExtra("Scores", scores.getText());
            startActivity(intent);
            this.finish();
        } else {
            questionTV.setText(questionModelArrayList.get(current).getQuestion());
            optionBtnTrue.setText(questionModelArrayList.get(current).getOption1());
            optionBtnFalse.setText(questionModelArrayList.get(current).getOption2());
        }

    }

    private void getQuizQuestion(ArrayList<QuestionModel> questionModelArrayList) {
        questionModelArrayList.add(new QuestionModel("Am I your friend?", "Yes", "No", "Yes"));
        questionModelArrayList.add(new QuestionModel("Is this a good restaurant?", "Yes", "No", "No"));
        questionModelArrayList.add(new QuestionModel("Are these islands Greek?", "Yes", "No", "Yes"));
        questionModelArrayList.add(new QuestionModel("Was his idea interesting?", "Yes", "No", "No"));
        questionModelArrayList.add(new QuestionModel("Were they happy?", "Yes", "No", "Yes"));
        questionModelArrayList.add(new QuestionModel("Am I at the correct location?", "Yes", "No", "No"));
        questionModelArrayList.add(new QuestionModel("Are the keys under the books?", "Yes", "No", "No"));
        questionModelArrayList.add(new QuestionModel("Was his house on an island?", "Yes", "No", "Yes"));
        questionModelArrayList.add(new QuestionModel("Were the demonstrations in the center of town?", "Yes", "No", "No"));
        questionModelArrayList.add(new QuestionModel("Was his house on an island?", "Yes", "No", "Yes"));

    }
}