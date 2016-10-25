package com.example.ajayrwarrier.quizmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
    private int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent intent =getIntent();
        score=Integer.valueOf(intent.getStringExtra("SCORE"));

        TextView scoreView = (TextView)findViewById(R.id.ScoreDisplay);
        scoreView.setText(String.valueOf(score)+"/8");                  //Displays Score

        Button start = (Button)findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (FinalActivity.this,MainActivity.class);
                startActivity(i);
            }
        });


    }


}
