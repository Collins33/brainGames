package com.example.root.braingames;

import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class secondActivity extends AppCompatActivity {
    Button startGame1;
    Button startGame2;
    TextView triviaSum;
    TextView results;
    TextView myScore;
    TextView timeText;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    RelativeLayout success;
    RelativeLayout fail;
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
        //styling the activity
        TextView score=(TextView) findViewById(R.id.textScore);
        TextView time=(TextView) findViewById(R.id.textTime);
        TextView trivia=(TextView) findViewById(R.id.textTrivia);
        TextView answer=(TextView) findViewById(R.id.textView5);

        Typeface amatic=Typeface.createFromAsset(getAssets(),"fonts/Amatic-Bold.ttf");
        score.setTypeface(amatic);
        time.setTypeface(amatic);
        trivia.setTypeface(amatic);
        answer.setTypeface(amatic);

        //buttons to display the answers
         button0=(Button) findViewById(R.id.button0);
         button1=(Button) findViewById(R.id.button1);
         button2=(Button) findViewById(R.id.button2);
         button3=(Button) findViewById(R.id.button3);
         startGame1=(Button) findViewById(R.id.startGameAgain);
         startGame2=(Button) findViewById(R.id.button);
        //get view for score and results
        results=(TextView) findViewById(R.id.textView5);
        myScore=(TextView) findViewById(R.id.textScore);
        //invisible layouts
        success=(RelativeLayout) findViewById(R.id.successLayout);
        startGame1.setEnabled(false);
        startGame2.setEnabled(false);

        //countdown timer

        countDown();
    }
    public void countDown(){
        results=(TextView) findViewById(R.id.textView5);
        myScore=(TextView) findViewById(R.id.textScore);
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timeText=(TextView) findViewById(R.id.textTime);
                timeText.setText(String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                timeText=(TextView) findViewById(R.id.textTime);
                timeText.setText("0s");
                button0=(Button) findViewById(R.id.button0);
                button1=(Button) findViewById(R.id.button1);
                button2=(Button) findViewById(R.id.button2);
                button3=(Button) findViewById(R.id.button3);
                //deactivate buttons
                button0.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                startGame1.setEnabled(true);
                startGame2.setEnabled(true);

                if(score>10){
                    success=(RelativeLayout) findViewById(R.id.successLayout);
                    success.setAlpha(1);}
                else{
                    fail=(RelativeLayout) findViewById(R.id.failRelativeLayout);
                    fail.setAlpha(1);
                }

            }
        }.start();
    }
    public void startAgain(View view){
        //get view from the invisible layouts
        results=(TextView) findViewById(R.id.textView5);
        myScore=(TextView) findViewById(R.id.textScore);
        //when the game starts,disable the play again button
        startGame1.setEnabled(false);
        startGame2.setEnabled(false);
        //enable the answer buttons when the user plays again
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        //make the layouts that pop up invisible
        success=(RelativeLayout) findViewById(R.id.successLayout);
        success.setAlpha(0);
        fail=(RelativeLayout) findViewById(R.id.failRelativeLayout);
        fail.setAlpha(0);
        //reset the score and number of questions back to 0
        score=0;
        numberOfQuestions=0;
        results=(TextView) findViewById(R.id.textView5);
        myScore=(TextView) findViewById(R.id.textScore);
        timeText=(TextView) findViewById(R.id.textTime);
        //set the score to 0
        results.setText(Integer.toString(score));
        myScore.setText(Integer.toString(score)+"/"+ Integer.toString(numberOfQuestions));

        timeText.setText("0");
        generateNewQuestion();
        countDown();
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


    }

}
