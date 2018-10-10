package com.example.davidvargas.bang_gamestate.objects;

public class CharacterCard extends Card {

    //Ability power; //keep this for later?
    int baseHealth;

    public CharacterCard()
    {
        int baseHealth = 4;
    }

    public CharacterCard(int health)
    {
        baseHealth = health;
    }

    //add getAbility later?

    //add setAbility later?

    public int getBaseHealth()
    {
        return baseHealth;
    }

    public void setBaseHealth(int health)
    {
        baseHealth = health;
    }

}
