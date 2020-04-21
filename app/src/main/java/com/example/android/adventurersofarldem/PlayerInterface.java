package com.example.android.adventurersofarldem;


public interface PlayerInterface {


    //return the name of the human
    String getName();

    //change the name of the human
    void setName(String name);

    //get the strength of the player
    int getStrength();

    void setStrength(int strength);

    //return the agility of the player
    int getAgility();


    void setAgility(int agility);

    //return the intellect of the player
    int getIntellect();


    void setIntellect(int intellect);

    //return the max HP of the player
    int getMaximumHealth();

    void setMaximumHealth(int maximumHealth);

    //return the max MP of the player
    int getMaximumMana();

    void setMaximumMana(int maximumMana);

    //return the current HP of the player
    int getCurrentHealth();

    void setCurrentHealth(int currentHealth);

    //return the current MP of the player
    int getCurrentMana();

    void setCurrentMana(int currentMana);

    int getArmorClass();

    void setArmorClass(int armorClass);

    int getPlayerExperience();

    void setPlayerExperience(int playerExperience);

    int getPlayerLevel();

    void setPlayerLevel(int playerLevel);

    //return a string representation of the player
    String toString();

}

