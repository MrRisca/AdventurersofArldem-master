package com.example.android.adventurersofarldem;


public interface PlayerInterface {


    //return the name of the human
    public String getName();

    //change the name of the human
    public void setName(String name);

    //get the strength of the player
    public int getStrength();

    public void setStrength(int strength);

    //return the agility of the player
    public int getAgility();


    public void setAgility(int agility);

    //return the intellect of the player
    public int getIntellect();


    public void setIntellect(int intellect);

    //return the max HP of the player
    public int getMaximumHealth();

    public void setMaximumHealth(int maximumHealth);

    //return the max MP of the player
    public int getMaximumMana();

    public void setMaximumMana(int maximumMana);

    //return the current HP of the player
    public int getCurrentHealth();

    public void setCurrentHealth(int currentHealth);

    //return the current MP of the player
    public int getCurrentMana();

    public void setCurrentMana(int currentMana);

    //return a string representation of the player
    public String toString();

}

