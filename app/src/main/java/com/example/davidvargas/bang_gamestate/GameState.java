package com.example.davidvargas.bang_gamestate;

import com.example.davidvargas.bang_gamestate.objects.Card;
import com.example.davidvargas.bang_gamestate.objects.PlayerInfo;

import java.util.ArrayList;

public class GameState extends Card{

    protected ArrayList <Card> drawPile;
    protected ArrayList <Card> discardPile;
    protected int playerTurn, bangsPlayed;
    protected PlayerInfo [] players;

    //stage of the game that it is in
    //info about the state of resources
    //info about the resources each player has
    //info about shared resources: game board, discard pile?


    //different class for playing a card
    //create a class that includes the different card objects?



    public GameState ()
    {
        drawPile = new ArrayList<>();
        discardPile = new ArrayList<>();
        players = new PlayerInfo[4];
        bangsPlayed = 0;
    }

    //implement a copy constructor
    public GameState(GameState gs)
    {

    }



    public String toString()
    {
        return "hello";
    }
}
