package com.example.davidvargas.bang_gamestate.objects;

public class Card {
    //initializes variables:
    protected String name, description;

    //constructor for Card object
    public Card()
    {
        name = null;
        description = null;
    }

    //copy constructor for Card object:
    public Card(Card c){
        name = c.name;
        description = c.description;
    }

    //setter method for card name
    public void setName(String name)
    {
        this.name = name;
    }

    //setter method for card description
    public void setDescription(String description)
    {
        this.description = description;
    }

    //getter method for card name
    public String getName()
    {
        return name;
    }

    //getter method for card description
    public String getDescription()
    {
        return description;
    }

    //toStriing method:
    public String toString()
    {
        return "Name of Card: "+name+"\n"+"Description: "+description+"\n";
    }
}
