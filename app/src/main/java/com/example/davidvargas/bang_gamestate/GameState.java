package com.example.davidvargas.bang_gamestate;

import com.example.davidvargas.bang_gamestate.objects.Card;
import com.example.davidvargas.bang_gamestate.objects.PlayableCard;
import com.example.davidvargas.bang_gamestate.objects.PlayerInfo;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class GameState {

    //initializes variables:
    protected ArrayList <Card> drawPile;
    protected ArrayList <Card> discardPile;
    protected int playerTurn, bangsPlayed;
    protected PlayerInfo [] players;
    public static Random rand = new Random ();

    //constructor for GameState:
    public GameState ()
    {
        drawPile = new ArrayList<Card>();
        discardPile = new ArrayList<Card>();
        players = new PlayerInfo[4];
        playerTurn = 0;
        bangsPlayed = 0;
        rand.setSeed(System.currentTimeMillis());
        shuffle();
    }

    //a copy constructor:
    public GameState(GameState gs)
    {
        //creates a deep copy of each card in the array list:
        drawPile = new ArrayList<Card>();
        for(Card c: gs.drawPile) this.drawPile.add(c);
        //creates a deep copy of each card in the array list:
        discardPile = new ArrayList<Card>();
        for(Card c: gs.discardPile) this.discardPile.add(c);
        ////creates a deep copy of each card in the array:
        players = new PlayerInfo[4];
        for(int i = 0; i< players.length; i++) this.players[i]= gs.players[i];

        this.playerTurn = gs.playerTurn;
        this.bangsPlayed = gs.bangsPlayed;
    }

    public boolean drawTwo(int player)//draws two cards; player number as identifier
    {
        Random rng = new Random();
        players[player].setActiveCards(new PlayableCard(false,rng.nextInt(1)));//random card; for now, either bang or beer
        players[player].setActiveCards(new PlayableCard(false,rng.nextInt(1)));//^
        return true;
    }

    public boolean endTurn(int player)//ends the turn, determines next player
    {
        if(playerTurn != 4) playerTurn ++;
        else playerTurn = 1;
        return true;
    }

    //public boolean useAbility(int player, Ability) //not used yet
    {
        //return false;
    }

    public boolean examineCard(Card card)//prints out card description
    {
        System.out.println(card.toString());//for now;prototype
        return true;
    }

    public void quitGame()
    {
        System.exit(0);//exists program, for now;prototype
    }

    public boolean discardCard(Card card,int player)
    {
        if (players[player].getCardsInHand().contains(card))
        {
            players[player].getCardsInHand().remove(card);//delete an instance of card if exists
            discardPile.add(card);//adds card into discard pile
            return true;
        }
        else
        {
            return false;
        }
    }



    //BANG card function:
    public boolean playBANG(int attacker, int target)
    {
        if(bangsPlayed > 1) return false; //checks that player has not previously played BANG card
        if(!(players[attacker].getActiveCards().contains(0))) return false; //checks that player has BANG card in hand
        players[attacker].setHealth(players[target].health -1); //decreases health of target player
        bangsPlayed++; //increases the count of bangsPlayed by 1

        return true; //returns true, showing that the move was successful
    }

    //Beer card function:
    public boolean playBeer(int player)
    {
        //This card lets a player regain one life point - slide the card so that one more bullet is shown.
        // A player cannot gain more life points than his starting amount! The Beer cards cannot be used to help other players.
        if(players[player].health > players[player].getMaxHealth()) return false; //checks that user does not surpass the max health
        if(!(players[player].getActiveCards().contains(1))) return false; //checks that player has beer card in hand
        players[player].setHealth(players[player].getHealth()+1); //adds one life point to user

        return true; //returns true, showing that the move was successful
    }

    //toString method:
    public String toString()
    {
        String string = "Draw pile:\n";
        for(Card c: drawPile) string += c .toString(); //concatenates strings of the draw pile
        string += "Discard pile:\n";
        for(Card c: discardPile) string += c.toString(); //concatenates strings of the discard pile
        string += "Players:\n";
        for(PlayerInfo p: players) string += p.toString(); //concatenates strings of players
        string += "Current player turn: "+playerTurn+"\n"; ///concatenates player turn
        string += "BANGs played: "+bangsPlayed+"\n"; //concatenates current BANGs played
        return string;

    }

    //shuffle method for the drawPile
    public void shuffle()
    {
        Collections.shuffle(drawPile, rand);

    }

    //playing a card
    public boolean playFromHandAction(int player, PlayableCard c)
    {
        if(!(players[player].getCardsInHand().contains(c))) return false;
        if(c.getIsActive())
        {
            //run code for blue cards
            if(players[player].getActiveCards().contains(c)) return false;
            else
            {
                players[player].setActiveCards(c);
                players[player].getCardsInHand().remove(c);
                if(playerTurn != 4) playerTurn ++;
                else playerTurn = 1;
                return true;
            }
        }
        else {
            c.playCard();
            players[player].getCardsInHand().remove(c);
            if(playerTurn != 4) playerTurn ++;
            else playerTurn = 1;
            return true;
        }
    }

}
