package com.example.root.braingames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class secondActivity extends AppCompatActivity {
    Button startGame;
    TextView triviaSum;
    TextView results;
    TextView myScore;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    RelativeLayout success;
    //location of correct answer in the layout
    int locationOfCorrectAnswer;
    int score=0;
    int numberOfQuestions;

    //will contain answers
    ArrayList<Integer> answers=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        generateNewQuestion();

         triviaSum=(TextView) findViewById(R.id.textTrivia);

        //buttons to display the answers
         button0=(Button) findViewById(R.id.button0);
         button1=(Button) findViewById(R.id.button1);
         button2=(Button) findViewById(R.id.button2);
         button3=(Button) findViewById(R.id.button3);
        //get view for score and results
        results=(TextView) findViewById(R.id.textView5);
        myScore=(TextView) findViewById(R.id.textScore);
        //invisible layouts
        success=(RelativeLayout) findViewById(R.id.successLayout);



    }
    public void generateNewQuestion(){
        button0=(Button) findViewById(R.id.button0);
        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        //generate random numbers for the trivia
        Random rand=new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        //set the textview
        triviaSum=(TextView) findViewById(R.id.textTrivia);
        triviaSum.setText(Integer.toString(a) + " + " +Integer.toString(b));
        //location is based on the tag of buttons which is from 0-3
        locationOfCorrectAnswer=rand.nextInt(4);
        //setting correct answer
        for(int i=0;i<4;i++){
            //if the button is the loacation of the correct answer,
            //add the correct to the arrayList
            int incorrectAnswer;
            if(i == locationOfCorrectAnswer){
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
        //set text according to the number in the arraylist at the positions
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
        answers.clear();
    }

    //method to find answer
    public void getAnswer(View view){
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
           score ++;
            numberOfQuestions++;
            results.setText("correct");
            myScore.setText(Integer.toString(score)+"/"+ Integer.toString(numberOfQuestions));
        }
        else{
            score+=0;
            numberOfQuestions++;
            results.setText("Incorrect");
            myScore.setText(Integer.toString(score)+"/"+ Integer.toString(numberOfQuestions));

        }
        generateNewQuestion();
        if(score==10){
            success=(RelativeLayout) findViewById(R.id.successLayout);
            success.setAlpha(1);
        }
    }

}
