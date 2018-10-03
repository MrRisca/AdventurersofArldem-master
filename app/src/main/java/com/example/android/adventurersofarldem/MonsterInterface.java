package com.example.android.adventurersofarldem;


public interface MonsterInterface {


    //return the name of the human
    public String getMonsterName();

    //change the name of the human
    public void setMonsterName(String name);

    //get the strength of the player
    public int getArmorClass();

    public void setArmorClass(int armorClass);

    //return the agility of the player
    public int getBaseDamage();


    public void setBaseDamage(int baseDamage);

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

    public int getExperience();

    public void setExperience(int experience);

    //return a string representation of the player
    public String toString();

}


