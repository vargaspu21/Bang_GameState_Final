package com.example.davidvargas.bang_gamestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.davidvargas.bang_gamestate.objects.PlayableCard;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected Button runTest;
    protected EditText multiLine;
    protected GameState firstInstance;
    protected GameState secondInstance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runTest = (Button) findViewById(R.id.runTestButton); //creates the instance of the run test button
        runTest.setOnClickListener(this); //sets the listener for the run test button

        multiLine = (EditText) findViewById(R.id.multilneEditText); //creates the instance of the multiline edit text


        
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.runTestButton:

                    //1)
                    //add a bang card to player 1 hand
                    //add a beer card to player 2 hand
                    //add a bang card to player 3 hand
                    //set player 4 health to 1
                    multiLine.setText("");
                    firstInstance = new GameState();
                    secondInstance = new GameState(firstInstance);
                multiLine.append("FIRST INSTANCE: \n");
                    multiLine.append("Adding bang card to player 1 hand...\nAdding a beer card to player 2 hand...\n" +
                            "Adding a bang card to player 3 hand...\n");
                    PlayableCard bangCard = new PlayableCard(false, 0);
                    PlayableCard beerCard = new PlayableCard(false, 1);
                    firstInstance.players[0].setCardsInHand(bangCard);
                    firstInstance.players[1].setCardsInHand(beerCard);
                    firstInstance.players[2].setCardsInHand(bangCard);
                    firstInstance.players[3].setHealth(1);
                    multiLine.append("Current game state: \n"+ firstInstance.toString());
                    multiLine.append("\n******************************************\n");



                    //2)
                    //player 1 draws two cards
                    //player 1 plays a bang card (assume player 2 is selected)
                    //player 1 end turn
                    multiLine.append("SECOND INSTANCE: \n");
                    multiLine.append("Drawing 2 cards for player 1, then playing a bang on player 2...\n");
                    multiLine.append("Ending turn...\n");
                    secondInstance.drawTwo(0);
                    secondInstance.playBANG(0,1);
                    secondInstance.endTurn(0);
                    multiLine.append("Current game state: \n"+ secondInstance.toString());
                    multiLine.append("\n******************************************\n");



                //3)
                    //player 2 draws
                    //player 2 plays a beer
                    //player 2 ends turn
                    multiLine.append("THIRD INSTANCE: \n");
                    multiLine.append("Drawing 2 cards for player 2, then playing beer card...\n");
                    multiLine.append("Ending turn...\n");
                    secondInstance.drawTwo(1);
                    secondInstance.playBeer(1);
                    secondInstance.endTurn(1);
                    multiLine.append("Current game state: \n"+ secondInstance.toString());
                    multiLine.append("\n******************************************\n");


                //4)
                    //player 3 draws
                    //player 3 plays a bang card (assume player 4 is selected)
                    //(player 4 dies bc only had one health points)
                    //player 3 ends turn
                    multiLine.append("FOURTH INSTANCE: \n");
                    multiLine.append("Drawing 2 cards for player 3, then playing a bang on player 4..\n");
                    multiLine.append("Player 4 dies, no health points remaining\n");
                    multiLine.append("Ending turn...\n");
                    secondInstance.drawTwo(2);
                    secondInstance.playBANG(2,3);
                    secondInstance.endTurn(2);
                    multiLine.append("Current game state: \n"+ secondInstance.toString());
                    multiLine.append("\n******************************************\n");


                break;
        }
    }


}
