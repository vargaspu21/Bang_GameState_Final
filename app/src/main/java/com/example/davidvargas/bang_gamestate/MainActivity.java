package com.example.davidvargas.bang_gamestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected Button runTest;
    protected EditText multiLine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runTest = (Button) findViewById(R.id.runTestButton);
        runTest.setOnClickListener(this);

        multiLine = (EditText) findViewById(R.id.multilneEditText);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.runTestButton:

                //RUN TEST PSEUDO CODE:
                //1):
                // add a bang to player 1 hand
                //add a beer to player 2 hand
                //add a bang to player 3 hand
                //set player 1 health to 1

                //2)
                //player 1 draws two cards
                //player 1 plays a bang card (assume player 2 is selected)
                //player 1 end turn

                //3)
                //player 2 draws
                //player 2 plays a beer
                //player 2 ends beer

                //4)
                //player 3 draws
                //player 3 plays a bang card (assume player 4 is selected)
                //(player 4 dies bc only had one health points)
                //player 3 ends turn



                break;
        }
    }


}
