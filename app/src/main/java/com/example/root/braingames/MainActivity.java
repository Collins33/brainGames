package com.example.root.braingames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startGame=(Button) findViewById(R.id.StartGamebutton);
        startGame.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        Intent intent=new Intent(getApplicationContext(),secondActivity.class);
        startActivity(intent);
        finish();
    }
}
