package com.example.davidvargas.bang_gamestate.objects;

import java.util.ArrayList;

public class PlayerInfo {

    private int health;
    private int maxHealth;
    private RoleCard role;
    private CharacterCard character;
    private ArrayList<PlayableCard> activeCards;
    private ArrayList<PlayableCard> cardsInHand;

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
        this.role = role;
        this.character = character;
    }



}
