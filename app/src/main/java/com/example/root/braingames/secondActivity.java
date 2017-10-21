package com.example.root.braingames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class secondActivity extends AppCompatActivity implements View.OnClickListener{
    Button startGame;
    TextView triviaSum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
         startGame=(Button) findViewById(R.id.startGame);
         triviaSum=(TextView) findViewById(R.id.textTrivia);
         startGame.setOnClickListener(this);
        //generate random numbers for the trivia
        Random rand=new Random();
        int a=rand.nextInt(1001);
        int b=rand.nextInt(1001);
        //set the textview
        triviaSum.setText(Integer.toString(a) + " + " +Integer.toString(b));
    }
    @Override
    public void onClick(View view){
        if (view==startGame){
            RelativeLayout relativeLayout=(RelativeLayout) findViewById(R.id.relativeLayoutInstructions);
            relativeLayout.setAlpha(0);
        }
    }
}
