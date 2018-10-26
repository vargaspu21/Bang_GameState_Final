package com.example.davidvargas.bang_gamestate;

import android.graphics.Paint;

import com.example.davidvargas.bang_gamestate.objects.Card;
import com.example.davidvargas.bang_gamestate.objects.PlayableCard;
import com.example.davidvargas.bang_gamestate.objects.PlayerInfo;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
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
    public final int WELLSFARGO = 11;
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

    //Amount of cards in starting deck constants
    public final int NUMSCHOFIELD = 3;
    public final int NUMVOLCANIC = 2;
    public final int NUMBANG = 25;
    public final int NUMMISSED = 12;
    public final int NUMBEER = 6;
    public final int NUMPANIC = 4;
    public final int NUMCATBALOU = 4;
    public final int NUMSTAGECOACH = 2;
    public final int NUMDUEL = 3;
    public final int NUMINDIANS = 2;
    public final int NUMGENERALSTORE = 2;
    public final int NUMJAIL = 3;
    public final int NUMBARREL = 2;
    public final int NUMMUSTANG = 2;

    //CConstants for roles
    public final int SHERIFF = 0;
    public final int OUTLAW  = 1;
    public final int RENEGADE = 2;

    //Constants for Suits
    /*
    Suits are not fully implemented yet however are big part of the game
    right now all cards will have a default suit of hearts, however in future this will
    have to be changed to allow for use of the Draw! mechanic.
     */
    public final int HEARTS = 0;
    public final int SPADES = 1;
    public final int CLUBS = 2;
    public final int DIAMONDS = 3;
    //initializes variables:
    protected ArrayList <PlayableCard> drawPile;
    protected ArrayList <PlayableCard> discardPile;
    protected int playerTurn, bangsPlayed;
    protected PlayerInfo [] players;
    public static Random rand = new Random ();

    //constructor for gameState, used to make a new one
    public GameState ()
    {
        drawPile = new ArrayList<PlayableCard>();
        drawPile = initDeck(drawPile);
        discardPile = new ArrayList<PlayableCard>();
        players = new PlayerInfo[4];//can fit four players max
        players[0] = new PlayerInfo(1);//four new players inserted
        players[1] = new PlayerInfo(2);
        players[2] = new PlayerInfo(3);
        players[3] = new PlayerInfo(4);
        playerTurn = 0;//current players turn
        bangsPlayed = 0;//prevents more than one bang card to be played per turn
        /*
         External Citation
         Date: 10 October 2018
         Problem: Did not know how to set seed of Random using the current time.
         Resource: Tribelhorn
         Solution: Assisted with writing this line of code.
         */
        rand.setSeed(System.currentTimeMillis());
    }

    //copy constructor - used to replicate two gameStates
    public GameState(GameState gs)
    {
        //creates a deep copy of each card in the array list:
        drawPile = new ArrayList<PlayableCard>();
        for(PlayableCard c: gs.drawPile) this.drawPile.add(new PlayableCard(c.getIsActive(),c.getCardNum()));
        //creates a deep copy of each card in the array list:
        discardPile = new ArrayList<PlayableCard>();
        for(PlayableCard c: gs.discardPile) this.discardPile.add(new PlayableCard(c.getIsActive(),c.getCardNum()));
        ////creates a deep copy of each card in the array:
        players = new PlayerInfo[4];
        for(int i = 0; i< players.length; i++) this.players[i] = gs.players[i];
        this.playerTurn = gs.playerTurn;
        this.bangsPlayed = gs.bangsPlayed;
    }

    //method to initialize deck: adds specific amount for each card through for loops, and it randomizes the deck
    private ArrayList<PlayableCard> initDeck(ArrayList<PlayableCard> deck)//adds all 80 cards of deck
    {
        //adds cards based on the Constant amounts (for-loops);

        int i;
        for(i=0; i<NUMSCHOFIELD; i++) deck.add(new PlayableCard(true, SCHOFIELD));
        deck.add(new PlayableCard(true, REVCARBINE));
        deck.add(new PlayableCard(true, WINCHESTER));
        for(i=0; i<NUMVOLCANIC; i++) deck.add(new PlayableCard(true, VOLCANIC));
        deck.add(new PlayableCard(true, REMINGTON));
        for(i=0; i<NUMBANG; i++) deck.add(new PlayableCard(false, BANG));
        for(i=0; i<NUMMISSED; i++) deck.add(new PlayableCard(false, MISSED));
        for(i=0; i<NUMBEER; i++) deck.add(new PlayableCard(false, BEER));
        for(i=0; i<NUMPANIC; i++) deck.add(new PlayableCard(false, PANIC));
        for(i=0; i<NUMCATBALOU; i++) deck.add(new PlayableCard(false, CATBALOU));
        for(i=0; i<NUMSTAGECOACH; i++) deck.add(new PlayableCard(false, STAGECOACH));
        deck.add(new PlayableCard(false, WELLSFARGO));
        deck.add(new PlayableCard(false, GATLING));
        for(i=0; i<NUMDUEL; i++) deck.add(new PlayableCard(false, DUEL));
        for(i=0; i<NUMINDIANS; i++) deck.add(new PlayableCard(false, INDIANS));
        for(i=0; i<NUMGENERALSTORE; i++) deck.add(new PlayableCard(false, GENERALSTORE));
        deck.add(new PlayableCard(false, SALOON));
        for(i=0; i<NUMJAIL; i++) deck.add(new PlayableCard (true, JAIL));
        deck.add(new PlayableCard(true, DYNAMITE));
        for(i=0; i<NUMBARREL; i++) deck.add(new PlayableCard(true, BARREL));
        deck.add(new PlayableCard(true, SCOPE));
        for(i=0; i<NUMMUSTANG; i++) deck.add(new PlayableCard(true, MUSTANG));
        shuffle();
        return deck;
    }

    //draws two cards, used for starting-turn draw ONLY!!!!
    public boolean drawTwo(int player)
    {
        if(playerTurn != player)//if not their turn, return
        {
            return false;
        }
        if(players[player].getHealth() <= 0)
        {
            for(int i = 0; i < 4; i++)
            {
                if(players[i].getCharacter().getCardNum() == VULTURESAM) {
                    for (PlayableCard p : players[player].getCardsInHand()) {
                        players[i].setCardsInHand(p);
                    }
                }
            }
        }
        for(PlayableCard p : players[player].getActiveCards())
        {
            if(p.getCardNum() == JAIL)
            {
                if(!drawExclamation(player, SPADES)) {
                    players[player].getActiveCards().remove(p);
                    discardPile.add(p);
                    playerTurn ++;
                    return true;
                }
                else
                {
                    players[player].getActiveCards().remove(p);
                    discardPile.add(p);
                }
            }
            if(p.getCardNum() == DYNAMITE) {
                if(drawExclamation(player, HEARTS))
                {
                    players[player].getActiveCards().remove(p);
                    discardPile.add(p);
                    players[player].setHealth(players[player].getHealth() - 3);
                    if(players[player].getHealth() <= 0)
                        return true;
                }
                else
                {
                    players[player].getActiveCards().remove(p);
                    if(player < 3)
                        players[player + 1].setActiveCards(new PlayableCard(true, DYNAMITE));
                    else if(player == 3)
                        players[0].setActiveCards(new PlayableCard(true, DYNAMITE));
                }
            }
        }
        if(players[player].getCharacter().getCardNum()==JESSEJONES) //if player is Jesse Jones, first card drawn is from a random player
        {
            if(player==0)
            {
                int toDrawFrom = rand.nextInt(3)+1;
                drawFromPlayer(player, toDrawFrom);
            }
            else if(player==1)
            {
                int[] drawArray = {0,2,3};
                int toDrawFrom = rand.nextInt(3);
                drawFromPlayer(player,drawArray[toDrawFrom]);
            }
            else if(player==2)
            {
                int[] drawArray = {0,1,3};
                int toDrawFrom = rand.nextInt(3);
                drawFromPlayer(player,drawArray[toDrawFrom]);
            }
            else if(player==3)
            {
                int toDrawFrom = rand.nextInt(3);
                drawFromPlayer(player,toDrawFrom);
            }
            else
            {
                return false;
            }
            draw(player);
            return true;
        }
        else if(players[player].getCharacter().getCardNum() == BLACKJACK) //if character is blackjack try to use their ability
        {
            /*
            Draws the first card then does a suit check for hearts or diamonds on second draw
            if it succeeds then draw a third card, else only two
            SUPPOSED TO REVEAL THE SECOND CARD THAT HE DRAWS BUT IDK HOW YET
             */
            draw(player);
            if(drawExclamation(player, HEARTS) || drawExclamation(player, DIAMONDS)){
                draw(player);
                draw(player);
                return true;
            }
            else {
                draw(player);
                return true;
            }

        }
        else
        {
            draw(player);//calls draw twice
            draw(player);
            return true;
        }
    }

    public boolean draw(int player)//for singledraw - added 10/21/18
    {
        if(playerTurn != player)
        {
            return false;
        }
        else
        {
            discardIntoDraw(drawPile);//checks if drawpile is empty. if it is, turns discardpile into drawpile
            PlayableCard toDraw = drawPile.get(0);//gets topmost card
            players[player].setCardsInHand(toDraw);//adds topmost card to player's hand
            drawPile.remove(toDraw);//deletes the first instance of the card from drawpile
            return true;
        }
    }

    public boolean drawFromDiscard(int player)
    {
        if(playerTurn != player)
        {
            return false;
        }
        else
        {
            if(discardPile.isEmpty())
            {
                return false;
            }
            PlayableCard toDraw = discardPile.get(0);//gets topmost card
            players[player].setCardsInHand(toDraw);//adds topmost card to player's hand
            discardPile.remove(toDraw);//deletes the first instance of the card from drawpile
            return true;
        }
    }

    public boolean drawFromPlayer(int player, int target)
    {
        int handSize = players[target].getCardsInHand().size();//gets size of opponents hand
        int indexToDraw = rand.nextInt(handSize);//randomly chooses card index to draw
        PlayableCard toDraw = players[target].getCardsInHand().get(indexToDraw);//records what that card is
        players[player].getCardsInHand().add(new PlayableCard(toDraw));//new instance of that card added to player, ASK TRIBELHORN ABOUT THIS??
        players[target].getCardsInHand().remove(toDraw);//removes the one from target
        return true;
    }

    public boolean endTurn(int player)//ends the turn, determines next player
    {
        bangsPlayed = 0;
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
                case PAULREGRET: //paul regret - +1 distance seen
                    /*
                    Implemented within the find distance method
                    COMPLETED
                     */
                    return true;

                case JOURDONNAIS: //jourdonnais - if draw heart when BANG'd, MISS'd
                    //Implement within the bang method
                    //IMPLEMENT - check last card they drew
                    //CHARACTER ABILITY SKIPPED DUE TO SUIT/NUMBER COMPLEXITY -
                    /*
                    Implemented within the bang method
                     */

                case BLACKJACK: //black jack - shows second card drawn, if heart or diamond, draws another card
                    //Implement within the draw two function, no functionality for showing card yet

                case SLABTHEKILLER: //slab the killer - other player needs 2 misses to cancel bang from him
                    //COMPLETED, happens during playBANG

                case ELGRINGO: //el gringo - anytime hit, draws card from player
                    //COMPLETED, happens during playBANG

                case JESSEJONES: //jesse jones - draw first card from selected players hand
                    //COMPLETED, happens during drawTwo

                case SUZYLAFAYETTE: //suzy lafayette - soon as there are no cards in hand, draws new one
                    if (players[player].getActiveCards().isEmpty())
                    {
                        draw(player);
                    }
                    return true;

                case WILLYTHEKID: //willy the kid - can play any number of bangs
                    //COMPLETED, happens during playBANG

                case ROSEDOOLAN: //rose doolan - sees all players distance -1, PROBLEM - this sets this application to everyone, maybe add a distance to playerinfo instead?
                   players[player].setRange(players[player].getRange() + 1);
                   return true;

                case BARTCASSIDY: //bart cassidy - each time hit, draws a card
                    //COMPLETED, found alongside ELGRINGO in playBANG

                case PEDRORAMIREZ: //pedro ramiree - draws first card from discard pile
                    //JOHNNY CURRENTLY DOING

                case SIDKETCHUM: //sid ketchum -  can discard 2 cards to regain one life
                    //IMPLEMENT - discard two cards
                    players[player].setHealth(players[player].getHealth()+1);
                    return true;

                case LUCKYDUKE: //lucky duke - anytime draws, flips first two cards up and chooses one
                    //IMPLEMENT - new draw system for him
                    //implemented in drawExclamation method
                    //simplified so if either the first two cards matches needed suit then he succeeds

                case VULTURESAM: //vulture sam - whenever player eliminated, take all their cards
                    //IMPLEMENT - when player health 0, activate
                    /*
                    Currently implementing in drawTwo method to check if the current player has 0 health, this could change in future
                     */
                case CALAMITYJANET: //calamity janet - play bangs as miss and vice versa
                    //IMPLEMENT - during battle phase
                    /*
                    implemented in playBang method.
                    Currently reduced function, will remove the first instance of either a bang of missed when using either
                    Will not work with gatling or Indians currently
                     */

                case KITCARLSON: //kit carlson - looks at top three and draws two if drawTwo
                    //IMPLEMENT - during draw phase
                    /*
                    Currently do not have a way to examine cards
                     */

                default:
                    return false;
            }
        }
    }

    public boolean playCard(int player, int target, int cardNum)//will be the cases in playableCard; cases should be handled here because this is the main gamestate
    {
        if(playerTurn != player)
        {
            return false;
        }
        else
        {
            switch(cardNum)
            {
                case SCHOFIELD: //schofield, +2 range
                    players[player].setRange( (players[player].getRange()) + 2);
                    return true;

                case REVCARBINE: //rev carabine, +4 range
                    players[player].setRange( (players[player].getRange()) + 4);
                    return true;
                case WINCHESTER: //winchester, +5 range
                    players[player].setRange( (players[player].getRange()) + 5);
                case VOLCANIC: //volcanic, +1 range, play any number of bangs
                    //second effect apply during battle phase
                    players[player].setRange( (players[player].getRange()) + 1);
                    return true;

                case REMINGTON: //remington, +3 range
                    players[player].setRange( (players[player].getRange()) + 3);
                    return true;
                case BANG: //bang
                    playBANG(player, target);
                    return true;

                case MISSED: //missed!, never used independently
                    //cannot be used without replying to a bang
                    //can be implemented multiple ways, can have a separate fn
                    return false; //false for now?

                case BEER: //beer, heals a health
                    playBeer(player);
                    return true;
                case PANIC: //panic!
                    //player in 1 range gives up a card
                    return playPanic(player, target);
                case CATBALOU: //cat balou
                    //one player discards a card
                    return playCatBalou(target);
                case STAGECOACH: //stagecoach
                    //draw two cards
                    draw(player);
                    draw(player);

                case WELLSFARGO: //wells fargo
                    //draw three cards
                    draw(player);
                    draw(player);
                    draw(player);
                    return true;

                case GATLING: //gatling
                    //all other players lose one health
                    //copy rose doolans effect
                    playGatling(player);
                    return true;

                case DUEL: //duel
                    //back-and-forth with selected player
                    playDuel(player, target);
                    return true;

                case INDIANS: //indians, all players discard bang or lose a life
                    //automatic for now
                    //check players entire hands for a bang. discard if found. dont lose a life.
                    playIndians(player);
                    return true;


                case GENERALSTORE: //general store, reveal number of cards as players from deck, each choose one

                case SALOON: //saloon, player +2 health, others +1 health
                    return playSaloon(player);

                case JAIL: //jail
                    return playActiveCard(player, target, cardNum);
                    //start of turn check for jail, if players has then skip turn
                    //implemented in drawTwo method as that signals start of turn
                case DYNAMITE: //dynamite
                    return playActiveCard(player, target, cardNum);
                    //start of turn draw! mechanic to determine if damage is taken.
                    //implemented in drawTwo function as that signals start of turn
                case BARREL: //barrel
                    return playActiveCard(player, player, cardNum);
                    //implemented in bang function,
                case SCOPE: //scope, you see others -1 distance
                    players[player].setRange(players[player].getRange()-1);
                    return playActiveCard(player, player, cardNum);

                case MUSTANG: //mustang, people see you +1 distance
                    return playActiveCard(player, player, cardNum);
                    //implemented in distance checker method
                default:
                    return false;

            }
        }
    }

    //method to play gatling card; called from playCard method; deals damage to everyone except attacker
    private boolean playGatling(int player)
    {
        //checks for the user and deals damage accordingly

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
    }

    //used when playing saloon card; called from playCard; heals everyone 1 health. heals the user an additional one health.
    private boolean playSaloon(int player)
    {
        //checks player and increases health accordingly;

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
    }

    public boolean examineCard(Card card) //prints out card description
    {
        System.out.println(card.toString());//for now: prototype
        return true;
    }

    //exists program, for now;prototype
    public void quitGame()
    {
        System.exit(0);
    }

    public boolean discardCard(PlayableCard card,int player)
    {
        if (players[player].getCardsInHand().contains(card))
        {
            players[player].getCardsInHand().remove(card);//delete an instance of card if exists
            discardPile.add(card);//adds card into discard pile
            return true;
        }
        else
        {
            return false; //default: return true;
        }
    }

    //method to determine the distance between players:
    private int distanceBetween(int attacker, int target){
        //if first player, distance is 1 for players 2 and 4, and is 2 for player 3
        int distance = 1;
        /*
        First checks if the target is Paul Regret if it is, then add one to distance
        Then checks if the target has a mustang, if player does then adds one to distance
        These abilities can stack
         */
        if(players[target].getCharacter().getCardNum() == PAULREGRET)
            distance ++;
        for(PlayableCard p : players[target].getActiveCards()) {
            if(p.getCardNum() == MUSTANG)
                distance ++;
        }
        if(attacker == 0 ){
            if(target == 1 || target == 3)
                return distance;
            else if(target ==2)
                return distance++;
            }
        //if second player, distance is 1 for players 3 and 1, and is 2 for player 4
        else if(attacker == 1){
            if(target == 2 || target == 0 )
                return distance;
            else if(target == 3)
                return distance++;
        }
        //if third player, distance is 1 for players 2 and 4, and is 2 for player 1
        else if(attacker == 2){
            if(target == 3 || target == 1 )
                return distance;
            else if(target == 0) {
                return distance++;
            }
        }
        //if fourth player, distance is 1 for players 3 and 1, and is 2 for player 2
        else if (attacker == 3){
            if(target == 0 || target == 2 )
                return distance;
            else if(target == 1)
                return distance++;
        }
        return 0; //default , return 0
    }


    //BANG card function:
    public boolean playBANG(int attacker, int target)//automatically uses the attacked player's missed card if found for now
    {
        if(bangsPlayed > 1) //if player has used a bang and player character is not Willy The Kid, return false
        {
            if(players[attacker].getCharacter().getCardNum()!=WILLYTHEKID)
            {
                return false;
            }
        }
        if (players[attacker].getRange() < distanceBetween(attacker, target)) return false;
        for(PlayableCard p: players[attacker].getCardsInHand())//iterates through entire hand of player
        {
            if(players[attacker].getCharacter().getCardNum() == CALAMITYJANET) { //checks if calamityjanets ability is applicable
                if (p.getCardNum() == BANG || p.getCardNum() == MISSED) {
                    bangsPlayed++; //increases the count of bangsPlayed by 1
                    players[attacker].getCardsInHand().remove(p);//removes bang card
                    discardPile.add(p);
                    for (PlayableCard r : players[target].getActiveCards()) //searches through targets blue cards for barrel
                    {
                        if (r.getCardNum() == BARREL) { //if they have a barrel try for miss
                            if (drawExclamation(target, SPADES)) //CHANGE TO HEARTS WHEN SUIT IS FULLY IMLPEMENTED
                            {
                                return true; //if the draw! is successful then it exits without the target taking damage
                            }
                        }
                        if(players[target].getCharacter().getCardNum() == JOURDONNAIS)
                        {
                            if(drawExclamation(target, SPADES)) //CHANGE TO HEARTS WHEN SUIT IS FULLY IMPLEMENTED
                            {
                                return true;
                            }
                        }
                    }
                    for (PlayableCard q : players[target].getCardsInHand()) {
                        if (q.getCardNum() == MISSED) {//if there exists a missed card in the attacked player's hand
                            players[target].getCardsInHand().remove(q);//check if it works - removes missed card if one exists in the attacked player
                            discardPile.add(q);
                            return true;
                            //SLAB THE KILLER disabled for now due to complexity
                            //if(!(players[attacker].getCharacter().getCardNum()==SLABTHEKILLER))
                            //{
                            //  return true;
                            //}
                        }
                    }
                }
            }
            if(p.getCardNum()== BANG)//if particular card is the cardnumber for bang, use it
            {
                bangsPlayed++; //increases the count of bangsPlayed by 1
                players[attacker].getCardsInHand().remove(p);//removes bang card
                discardPile.add(p);
                for(PlayableCard r : players[target].getActiveCards()) //searches through targets blue cards for barrel
                {
                    if(r.getCardNum() == BARREL) { //if
                        if(drawExclamation(target, SPADES)) //this should actually check for hearts but the default suit is hearts so i made it spades
                        {
                            return true; //if the draw! is successful then it exits without the target taking damage
                        }
                    }
                    if(players[target].getCharacter().getCardNum() == JOURDONNAIS)
                    {
                        if(drawExclamation(target, SPADES)) //CHANGE TO HEARTS WHEN SUIT IS FULLY IMPLEMENTED
                        {
                            return true;
                        }
                    }
                }
                for(PlayableCard q: players[target].getCardsInHand())
                {
                    if(players[target].getCharacter().getCardNum() == CALAMITYJANET)
                    {
                        if(q.getCardNum() == MISSED || q.getCardNum() == BANG)
                        {
                            players[target].getCardsInHand().remove(q);
                            discardPile.add(q);
                            return true;
                        }
                    }
                    if(q.getCardNum()== MISSED) {//if there exists a missed card in the attacked player's hand
                        players[target].getCardsInHand().remove(q);//check if it works - removes missed card if one exists in the attacked player
                        discardPile.add(q);
                        return true;
                        //SLAB THE KILLER disabled for now due to complexity
                        //if(!(players[attacker].getCharacter().getCardNum()==SLABTHEKILLER))
                        //{
                          //  return true;
                        //}
                    }
                }
                //else, no missed cards are found
                players[target].setHealth(players[target].getHealth()-1); //decreases health of target player

                //if target's character is El Gringo, takes card from the attacker
                if(players[target].getCharacter().getCardNum()==ELGRINGO)
                {
                    drawFromPlayer(target,attacker);
                }
                //if target's character is Bart Cassidy, draws a card from deck
                else if(players[target].getCharacter().getCardNum()==BARTCASSIDY)
                {
                    draw(target);
                }
                return true;
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
        //DRAWPILE CARDS ARE MOSTLY NULL! For now...
        String string = "\tDraw pile:\n";
        for(PlayableCard c: drawPile) string +=  c.toString(); //concatenates strings of the draw pile
        string += "\tDiscard pile:\n";
        for(PlayableCard c: discardPile) string += "\t\t" + c.toString(); //concatenates strings of the discard pile
        string += "\tPlayers:\n";
        for(PlayerInfo p: players) string += p.toString() + "\n"; //concatenates strings of players
        string += "\t\tCurrent player turn: "+playerTurn+"\n"; ///concatenates player turn
        string += "\t\tBANGs played: "+bangsPlayed+"\n"; //concatenates current BANGs played
        return string;

    }

    //shuffle method for the drawPile
    private void shuffle()
    {
        /*
         External Citation
         Date: 20 October 2018
         Problem: Did not know how to shuffle array list:
         Resource:
         https://stackoverflow.com/questions/16112515/how-to-shuffle-an-arraylist
         Solution: I used the example code from this post.
         */
        Collections.shuffle(drawPile, rand);//makes use of collections object to shuffle arraylist
    }

    //playing a card
    //for now this just removes the card from person playing its hand
    //as well as add it to the targets active cards
    public boolean playActiveCard(int player, int target, int card) {
        boolean flag = false;
        for(PlayableCard p : players[player].getCardsInHand()) { //checks to see if it is possible to play this card
            if(p.getCardNum() == card) { //checks players hand
                for(PlayableCard c : players[target].getActiveCards()) {
                    if(c.getCardNum() == card) { //checks targets Active cards
                        players[player].getCardsInHand().remove(p);
                        flag = true;
                    }
                }
            }
        }
        if(flag)
        {
            if(card == JAIL) {
                if(players[target].getRole().getRole() != SHERIFF) {
                    players[target].setActiveCards(new PlayableCard(true, JAIL));
                    return true;
                }
            }
            else if(card == BARREL) {
                players[target].setActiveCards(new PlayableCard(true,BARREL));
                return true;
            }
            else if(card == SCOPE) {
                players[target].setActiveCards(new PlayableCard(true, SCOPE));
                return true;
            }
            else if(card == MUSTANG) {
                players[target].setActiveCards(new PlayableCard(true, MUSTANG));
                return true;
            }
            else if(card == DYNAMITE) {
                players[target].setActiveCards(new PlayableCard(true, DYNAMITE));
                return true;
            }
        }
        return false;
    }


    //method to make new draw pile from discard pile:
    private boolean discardIntoDraw(ArrayList<PlayableCard> discardPile){
        if(this.drawPile.isEmpty()){ //if draw pile is empty, move discard pile cards to it
            for(PlayableCard c: discardPile){
                drawPile.add(c);
            }
            return true;
        }
        return false;
    }

    //method to play the Duel card:
    private boolean playDuel(int player, int target) {
        //initializes counts of bang cards in attacker's and target's hands to 0
        int targetCount = 0;
        int attackerCount = 0;

        //counts how many bangs are in attacker's and target's hands
        for (PlayableCard p : players[player].getCardsInHand()){
            if (p.getCardNum() == BANG) attackerCount++;
        }
        for (PlayableCard p : players[target].getCardsInHand()){
            if (p.getCardNum() == BANG) targetCount++;
        }

        if (attackerCount <= targetCount) //if attacker has less than or same amount BANGs as target, attacker loses
            players[player].setHealth(players[player].getHealth() - 1); //lose one health
        else players[target].setHealth(players[target].getHealth() - 1); //else if attacker has more BANGs than target, target loses one health

        return true;
    }

    //method to play Indians card
    private boolean playIndians(int player){
        //checks if the other players have BANGs in their hands, removes the first instance of it and returns:
        int booleanFlag = 0;
        if(player == 0){ //if player 1, checks players 4, 2, 3
            for(PlayableCard p: players[1].getCardsInHand()){
                if(p.getCardNum() == BANG){
                    players[1].getCardsInHand().remove(p);
                    booleanFlag = 1;
                    break;
                }
            }
            if(booleanFlag == 1) players[1].setHealth(players[1].getHealth() - 1);

            booleanFlag = 0;
            for(PlayableCard p: players[2].getCardsInHand()){
                if(p.getCardNum() == BANG){
                    players[2].getCardsInHand().remove(p);
                    booleanFlag = 1;
                    break;
                }
            }
            if(booleanFlag == 1) players[2].setHealth(players[2].getHealth() - 1);

            booleanFlag = 0;
            for(PlayableCard p: players[3].getCardsInHand()){
                if(p.getCardNum() == BANG){
                    players[3].getCardsInHand().remove(p);
                    booleanFlag = 1;
                    break;
                }
            }
            if(booleanFlag == 1) players[3].setHealth(players[3].getHealth() - 1);

        }

        else if(player == 1){ //if player 2, checks players 1, 3, 4
            booleanFlag = 0;
            for(PlayableCard p: players[2].getCardsInHand()){
                if(p.getCardNum() == BANG){
                    players[2].getCardsInHand().remove(p);
                    booleanFlag = 1;
                    break;
                }
            }
            if(booleanFlag == 1) players[2].setHealth(players[2].getHealth() - 1);

            booleanFlag = 0;
            for(PlayableCard p: players[3].getCardsInHand()){
                if(p.getCardNum() == BANG){
                    players[3].getCardsInHand().remove(p);
                    booleanFlag = 1;
                    break;
                }
            }
            if(booleanFlag == 1) players[3].setHealth(players[3].getHealth() - 1);

            booleanFlag = 0;
            for(PlayableCard p: players[0].getCardsInHand()){
                if(p.getCardNum() == BANG){
                    players[0].getCardsInHand().remove(p);
                    booleanFlag = 1;
                    break;
                }
            }
            if(booleanFlag == 1) players[0].setHealth(players[0].getHealth() - 1);

        }
        else if(player == 2){ //if player 3, checks players 1, 2, 4
            booleanFlag = 0;
            for(PlayableCard p: players[3].getCardsInHand()){
                if(p.getCardNum() == BANG){
                    players[3].getCardsInHand().remove(p);
                    booleanFlag = 1;
                    break;
                }
            }
            if(booleanFlag == 1) players[3].setHealth(players[3].getHealth() - 1);

            booleanFlag = 0;
            for(PlayableCard p: players[0].getCardsInHand()){
                if(p.getCardNum() == BANG){
                    players[0].getCardsInHand().remove(p);
                    booleanFlag =1;
                    break;
                }
            }
            if(booleanFlag == 1) players[0].setHealth(players[0].getHealth() - 1);

            booleanFlag = 0;
            for(PlayableCard p: players[1].getCardsInHand()){
                if(p.getCardNum() == BANG){
                    players[1].getCardsInHand().remove(p);
                    booleanFlag = 1;
                    break;
                }
            }
            if(booleanFlag == 1) players[1].setHealth(players[1].getHealth() - 1);
        }
        else if(player == 3){ //if player 4, checks players 1, 2, 3
            booleanFlag = 0;
            for(PlayableCard p: players[0].getCardsInHand()){
                if(p.getCardNum() == BANG){
                    players[0].getCardsInHand().remove(p);
                    booleanFlag = 1;
                    break;
                }
            }
            if(booleanFlag == 1) players[0].setHealth(players[0].getHealth() - 1);

            booleanFlag = 0;
            for(PlayableCard p: players[1].getCardsInHand()){
                if(p.getCardNum() == BANG){
                    players[1].getCardsInHand().remove(p);
                    booleanFlag = 1;
                    break;
                }
            }
            if(booleanFlag == 1) players[1].setHealth(players[1].getHealth() - 1);

            booleanFlag = 0;
            for(PlayableCard p: players[2].getCardsInHand()){
                if(p.getCardNum() == BANG){
                    players[2].getCardsInHand().remove(p);
                    booleanFlag = 1;
                    break;
                }
            }
            if(booleanFlag == 1) players[2].setHealth(players[2].getHealth() - 1);
        }
        return false; //default: returns false;
    }
    /*
    The following function uses the suits to make the draw mechanic work, right now
    suits are not fully implemented.
     */
    private boolean drawExclamation(int player, int suit)
    {
        if(players[player].getCharacter().getCardNum() == LUCKYDUKE)
        {
            if(drawPile.get(0).getSuit() == suit || drawPile.get(1).getSuit() == suit)
                return true;
        }
        if(drawPile.get(0).getSuit() == suit)
        {
            return true;
        }
        else return false;
    }
    private boolean playPanic(int player, int target)
    {
        if(distanceBetween(player, target) == 1)
        {
            drawFromPlayer(player, target);
            return true;
        }
        else return false;
    }
    /*target player discards a card,
    however currently the card is prechosen, this could be changed lated to allow for target to choose, or attacker to choose.
     */
    private boolean playCatBalou(int target)
    {

        players[target].getCardsInHand().remove(0); //removes the left most card in targets hand
        return true;
    }
}
