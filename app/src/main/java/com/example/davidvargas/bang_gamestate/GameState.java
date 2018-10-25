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
    //Character Card Constants
    public final int PAULREGRET = 0;
    public final int JOURDONNAIS = 1;
    public final int BLACKJACK = 2;
    public final int SLABTHEKILLER = 3;
    public final int ELGRINGO = 4;
    public final int JESSEJONES = 5;
    public final int SUZYLAFAYETTE = 6;
    public final int WILLYTHEKID = 7;
    public final int ROSEDOOLAN = 8;
    public final int BARTCASSIDY = 9;
    public final int PEDRORAMIREZ = 10;
    public final int SIDKETCHUM = 11;
    public final int LUCKYDUKE = 12;
    public final int VULTURESAM = 13;
    public final int CALAMITYJANET = 14;
    public final int KITCARLSON = 15;

    //Playable Card Constants
    public final int SCHOFIELD = 0;
    public final int REVCARBINE = 1;
    public final int WINCHESTER = 2;
    public final int VOLCANIC = 3;
    public final int REMINGTON = 4;
    public final int BANG = 5;
    public final int MISSED = 6;
    public final int BEER = 7;
    public final int PANIC = 8;
    public final int CATBALOU = 9;
    public final int STAGECOACH = 10;
    public final int WELLSCARGO = 11;
    public final int GATLING = 12;
    public final int DUEL = 13;
    public final int INDIANS = 14;
    public final int GENERALSTORE = 15;
    public final int SALOON = 16;
    public final int JAIL = 17;
    public final int DYNAMITE = 18;
    public final int BARREL = 19;
    public final int SCOPE = 20;
    public final int MUSTANG = 21;

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
        players = new PlayerInfo[4];//can fit four players max
        players[0] = new PlayerInfo();//four new players inserted
        players[1] = new PlayerInfo();
        players[2] = new PlayerInfo();
        players[3] = new PlayerInfo();
        playerTurn = 0;//current players turn
        bangsPlayed = 0;//prevents more than one bang card to be played per turn
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
        if(playerTurn != player)//if not their turn, leave
        {
            return false;
        }
        Random rng = new Random();
        players[player].setCardsInHand(new PlayableCard(false,rng.nextInt(1)));//random card; for now, either bang or beer
        players[player].setCardsInHand(new PlayableCard(false,rng.nextInt(1)));//^
        discardIntoDraw(this.discardPile);
        return true;
    }

    public boolean draw(int player)//for singledraw - added 10/21/18
    {
        if(playerTurn != player)
        {
            return false;
        }
        Random rng = new Random();
        players[player].setCardsInHand(new PlayableCard(false,rng.nextInt(1)));//random card; for now, either bang or beer
        return true;
    }

    public boolean endTurn(int player)//ends the turn, determines next player
    {
        if(playerTurn != 4) playerTurn ++;
        else playerTurn = 1;
        return true;
    }

    public boolean useAbility(int player, int ability) //added 10/21/18
    {
        if(playerTurn != player)
        {
            return false;
        }
        else
        {
            switch(ability) {
                case 0: //paul regret - +1 distance seen
                    players[player].setDistance(players[player].getDistance() + 1);
                    return true;

                case 1: //jourdonnais - if draw heart when BANG'd, MISS'd
                    draw(player);
                    //IMPLEMENT - check last card they drew

                case 2: //black jack - shows second card drawn, if heart or diamond, draws another card
                    drawTwo(player);
                    //IMPLEMENT - check second card drawn
                    draw(player); //draws additional card if if() triggers

                case 3: //slab the killer - other player needs 2 misses to cancel bang from him
                    //IMPLEMENT - will probably trigger this in the middle of battle

                case 4: //el gringo - anytime hit, draws card from player
                    //IMPLEMENT - will probably trigger right after taking damage

                case 5: //jesse jones - draw first card from selected players hand
                    //IMPLEMENT - will trigger in drawTwo

                case 6: //suzy lafayette - soon as there are no cards in hand, draws new one
                    if (players[player].getActiveCards().isEmpty()) {
                        draw(player);
                    }
                    return true;

                case 7: //willy the kid - can play any number of bangs
                    //IMPLEMENT - will trigger in battle

                case 8: //rose doolan - sees all players distance -1, PROBLEM - this sets this application to everyone, maybe add a distance to playerinfo instead?
                    if (player == 0) {
                        players[1].setDistance(-1);
                        players[2].setDistance(-1);
                        players[3].setDistance(-1);
                        return true;
                    } else if (player == 1) {
                        players[0].setDistance(-1);
                        players[2].setDistance(-1);
                        players[3].setDistance(-1);
                        return true;
                    } else if (player == 2) {
                        players[0].setDistance(-1);
                        players[1].setDistance(-1);
                        players[3].setDistance(-1);
                        return true;
                    } else if (player == 3) {
                        players[0].setDistance(-1);
                        players[1].setDistance(-1);
                        players[2].setDistance(-1);
                        return true;
                    } else {
                        return false;
                    }

                case 9: //bart cassidy - each time hit, draws a card
                    //IMPLEMENT - after damage taken in battle

                case 10: //pedro ramiree - draws first card from discard pile
                    //IMPLEMENT - during drawing phase

                case 11: //sid ketchum -  can discard 2 cards to regain one life
                    //IMPLEMENT - discard two cards
                    players[player].setHealth(players[player].getHealth()+1);
                    return true;

                case 12: //lucky duke - anytime draws, flips first two cards up and chooses one
                    //IMPLEMENT - new draw system for him

                case 13: //vulture sam - whenever player eliminated, take all their cards
                    //IMPLEMENT - when player health 0, activate

                case 14: //calamity janet - play bangs as miss and vice versa
                    //IMPLEMENT - during battle phase

                case 15: //kit carlson - looks at top three and draws two if drawTwo
                    //IMPLEMENT - during draw phase

                default:
                    return false;
            }
        }
    }

    public boolean playCard(int player, int cardNum)//will be the cases in playableCard; cases should be handled here because this is the main gamestate
    {
        if(playerTurn != player)
        {
            return false;
        }
        else
        {
            switch(cardNum)
            {
                case 0: //schofield, +2 range
                    //we can either do weapons like rose doolan character, or add a new int called range to playerinfo

                case 1: //rev carabine, +4 range

                case 2: //winchester, +5 range

                case 3: //volcanic, +1 range, play any number of bangs
                    //second effect apply during battle phase

                case 4: //remington, +3 range

                case 5: //bang
                    //put playBang fn in here

                case 6: //missed!
                    //cannot be used without replying to a bang
                    //can be implemented multiple ways, can have a separate fn
                    return false; //false for now?

                case 7: //beer, heals a health
                    //put playBeer fn in here

                case 8: //panic!
                    //player in 1 range gives up a card

                case 9: //cat balou
                    //one player discards a card

                case 10: //stagecoach
                    //draw two cards

                case 11: //wells fargo
                    //draw three cards

                case 12: //gatling
                    //all other players lose one health
                    //copy rose doolans effect
                    if (player == 0) {
                        players[1].setHealth(players[1].getHealth()-1);
                        players[2].setHealth(players[2].getHealth()-1);
                        players[3].setHealth(players[3].getHealth()-1);
                        return true;
                    } else if (player == 1) {
                        players[0].setHealth(players[0].getHealth()-1);
                        players[2].setHealth(players[2].getHealth()-1);
                        players[3].setHealth(players[3].getHealth()-1);
                        return true;
                    } else if (player == 2) {
                        players[0].setHealth(players[0].getHealth()-1);
                        players[1].setHealth(players[1].getHealth()-1);
                        players[3].setHealth(players[3].getHealth()-1);
                        return true;
                    } else if (player == 3) {
                        players[0].setHealth(players[0].getHealth()-1);
                        players[1].setHealth(players[1].getHealth()-1);
                        players[2].setHealth(players[2].getHealth()-1);
                        return true;
                    } else {
                        return false;
                    }

                case 13: //duel
                    //back-and-forth with selected player

                case 14: //indians, all players discard bang or lose a life
                    //automatic for now
                    //check players entire hands for a bang. discard if found. dont lose a life.

                case 15: //general store, reveal number of cards as players from deck, each choose one

                case 16: //saloon, player +2 health, others +1 health
                    if (player == 0) {
                        players[0].setHealth(players[0].getHealth()+2);
                        players[1].setHealth(players[1].getHealth()+1);
                        players[2].setHealth(players[2].getHealth()+1);
                        players[3].setHealth(players[3].getHealth()+1);
                        return true;
                    } else if (player == 1) {
                        players[0].setHealth(players[0].getHealth()+1);
                        players[1].setHealth(players[1].getHealth()+2);
                        players[2].setHealth(players[2].getHealth()+1);
                        players[3].setHealth(players[3].getHealth()+1);
                        return true;
                    } else if (player == 2) {
                        players[0].setHealth(players[0].getHealth()+1);
                        players[1].setHealth(players[1].getHealth()+1);
                        players[2].setHealth(players[2].getHealth()+2);
                        players[3].setHealth(players[3].getHealth()+1);
                        return true;
                    } else if (player == 3) {
                        players[0].setHealth(players[0].getHealth()+1);
                        players[1].setHealth(players[1].getHealth()+1);
                        players[2].setHealth(players[2].getHealth()+1);
                        players[3].setHealth(players[3].getHealth()+2);
                        return true;
                    } else {
                        return false;
                    }

                case 17: //jail

                case 18: //dynamite

                case 19: //barrel

                case 20: //scope, you see others -1 distance

                case 21: //mustang, people see you +1 distance

                default:
                    return false;

            }
        }
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
        for(PlayableCard p: players[attacker].getCardsInHand())//iterates through entire hand of player
        {
            if(p.getCardNum()==0)//if particular card is the cardnumber for bang, use it
            {
                players[target].setHealth(players[target].getHealth()-1); //decreases health of target player
                bangsPlayed++; //increases the count of bangsPlayed by 1

                return true; //returns true, showing that the move was successful
            }
        }
        return false;//after searching through entire hand, if bang card not found, exits

    }

    //Beer card function:
    public boolean playBeer(int player)
    {
        //This card lets a player regain one life point - slide the card so that one more bullet is shown.
        // A player cannot gain more life points than his starting amount! The Beer cards cannot be used to help other players.
        if(players[player].health >= players[player].getMaxHealth()) return false; //checks that user does not surpass the max health
        for(PlayableCard p: players[player].getCardsInHand())//iterates through entire players hand
        {
            if(p.getCardNum()==1)//if cardnum for beer, uses it
            {
                players[player].setHealth(players[player].getHealth()+1); //adds one life point to user
                return true; //returns true, showing that the move was successful
            }
        }
        return false;//else, returns false

    }

    //toString method:
    public String toString()
    {
        String string = "\tDraw pile:\n";
        for(Card c: drawPile) string += "\t\t" + c.toString(); //concatenates strings of the draw pile
        string += "\tDiscard pile:\n";
        for(Card c: discardPile) string += "\t\t" + c.toString(); //concatenates strings of the discard pile
        string += "\tPlayers:\n";
        for(PlayerInfo p: players) string += p.toString() + "\n"; //concatenates strings of players
        string += "\t\tCurrent player turn: "+playerTurn+"\n"; ///concatenates player turn
        string += "\t\tBANGs played: "+bangsPlayed+"\n"; //concatenates current BANGs played
        return string;

    }

    //shuffle method for the drawPile
    public void shuffle()
    {
        Collections.shuffle(drawPile, rand);//makes use of collections object to shuffle arraylist
    }

    //playing a card
    public boolean playFromHandAction(int player, PlayableCard c)
    {
        //check if the player has a card
        if(!(players[player].getCardsInHand().contains(c))) return false;
        //if this is a blue card
        if(c.getIsActive())
        {
            //check if its a duplicate card
            if(players[player].getActiveCards().contains(c)) return false;
            else
            {
                players[player].setActiveCards(c); //add card to active cards
                players[player].getCardsInHand().remove(c); //remove card from hand
                endTurn(player); //end turn
                return true;
            }
        }
        else { //if it is not a blue card
            c.playCard(); //play card using method from playable card class
            players[player].getCardsInHand().remove(c); //remove the card from players hand
            endTurn(player); //end turn
            return true;
        }
    }


    public void discardIntoDraw(ArrayList<Card> discardPile){
        if(this.drawPile.isEmpty()){
            for(Card c: discardPile){
                drawPile.add(c);
            }
        }
    }

}
