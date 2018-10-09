package com.example.davidvargas.bang_gamestate.objects;

import android.graphics.Paint;

import java.util.ArrayList;

public class PlayerInfo {

    protected int health;
    protected int maxHealth;
    protected RoleCard role;
    protected CharacterCard character;
    protected ArrayList<PlayableCard> activeCards;
    protected ArrayList<PlayableCard> cardsInHand;

    public PlayerInfo()
    {
        health = 4;
        maxHealth = 4;
        role = null; //maybe find a default role to change into?
        character = null; //default character too?
        activeCards = null; //filler/default cards in hand?
        cardsInHand = null;
    }

    public PlayerInfo(RoleCard role, CharacterCard character)
    {
        health = character.baseHealth;
        if(role.healthBonus)
        {
            health++;
        }

        maxHealth = health;
        this.role = role;
        this.character = character;
    }

    public int getHealth()
    {
        return health;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public RoleCard getRole()
    {
        return role;
    }

    public CharacterCard getCharacter()
    {
        return character;
    }

    public ArrayList<PlayableCard> getActiveCards()
    {
        return activeCards;
    }

    public ArrayList<PlayableCard> getCardsInHand()
    {
        return cardsInHand;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public void setMaxHealth(int health)
    {
        this.maxHealth = health;
    }

    public void setRole(RoleCard role)
    {
        this.role = role;
    }

    public void setCharacter(CharacterCard character)
    {
        this.character = character;
    }

    public void setActiveCards(ArrayList<PlayableCard> cards)
    {
        activeCards = cards;
    }

    public void setCardsInHand(ArrayList<PlayableCard> cards)
    {
        cardsInHand = cards;
    }



}
