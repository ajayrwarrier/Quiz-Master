package com.example.ajayrwarrier.quizmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ajay R Warrier on 23-10-2016.
 */
public class QuizActivity2 extends Activity {


    private static TextView Question;
    private static CheckBox opA;
    private static CheckBox opB;
    private static CheckBox opC;
    private static TextView QuesCount;
    private ArrayList<Questions> Questionlist = new ArrayList<>();
    private int i = 0;
    private int AnsScore = 0;
    private int score1;
    private int score2 = 0;

    @Override

    public void onBackPressed() {

        finish();
        Intent intent = new Intent(QuizActivity2.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        i = 0;
        score2 = 0;
        Intent intent = getIntent();
        score1 = Integer.valueOf(intent.getStringExtra("SCORE"));
        Question = (TextView) findViewById(R.id._ques);
        QuesCount = (TextView) findViewById(R.id.count);
        opA = (CheckBox) findViewById(R.id.OptionA);
        opB = (CheckBox) findViewById(R.id.OptionB);
        opC = (CheckBox) findViewById(R.id.OptionC);

        Questions q1 = new Questions(1, "Which of these are Android Versions?", "JellyBean", "KitKat", "Neyyappam", "JellyBean", "KitKat");
        Questions q2 = new Questions(2, "Which of these are Musical Instruments?", "Tabla", "Veena", "Guitar", "Tabla", "Veena", "Guitar");
        Questions q3 = new Questions(3, "Which of these are TV Shows?", "Inception", "Breaking Bad", "The Game of Thrones", "Breaking Bad", "The Game of Thrones");


        Questionlist.add(q1);
        Questionlist.add(q2);
        Questionlist.add(q3);

        UpdateView(i);

        Button Next = (Button) findViewById(R.id.Next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                CheckAnswer(i);
                i++;
                UpdateView(i);

            }
        });

        Button Submit = (Button) findViewById(R.id.Submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckAnswer(i);

                Intent intent = new Intent(QuizActivity2.this, FinalActivity.class);
                intent.putExtra("SCORE", String.valueOf(score1 + score2));
                startActivity(intent);
            }
        });


    }

    private void UpdateView(int i) {
        if (i < 3) {
            opA.setChecked(false);
            opB.setChecked(false);
            opC.setChecked(false);

            QuesCount.setText(String.valueOf(i + 6) + "/8");
            String que = Questionlist.get(i).getQno() + " " + Questionlist.get(i).getQuestion();

            Question.setText(que);
            opA.setText(Questionlist.get(i).getOP_A());
            opB.setText(Questionlist.get(i).getOP_B());
            opC.setText(Questionlist.get(i).getOP_C());

        } else {

            NextActivity();

        }
    }

    private void CheckAnswer(int i) {
        AnsScore = 0;
        if (i < 3) {

            //A checked B and C unchecked.
            if (opA.isChecked()&&!opB.isChecked()&&!opC.isChecked()) {
                if(!Checker(opB,i)&&!Checker(opC,i)){
                if (Checker(opA,i)){

                    score2++;

                }}
            }
            //B checked A and C unchecked.
            else if (opB.isChecked()&&!opA.isChecked()&&!opC.isChecked()) {
                if(!Checker(opC,i)&&!Checker(opA,i)){
                    if (Checker(opB,i)){

                        score2++;

                    }}
            }
            //C checked B and A unchecked.

            else if (opC.isChecked()&&!opB.isChecked()&&!opA.isChecked()) {
                if(!Checker(opA,i)&&!Checker(opB,i)){
                    if (Checker(opC,i)){

                        score2++;

                    }}
            }
            //A and C checked B Unchecked.
           else if (opA.isChecked() && opC.isChecked() && !opB.isChecked() ) {
              if(!Checker(opB,i)){
                  if(Checker(opA,i)&&Checker(opC,i)){
                      score2++;
                  }
              }
            }
            //A and B checked C Unchecked.
            else if (opA.isChecked() && opB.isChecked() && !opC.isChecked() ) {

                if(!Checker(opC,i)){
                    if(Checker(opA,i)&&Checker(opB,i)){
                        score2++;
                    }
                }

                }

            //B and C checked A Unchecked.
           else if (opB.isChecked() && opC.isChecked() && !opA.isChecked() ) {
            if(!Checker(opA,i)){
                if(Checker(opC,i)&&Checker(opB,i)){
                    score2++;
                }
            }

        }
            //A B and C Checked.
            else if (opB.isChecked() && opC.isChecked() && opA.isChecked() ) {

           if(Checker(opA,i)&&Checker(opB,i)&&Checker(opC,i)){

               score2++;
           }


            }}

         else {
            NextActivity();

        }
    }

    /*private void UpdateScore(int i, int AnsScore) {
        if (AnsScore == Questionlist.get(i).getANScount() || AnsScore == 5 || AnsScore == 4) {
            score2++;
        }

    }*/

    private void NextActivity() {
        Intent intent = new Intent(QuizActivity2.this, FinalActivity.class);
        intent.putExtra("SCORE", String.valueOf(score1 + score2));
        startActivity(intent);
    }
    private boolean Checker(CheckBox box,int i){
        if ((box.getText() == Questionlist.get(i).getANS() || box.getText() == Questionlist.get(i).getANS2()
                || box.getText() == Questionlist.get(i).getANS3())){
            return true;
        }
        else return false;
    }
}
