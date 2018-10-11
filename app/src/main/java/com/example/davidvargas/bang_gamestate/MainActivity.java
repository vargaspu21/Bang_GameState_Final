package com.example.davidvargas.bang_gamestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.davidvargas.bang_gamestate.objects.PlayableCard;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected Button runTest;
    protected EditText multiLine;
    protected GameState gs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runTest = (Button) findViewById(R.id.runTestButton);
        runTest.setOnClickListener(this);

        multiLine = (EditText) findViewById(R.id.multilneEditText);

        gs = new GameState();
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.runTestButton:

                //RUN TEST PSEUDO CODE:
                //1):
                //add a bang card to player 1 hand
                //add a beer card to player 2 hand
                //add a bang card to player 3 hand
                //set player 4 health to 1
                PlayableCard bangCard = new PlayableCard(false, 0);
                PlayableCard beerCard = new PlayableCard(false, 1);
                gs.players[0].setCardsInHand(bangCard);
                gs.players[1].setCardsInHand(beerCard);
                gs.players[2].setCardsInHand(bangCard);
                gs.players[4].setHealth(1);

                //2)
                //player 1 draws two cards
                //player 1 plays a bang card (assume player 2 is selected)
                //player 1 end turn
                gs.drawTwo(0);
                gs.playBANG(0,1);
                gs.endTurn(0);//not implemented yet if red


                //3)
                //player 2 draws
                //player 2 plays a beer
                //player 2 ends turn
                gs.drawTwo(1);
                gs.playBeer(1);
                gs.endTurn(1);

                //4)
                //player 3 draws
                //player 3 plays a bang card (assume player 4 is selected)
                //(player 4 dies bc only had one health points)
                //player 3 ends turn
                gs.drawTwo(2);
                gs.playBANG(2,3);
                gs.endTurn(2);



                break;
        }
    }


}
