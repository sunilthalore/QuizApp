package com.sunil.quizapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button JmB1, JmB2, JmB3;
    Button JDismissButton;
    Button JLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JmB1 = (Button) findViewById(R.id.mb1);
        JmB2 = (Button) findViewById(R.id.mb2);
        JmB3 = (Button) findViewById(R.id.mb3);
        JLogin = (Button) findViewById(R.id.loginBtn);

        JmB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    play(v);
            }
        });
        JLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               login(v);
            }
        });

        JmB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitIntent = new Intent(Intent.ACTION_MAIN);
                exitIntent.addCategory(Intent.CATEGORY_HOME);
                exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(exitIntent);
            }
        });

       final Dialog dialog = new Dialog(this);
        JmB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    dialog.setContentView(R.layout.help);
                    dialog.show();



            }
        });

    }

    public void play(View v){
        Intent playIntent = new Intent(this, QuizActivity.class);
        startActivity(playIntent);

        Log.d("intent working>", "Working");
    }
    public void login(View v){
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
