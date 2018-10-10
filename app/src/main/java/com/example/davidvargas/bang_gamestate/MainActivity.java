package com.example.davidvargas.bang_gamestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected Button runTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runTest = (Button) findViewById(R.id.runTestButton);
        runTest.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.runTestButton:
                //code for run test button here
                //set hands for every player
                //player 1 bangs player 2
                break;
        }
    }


}
