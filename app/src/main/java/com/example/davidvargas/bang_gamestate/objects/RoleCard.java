package com.example.davidvargas.bang_gamestate.objects;

public class RoleCard extends Card {

    protected boolean healthBonus, isVisible;

    public RoleCard()
    {
        healthBonus = false;
        isVisible = false;
    }

    public void setHealthBonus(boolean healthBonus)
    {
        this.healthBonus = healthBonus;
    }

    public void setIsVisible(boolean isVisible)
    {
        this.isVisible = isVisible;
    }

    public boolean getHealthBonus()
    {
        return healthBonus;
    }

    public boolean getIsVisible()
    {
        return isVisible;
    }


}
