package com.example.android.adventurersofarldem;


public interface CharacterInterface {


    //return the name of the human
    String getCharacterName();

    //change the name of the human
    void setCharacterName(String name);

    //get the strength of the player
    int getArmorClass();

    void setArmorClass(int armorClass);

    //return the agility of the player
    int getBaseDamage();


    void setBaseDamage(int baseDamage);

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

    int getExperience();

    void setExperience(int experience);

    //return a string representation of the player
    String toString();



}


