package com.example.davidvargas.bang_gamestate;

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
    }
}
