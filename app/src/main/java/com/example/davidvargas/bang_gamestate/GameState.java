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
    public GameState(GameState gs)
    {
        drawPile = gs.drawPile;
        discardPile = gs.discardPile;
        playerTurn = gs.playerTurn;
        bangsPlayed = gs.bangsPlayed;
        players = gs.players;
    }



    public String toString()
    {
        String string = "";
        for(Card c: drawPile) string += c .toString();
        for(Card c2: discardPile) string += c2.toString();
        for(PlayerInfo p: players) string += p.toString();
        string += "Current player turn: "+playerTurn+"\n";
        string += "BANGs played: "+bangsPlayed+"\n";
        return string;
       
    }
}
