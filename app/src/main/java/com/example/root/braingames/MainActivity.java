package com.example.root.braingames;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startGame=(Button) findViewById(R.id.StartGamebutton);
        TextView mainText=(TextView) findViewById(R.id.mainText);
        Typeface amatic=Typeface.createFromAsset(getAssets(),"fonts/Amatic-Bold.ttf");
        mainText.setTypeface(amatic);
        startGame.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        Intent intent=new Intent(getApplicationContext(),secondActivity.class);
        startActivity(intent);
        finish();
    }
}
