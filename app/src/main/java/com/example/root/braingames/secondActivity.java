package com.example.root.braingames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class secondActivity extends AppCompatActivity implements View.OnClickListener{
    Button startGame;
    TextView triviaSum;
    //location of correct answer in the layout
    int locationOfCorrectAnswer;
    //will contain answers
    ArrayList<Integer> answers=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
         startGame=(Button) findViewById(R.id.startGame);
         triviaSum=(TextView) findViewById(R.id.textTrivia);
         startGame.setOnClickListener(this);
        //buttons to display the answers
        Button button0=(Button) findViewById(R.id.button0);
        Button button1=(Button) findViewById(R.id.button1);
        Button button2=(Button) findViewById(R.id.button2);
        Button button3=(Button) findViewById(R.id.button3);

        //generate random numbers for the trivia
        Random rand=new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        //set the textview
        triviaSum.setText(Integer.toString(a) + " + " +Integer.toString(b));
        //location is based on the tag of buttons which is from 0-3
        locationOfCorrectAnswer=rand.nextInt(4);
        //setting correct answer
        for(int i=0;i<4;i++){
            //if the button is the loacation of the correct answer,
            //add the correct to the arrayList
            int incorrectAnswer;
            if(i==locationOfCorrectAnswer){
                answers.add(a+b);
            }
            //if it is not the location of the correct answer
            else{
                 incorrectAnswer=rand.nextInt(41);
                while(incorrectAnswer== a+b){
                    //stop generation of correct answer in wrong answer layout
                    incorrectAnswer=rand.nextInt(41);
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }
    //method to find answer
    public void getAnswer(View view){
        Log.d("tag",(String) view.getTag());
    }
    @Override
    public void onClick(View view){
        if (view==startGame){
            RelativeLayout relativeLayout=(RelativeLayout) findViewById(R.id.relativeLayoutInstructions);
            relativeLayout.setAlpha(0);
        }
    }
}
