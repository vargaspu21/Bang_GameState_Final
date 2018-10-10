package com.example.davidvargas.bang_gamestate.objects;

public class RoleCard extends Card {

    int role; //0: Sheriff, 1: Outlaw, 2: Renegade

    //constructor:
    public RoleCard(int roleNum)
    {
        role = roleNum;
    }

    //setter method for role
    public void setRole(int roleNum)
    {
        role = roleNum;
    }

    //getter method for role
    public int getRole()
    {
        return role;
    }

    //toString method:
    public String toString()
    {
        //convert role number to string role:
        if(role == 0) return "The role is a Sheriff\n";
        else if(role == 1) return "The role is an Outlaw\n";
        else return "The role is a Renegade\n";

    }
}
