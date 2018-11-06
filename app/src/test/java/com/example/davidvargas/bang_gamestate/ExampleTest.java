package com.example.davidvargas.bang_gamestate;

import com.example.davidvargas.bang_gamestate.objects.PlayableCard;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleTest
{
    @Test
    public void sampleTest()
    {
        GameState test = new GameState();

        assertTrue(test.discardPile.isEmpty());

        assertFalse(test.drawPile.isEmpty());
        assertTrue(test.playCard(0,1,test.BANG));
        assertEquals(test.players[1].getHealth(),3);


        assertTrue(test.playBANG(0, 1));
    }


    @Test
    public void testBeer()
    {
        GameState newGame = new GameState();
        //add a beer to p1 hand\
        newGame.players[1].setCardsInHand(new PlayableCard(false, newGame.BEER));
        newGame.players[1].setHealth(3);
        newGame.playBeer(1); //testing this
        assertEquals(newGame.players[1].getHealth(), 4);

    }

    @Test
    public void testDuel()
    {
        GameState newGame = new GameState();
        newGame.players[0].setCardsInHand(new PlayableCard(false, newGame.BANG));
        newGame.players[0].setCardsInHand(new PlayableCard(false, newGame.BANG));
        newGame.players[0].setCardsInHand(new PlayableCard(false, newGame.BANG));
        newGame.players[0].setCardsInHand(new PlayableCard(false, newGame.BANG));
        newGame.players[1].setCardsInHand(new PlayableCard(false, newGame.BANG));
        newGame.players[1].setCardsInHand(new PlayableCard(false, newGame.BANG));

        newGame.playDuel(0, 1);
        assertEquals(newGame.players[1].getHealth(), 3);
        int count = 0;

        for(PlayableCard p: newGame.players[1].getCardsInHand()) {
            if(p.getCardNum() == newGame.BANG){
                count++;
            }
        }
        assertEquals(count, 0);
        //do the same for player 0
    }

}
