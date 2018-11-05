package com.example.davidvargas.bang_gamestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.davidvargas.bang_gamestate.objects.CharacterCard;
import com.example.davidvargas.bang_gamestate.objects.PlayableCard;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //added to make thirdinstance test easier
    public final int GATLING = 12;
    public final int SALOON = 16;
    public final int BANG = 5;
    public final int MISSED = 6;
    public final int BEER = 7;
    public final int INDIANS = 14;

    public final int ELGRINGO = 4;
    public final int CALAMITYJANET = 14;



    //initializes variables:
    protected Button runTest;
    protected EditText multiLine;
    protected GameState firstInstance; //player 1 plays bang on player 2
    protected GameState secondInstance; //player 2 plays bang back, but player 1 misses it, player 2 then uses gatling
    protected GameState thirdInstance; //player 3 plays gatling, then uses a beer to heal a health
    protected GameState fourthInstance; //
    protected GameState fifthInstance; //MADE 10/31/2018, for new test case to check CharacterCaard and newly-added PlayableCards


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

                    //player1's turn
                    //player1 draws two cards
                    //adds bang card to player1's hand
                    //adds missed card to player1's hand
                    //player1 plays bang on player2, it works
                    //player1 ends their turn
                    multiLine.setText("");
                    firstInstance = new GameState();
                    secondInstance = new GameState(firstInstance);
                    multiLine.append("FIRST INSTANCE: \n");
                    firstInstance.drawTwo(0);
                    multiLine.append("Player 1 draws two cards...\n");
                    //ensures runtest works as planned; player 1 has a bang to use on player 2
                    firstInstance.players[0].setCardsInHand(new PlayableCard(false, BANG));
                    multiLine.append("Player 1 plays the bang card...\n");
                    firstInstance.playCard(0,1,BANG);
                    //all following new playablecards are added to let runtest work as planned...
                    firstInstance.players[0].setCardsInHand(new PlayableCard(false,MISSED));
                    multiLine.append("Player 1 ends their turn...\n");
                    firstInstance.endTurn(0);
                    multiLine.append("Current game state: \n"+ firstInstance.toString());
                    multiLine.append("\n******************************************\n");


                    //player2's turn
                    //player2 draws two cards
                    //adds bang card to player2's hand
                    //adds gatling card to player2's hand
                    //player2 plays bang on player1, missed
                    //player2 plays gatling card on everyone
                    //player2 ends their turn
                    secondInstance = new GameState(firstInstance);
                    multiLine.append("SECOND INSTANCE: \n");
                    multiLine.append("It is Player 2's turn...\n");
                    secondInstance.drawTwo(1);
                    multiLine.append("Player 2 draws two cards...\n");
                    secondInstance.players[1].setCardsInHand(new PlayableCard(false, BANG));
                    secondInstance.players[1].setCardsInHand(new PlayableCard(false, GATLING));
                    secondInstance.playCard(1,0,BANG);
                    multiLine.append("Player 2 uses a BANG on Player 1...\n");
                    multiLine.append("Player 1 uses a Miss card. Player 2 misses...\n");
                    secondInstance.playCard(1,1,GATLING);
                    multiLine.append("Player 2 uses Gatling...\n");
                    multiLine.append("Player 2 ends their turn...\n");
                    secondInstance.endTurn(1);
                    multiLine.append("Current game state: \n"+ secondInstance.toString());
                    multiLine.append("\n******************************************\n");


                    //player3's turn
                    //player3 draws two cards
                    //adds gatling card to player3's hand
                    //adds beer card to player3's hand
                    //player3 plays gatling on everyone
                    //player3 plays beer, restores a health
                    //player3 ends their turn
                    thirdInstance = new GameState(secondInstance);
                    multiLine.append("THIRD INSTANCE: \n");
                    multiLine.append("It is Player 3's turn...\n");
                    thirdInstance.drawTwo(2);
                    multiLine.append("Player 3 draws two cards...\n");
                    thirdInstance.players[2].setCardsInHand(new PlayableCard(false,GATLING));
                    thirdInstance.players[2].setCardsInHand(new PlayableCard(false, BEER));
                    multiLine.append("Player 3 uses Gatling...\n");
                    thirdInstance.playCard(2,2,GATLING);
                    multiLine.append("Player 3 uses Beer...\n");
                    thirdInstance.playCard(2,2,BEER);
                    multiLine.append("Player 3 ends their turn...\n");
                    thirdInstance.endTurn(2);
                    multiLine.append("Current game state: \n"+ thirdInstance.toString());
                    multiLine.append("\n******************************************\n");


                    //player4's turn
                    //player4 draws two cards
                    //adds saloon card to player4's hand
                    //adds indians card to playe4's hand
                    //player4 plays saloon card
                    //player4 plays indians on everyone
                    //player4 ends their turn
                    fourthInstance = new GameState(thirdInstance);
                    multiLine.append("FOURTH INSTANCE: \n");
                    multiLine.append("It is Player 4's turn...\n");
                    fourthInstance.drawTwo(3);
                    multiLine.append("Player 4 draws two cards...\n");
                    fourthInstance.players[3].setCardsInHand(new PlayableCard(false, SALOON));
                    fourthInstance.players[3].setCardsInHand(new PlayableCard(false, INDIANS));
                    multiLine.append("Player 4 plays Indians...\n");
                    fourthInstance.playCard(3,3,INDIANS);
                    multiLine.append("Player 4 plays Saloon...\n");
                    fourthInstance.playCard(3,3,SALOON);
                    multiLine.append("Player 4 ends their turn...\n");
                    fourthInstance.endTurn(3);
                    multiLine.append("Current game state: \n"+ fourthInstance.toString());
                    multiLine.append("\n******************************************\n");


                    //new instance of game
                    //tests el gringo
                    //tests calamity janet
                    //tests new playableCards?
                    fifthInstance = new GameState();
                    fifthInstance.players[0].setCharacter(new CharacterCard(4, ELGRINGO));
                    fifthInstance.players[0].setCardsInHand(new PlayableCard(false, BANG));
                    fifthInstance.players[1].setCardsInHand(new PlayableCard(false, BANG));
                    fifthInstance.playBANG(0,1);
                    fifthInstance.endTurn(0);


                    fifthInstance.players[1].setCharacter(new CharacterCard(4, CALAMITYJANET));
                    fifthInstance.players[1].setCardsInHand(new PlayableCard(false, BANG));
                    fifthInstance.players[1].setCardsInHand(new PlayableCard(false, MISSED));
                    fifthInstance.players[1].setCardsInHand(new PlayableCard(false, MISSED));
                    fifthInstance.players[1].setCardsInHand(new PlayableCard(false, BANG));
                    fifthInstance.playBANG(1,0);
                    fifthInstance.playBANG(1,0);
                    fifthInstance.playBANG(1,0);
                    fifthInstance.playBANG(1,0);
                    fifthInstance.endTurn(1);


                break;
        }
    }


}
