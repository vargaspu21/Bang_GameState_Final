package com.example.davidvargas.bang_gamestate.objects;

public class PlayableCard extends Card {

    //initializes variables:
    private boolean isActive; //determines if the card is currently an active blue card
    private int cardNum; //identify effect come switch case

    //constructor
    public PlayableCard()
    {
        isActive = false;
        cardNum = 0;
    }

    //copy constructor for PlayableCard object
    public PlayableCard(PlayableCard p){
        isActive = p.isActive;
        cardNum = p.cardNum;
    }
    //constructor that passes in both parameters
    public PlayableCard(boolean isActive, int cardNum)
    {
        this.isActive = isActive;
        this.cardNum = cardNum;
    }

    //getter method for if card is active
    public boolean getIsActive()
    {
        return isActive;
    }

    //getter method for card number
    public int getCardNum()
    {
        return cardNum;
    }

    //toString method:
    public String toString()
    {
        return super.toString() + "Card number: "+cardNum+"\n"+"Is card active: "+String.valueOf(isActive)+"\n";
    }
}
