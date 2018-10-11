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

    //method for different play cards
    public boolean playCard()
    {
        switch(cardNum)
        {
            case 0: //bang
                //call bang action
                //return if succesful or not
                //remove card from hand
                break;

            case 1: //beer
                //call beer action
                //""
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            case 7:
                break;

            case 8:
                break;

            case 9:
                break;

            case 10:
                break;

            case 11:
                break;

            case 12:
                break;

            case 13:
                break;

            case 14:
                break;

            case 15:
                break;

            case 16:
                break;

            case 17:
                break;

            case 18:
                break;

            case 19:
                break;

            case 20:
                break;
            default:
                return false;
        }
        return false;
    }

    //toString method:
    public String toString()
    {
        return super.toString() + "Card number: "+cardNum+"\n"+"Is card active: "+String.valueOf(isActive)+"\n";
    }
}
