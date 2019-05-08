package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;


public class Singleton extends AppCompatActivity
{

    // static variable single_instance of type Singleton
    public static Singleton INSTANCE;
    public ArrayList<String> playerSpellList = null;



    // variable of type String

        public String s;

    // private constructor restricted to this class itself
    public Singleton()
    {
        String s;
        //playerSpellList = new ArrayList<>();
        playerSpellList = new ArrayList<>(Arrays.asList("Attack", "Heavy Attack", "Block", "Fireball"));
        String playerName;
        String playerClass;
        int playerStrength;
        int playerAgility;
        int playerIntellect;
        int playerMaxHP;
        int playerMaxMP;
        int playerCurrentHP;
        int playerCurrentMP;
        int playerAC;
        int playerExperience;
        int playerLevel;
        int playerGold;



    }

    // retrieve array from anywhere
    public ArrayList<String> getPlayerSpellList() {
        return this.playerSpellList;
    }
    //Add element to array
    public void addToPlayerSpellList(String value) {
        playerSpellList.add(value);
    }
    public void setPlayerSpellList(ArrayList<String> playerSpellList) {this.playerSpellList = playerSpellList;}



    // static method to create instance of Singleton class
    public static Singleton getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new Singleton();

        return INSTANCE;
    }






//     String[] playerSpellList = {"Attack", "Heavy Attack", "Block", "Fireball"};



    public String receivePlayerData(String playerName, String playerClass, int playerStrength, int playerAgility, int playerIntellect, int playerMaxHP, int playerMaxMP, int playerCurrentHP, int playerCurrentMP, int playerAC, int playerExperience, int playerLevel, int playerGold){
        String playerData = "Player name is " + playerName + ", who is playing the " + playerClass + " class" + "\n Their Strength is " + playerStrength + "\n Their Agility is " + playerAgility;
        playerData += "\n Their Intellect is " + playerIntellect;
        playerData += "\n Their Max HP is " + playerMaxHP + " and their current HP is " + playerCurrentHP;
        playerData += "\n Their Max MP is " + playerMaxMP + " and their current MP is " + playerCurrentMP;
        playerData += "\n Their Armor Class is " + playerAC;
        playerData += "\n Their current Experience is " + playerExperience;
        playerData += "\n Their level is " + playerLevel;
        playerData += "\n Their gold amount is " + playerGold;
        return playerData;
    }

}
