package com.sunil.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by User on 7/21/2015.
 */
public class LoginActivity extends AppCompatActivity {

    EditText JUid;
    EditText JPassword;
    Button JLogin;
    TextView Jtv;
    int counter = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        JUid = (EditText) findViewById(R.id.username);
        JPassword = (EditText) findViewById(R.id.password);
        JLogin = (Button) findViewById(R.id.submit);
        Jtv = (TextView) findViewById(R.id.tv);
        Jtv.setVisibility(View.GONE);

        JLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (JPassword.getText().toString().equals("1234")){
                    Toast.makeText(getApplicationContext(), "Redirecting..", Toast.LENGTH_SHORT).show();
                    Intent successIntent = new Intent(getApplicationContext(), QuizActivity.class);
                    startActivity(successIntent);
                }else {
                    Toast.makeText(getApplicationContext()," Login failed try again", Toast.LENGTH_SHORT).show();

                    Jtv.setVisibility(View.VISIBLE);
                    Jtv.setBackgroundColor(Color.RED);
                    counter --;
                    Jtv.setText("Attempts left: " + Integer.toString(counter));
                    if(counter == 0){
                        JLogin.setEnabled(false);
                    }
                }

            }
        });


    }
}
