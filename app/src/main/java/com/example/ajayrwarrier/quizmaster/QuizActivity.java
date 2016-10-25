package com.example.ajayrwarrier.quizmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ajay R Warrier on 23-10-2016.
 */
public class QuizActivity extends Activity {

    private static TextView Question;
    private static RadioButton opA;
    private static RadioButton opB;
    private static RadioButton opC;
    private static TextView QuesCount;
    private ArrayList<Questions> Questionlist = new ArrayList<>();
    private int i = 0;
    private int score = 0;

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(QuizActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        i = 0;
        score = 0;

        Question = (TextView) findViewById(R.id._ques);
        QuesCount = (TextView) findViewById(R.id.count);
        opA = (RadioButton) findViewById(R.id.OptionA);
        opB = (RadioButton) findViewById(R.id.OptionB);
        opC = (RadioButton) findViewById(R.id.OptionC);

        Questions q1 = new Questions(1, "Which of the following table can you eat?", "Dining Table", "Computer", "Vegetable", "Vegetable");
        Questions q2 = new Questions(2, "Which is the animal referred as the ship of the desert?", "Ostrich", "Camel", "Elephant", "Camel");
        Questions q3 = new Questions(3, "Which is the least populated country in the world?", "Vatican City", "Thrissur City", "Startling City", "Vatican City");
        Questions q4 = new Questions(4, "Which is the fastest animal on the land? ", "Rabbit", "Cheetah", "Lion", "Cheetah");
        Questions q5 = new Questions(5, "Which is the principal source of energy for earth?", "Sun", "Water", "Moon", "Sun");

        Questionlist.add(q1);
        Questionlist.add(q2);
        Questionlist.add(q3);
        Questionlist.add(q4);
        Questionlist.add(q5);

        UpdateView(i);

        Button Next = (Button) findViewById(R.id.Next);
        Button Submit = (Button) findViewById(R.id.Submit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckAnswer(i);
                Intent intent = new Intent(QuizActivity.this, FinalActivity.class);
                intent.putExtra("SCORE", String.valueOf(score));
                startActivity(intent);
            }
        });

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                CheckAnswer(i);
                i++;
                UpdateView(i);

            }
        });


    }

    private void UpdateView(int i) {
        if (i < 5) {

            opA.setChecked(false);
            opB.setChecked(false);
            opC.setChecked(false);

            String que = Questionlist.get(i).getQno() + " " + Questionlist.get(i).getQuestion();

            QuesCount.setText(String.valueOf(i + 1) + "/8");
            Question.setText(que);
            opA.setText(Questionlist.get(i).getOP_A());
            opB.setText(Questionlist.get(i).getOP_B());
            opC.setText(Questionlist.get(i).getOP_C());

        } else {
            NextActivity();
        }
    }

    private void CheckAnswer(int i) {
        if (i < 5) {
            if (opA.isChecked()) {
                if (opA.getText() == Questionlist.get(i).getANS()) {
                    score++;
                }
            }

            if (opC.isChecked()) {
                if (opC.getText() == Questionlist.get(i).getANS()) {
                    score++;
                }
            }
            if (opB.isChecked()) {
                if (opB.getText() == Questionlist.get(i).getANS()) {
                    score++;
                }
            }
        } else {
            NextActivity();
        }
    }

    private void NextActivity() {
        Intent intent = new Intent(QuizActivity.this, QuizActivity2.class);
        intent.putExtra("SCORE", String.valueOf(score));
        startActivity(intent);


    }

}
