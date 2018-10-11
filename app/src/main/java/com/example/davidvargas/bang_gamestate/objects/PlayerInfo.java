package com.example.davidvargas.bang_gamestate.objects;

import android.graphics.Paint;

import java.util.ArrayList;

public class PlayerInfo {

    public int health;
    protected int maxHealth;
    protected RoleCard role;
    protected CharacterCard character;
    protected ArrayList<PlayableCard> activeCards;
    protected ArrayList<PlayableCard> cardsInHand;

    public PlayerInfo()
    {
        health = 4;
        maxHealth = 4;
        role = new RoleCard(0); //maybe find a default role to change into?
        character = new CharacterCard(); //default character too?
        activeCards = new ArrayList<PlayableCard>(); //filler/default cards in hand?
        cardsInHand = new ArrayList<PlayableCard>();
    }

    public PlayerInfo(RoleCard role, CharacterCard character)
    {
        health = character.baseHealth; //gets the player health from the character card
        if(role.getRole()==0) health++; //if the role is sheriff, add one more life point
        maxHealth = health; //sets the max health to the starting health
        this.role = role; //declares the role of this player to that passed in
        this.character = character; //declares the character of this player to that passed in
    }

    //copy constructor for Player Info:
    public PlayerInfo(PlayerInfo pi)
    {
        this.health = pi.health;
        this.maxHealth = pi.maxHealth;
        this.role = pi.role;
        this.character = pi.character;
        //following lines creates a copy for each of the cards in the different array lists:
        activeCards = new ArrayList<PlayableCard>();
        for(PlayableCard c: pi.activeCards) this.activeCards.add(c);
        cardsInHand = new ArrayList<PlayableCard>();
        for(PlayableCard c: pi.cardsInHand) this.cardsInHand.add(c);


    }

    public int getHealth()
    {
        return health;
    } //getter method for the player's health

    public int getMaxHealth()
    {
        return maxHealth;
    } //getter method for the player's max health

    public RoleCard getRole()
    {
        return role;
    } //getter method for the player's max health

    public CharacterCard getCharacter() { return character; } //getter method for the player's character

    public ArrayList<PlayableCard> getActiveCards() { return activeCards; } //getter method for "active" blue cards

    public ArrayList<PlayableCard> getCardsInHand() { return cardsInHand; } //getter method for player's hand

    public void setHealth(int health)
    {
        this.health = health;
    } //setter method for player's health'

    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; } //setter method for player's max health'

    public void setRole(RoleCard role)
    {
        this.role = role;
    } //setter method for player's role'

    public void setCharacter(CharacterCard character) { this.character = character; } //setter method for player's character

    public void setActiveCards(PlayableCard c)
    {
        activeCards.add(c);
    } //setter method for list of player's active blue cards

    public void setCardsInHand(PlayableCard c)
    {
        cardsInHand.add(c);
    } //setter method for list of player's hand

    //toString method for Player's Information:
    public String toString()
    {
        String s = "\t\tPlayer:\n";
        s+= "Active Cards:\n";
        for(PlayableCard p: activeCards) s+=p.toString(); //concatenates strings of active cards
        s+= "Cards in hand:\n";
        for(PlayableCard p: cardsInHand) s+=p.toString(); //concatenates strings of cards in hand
        s+= "Health: "+health+"\n"+"Max Health: "+maxHealth+"\n"; //concatenates health and max health strings
        s+= "Role:\n"+role.toString() +"Character:\n"+ character.toString(); //concatenates role and character strings
        return s;

    }

}
