package com.example.root.braingames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class secondActivity extends AppCompatActivity implements View.OnClickListener{
    Button startGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
         startGame=(Button) findViewById(R.id.startGame);
         startGame.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        if (view==startGame){
            RelativeLayout relativeLayout=(RelativeLayout) findViewById(R.id.relativeLayoutInstructions);
            relativeLayout.setAlpha(0);
        }
    }
}
