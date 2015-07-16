package com.sunil.quizapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by User on 7/15/2015.
 */
public class QuizActivity extends AppCompatActivity implements View.OnClickListener{

    Button Jb1, Jb2, Jb3, Jb4;
    TextView JqnTextBoxl;
   // SQLiteDatabase scoreDB;
    int buttonID;
    int qID;
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        Jb1 = (Button)findViewById(R.id.option1);
        Jb2 = (Button)findViewById(R.id.option2);
        Jb3 = (Button)findViewById(R.id.option3);
        Jb4 = (Button)findViewById(R.id.option4);

        JqnTextBoxl = (TextView) findViewById(R.id.qnTextBox);

       // scoreDB = openOrCreateDatabase("ScoreDB" , MODE_PRIVATE ,null);
       // scoreDB.execSQL("create table if not exists scoreTable(qnScore integer, totalScore integer");

        Jb1.setOnClickListener(this);
        Jb2.setOnClickListener(this);
        Jb3.setOnClickListener(this);
        Jb4.setOnClickListener(this);

        Jb1.setSoundEffectsEnabled(false);
        Jb2.setSoundEffectsEnabled(false);
        Jb3.setSoundEffectsEnabled(false);
        Jb4.setSoundEffectsEnabled(false);


        JqnTextBoxl.setText("Who won 2014 Formula 1 championship?");
        Jb1.setText("Sebastian Vettel");
        Jb2.setText("Michael Schumacher");
        Jb3.setText("Lewis Hamilton");
        Jb4.setText("Nico Roseberg");
        qID =1;


    }

    @Override
    public void onClick(View v) {
     MediaPlayer mp = MediaPlayer.create(this, R.drawable.click);
        mp.start();

        switch (v.getId()){
            case (R.id.option1):
                buttonID = 1;
                break;
            case (R.id.option2):
                buttonID = 2;
                break;
            case (R.id.option3):
                buttonID = 3;
                break;
            case (R.id.option4):
                buttonID = 4;
                break;
        }
        if (qID ==1 && buttonID == 3){
            score = 1;
        }

        Log.d("log btn id", String.valueOf(buttonID));



            qID = qID + 1 ;

        buttonPressed();

    }

    public void buttonPressed(){

        if ( qID == 2) {
            JqnTextBoxl.setText("Who won 2013 Formula 1 championship?");
            Jb1.setText("Sebastian Vettel");
            Jb2.setText("Michael Schumacher");
            Jb3.setText("Lewis Hamilton");
            Jb4.setText("Nico Roseberg");

            if (buttonID == 1){
                score = score +1;
            }
            Log.d("log question", "second qn");
            Log.d("log score",String.valueOf(score));
        }
        if (qID ==3){
            JqnTextBoxl.setText("Who won 2012 Formula 1 championship?");
            Jb1.setText("Sebastian Vettel");
            Jb2.setText("Michael Schumacher");
            Jb3.setText("Lewis Hamilton");
            Jb4.setText("Nico Roseberg");

            if (buttonID == 1){
                score = score +1;
            }
            Log.d("log question", "third qn");
            Log.d("log score",String.valueOf(score));

        }

            String totalScore = String.valueOf(score);
            Toast.makeText(this, "your total score is: " + totalScore, Toast.LENGTH_LONG ).show();

    }
}
