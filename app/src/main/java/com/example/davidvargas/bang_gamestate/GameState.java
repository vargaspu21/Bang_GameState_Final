package com.example.davidvargas.bang_gamestate;

import com.example.davidvargas.bang_gamestate.objects.Card;
import com.example.davidvargas.bang_gamestate.objects.PlayerInfo;

import java.util.ArrayList;

public class GameState extends Card{

    protected ArrayList <Card> drawPile;
    protected ArrayList <Card> discardPile;
    protected int playerTurn, bangsPlayed;
    protected PlayerInfo [] players;


    public GameState ()
    {
        drawPile = new ArrayList<>();
        discardPile = new ArrayList<>();
        players = new PlayerInfo[4];
        playerTurn = 0;
        bangsPlayed = 0;
    }

    //a copy constructor:
    GameState(GameState gs)
    {
        drawPile = gs.drawPile;
        discardPile = gs.discardPile;
        playerTurn = gs.playerTurn;
        bangsPlayed = gs.bangsPlayed;
        players = gs.players;
    }



    public String toString()
    {
        for(Card c: drawPile) c.toString();
        for(Card c: discardPile) c.toString();
        for(PlayerInfo p: players) p.toString();
        System.out.println("Current player turn: "+playerTurn);
        System.out.println("BANGs played: "+bangsPlayed);
        return "hello";
    }
}
