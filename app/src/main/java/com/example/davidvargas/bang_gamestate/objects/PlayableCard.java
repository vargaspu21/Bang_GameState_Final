package com.example.davidvargas.bang_gamestate.objects;

public class PlayableCard extends Card {

    private boolean isActive; //?not sure what this is...
    private int cardNum; //identify effect come switch case

    public PlayableCard()
    {
        isActive = false;
        cardNum = 0;
    }

    public PlayableCard(boolean blue, int num)
    {
        isActive = blue;
        cardNum = num;
    }

    public boolean getActive()
    {
        return isActive;
    }

    public int getCardNum()
    {
        return cardNum;
    }

    public void playCard()
    {
        switch(cardNum)
        {
            case 0:
                break;

            case 1:
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
        }
    }
}
