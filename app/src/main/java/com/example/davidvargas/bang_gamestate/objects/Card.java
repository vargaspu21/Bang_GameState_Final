package com.example.davidvargas.bang_gamestate.objects;

public class Card {
    protected String name, description;

    public Card()
    {
        name = null;
        description = null;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String toString()
    {
        return "Name of Card: "+name+"\n"+"Description of Card: "+description+"\n";
    }
}
