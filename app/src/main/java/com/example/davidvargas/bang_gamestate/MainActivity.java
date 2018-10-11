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
    protected GameState gs1;
    protected GameState gs2;
    protected GameState gs3;
    protected GameState gs4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runTest = (Button) findViewById(R.id.runTestButton);
        runTest.setOnClickListener(this);

        multiLine = (EditText) findViewById(R.id.multilneEditText);

        gs1 = new GameState();
        gs2 = new GameState();
        gs3 = new GameState();
        gs4 = new GameState();
        
    }

    @Override
    public void onClick(View v)
    {
        Random rand = new Random();
        int i = rand.nextInt(4) +1 ;
        switch (v.getId()) {
            case R.id.runTestButton:
            switch(i){
                case 1:
                    //1):
                    //add a bang card to player 1 hand
                    //add a beer card to player 2 hand
                    //add a bang card to player 3 hand
                    //set player 4 health to 1
                    multiLine.setText("");
                    PlayableCard bangCard = new PlayableCard(false, 0);
                    PlayableCard beerCard = new PlayableCard(false, 1);
                    gs1.players[0].setCardsInHand(bangCard);
                    gs1.players[1].setCardsInHand(beerCard);
                    gs1.players[2].setCardsInHand(bangCard);
                    gs1.players[4].setHealth(1);
                    break;
                case 2:
                    //2)
                    //player 1 draws two cards
                    //player 1 plays a bang card (assume player 2 is selected)
                    //player 1 end turn
                    multiLine.setText("");
                    gs2.drawTwo(0);
                    gs2.playBANG(0,1);
                    gs2.endTurn(0);//not implemented yet if red
                    break;
                case 3:
                    //3)
                    //player 2 draws
                    //player 2 plays a beer
                    //player 2 ends turn
                    multiLine.setText("");
                    gs3.drawTwo(1);
                    gs3.playBeer(1);
                    gs3.endTurn(1);
                    break;
                case 4:
                    //4)
                    //player 3 draws
                    //player 3 plays a bang card (assume player 4 is selected)
                    //(player 4 dies bc only had one health points)
                    //player 3 ends turn
                    multiLine.setText("");
                    gs4.drawTwo(2);
                    gs4.playBANG(2,3);
                    gs4.endTurn(2);
                    break;


            }
                break;
        }
    }


}
