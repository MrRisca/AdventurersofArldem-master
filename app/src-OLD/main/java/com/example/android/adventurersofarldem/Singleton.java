package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Singleton extends AppCompatActivity
{

    // static variable single_instance of type Singleton
    public static Singleton INSTANCE;

    // variable of type String

        public String s;

    // private constructor restricted to this class itself
    private Singleton()
    {
        String s;
    }

    // static method to create instance of Singleton class
    public static Singleton getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new Singleton();

        return INSTANCE;
    }

    public String receivePlayerData(String playerName, String playerClass, int playerStrength, int playerAgility, int playerIntellect, int playerMaxHP, int playerMaxMP, int playerCurrentHP, int playerCurrentMP){
        String playerData = "Player name is " + playerName + ", who is playing the " + playerClass + " class" + "\n Their Strength is " + playerStrength + "\n Their Agility is " + playerAgility;
        playerData += "\n Their Intellect is " + playerIntellect;
        playerData += "\n Their Max HP is " + playerMaxHP + " and their current HP is " + playerCurrentHP;
        playerData += "\n Their Max MP is " + playerMaxMP + " and their current MP is " + playerCurrentMP;
        return playerData;
    }
}
