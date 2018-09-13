package com.example.android.adventurersofarldem;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


abstract class Player implements PlayerInterface{

    public String name;
    public int strength;
    public int agility;
    public int intellect;
    public int maximumHealth;
    public int maximumMana;
    public int currentHealth;
    public int currentMana;

    public Player(String n, int st, int ag, int in, int maxHP, int maxMP, int currentHP, int currentMP) {
        name = n;
        strength = st;
        agility = ag;
        intellect = in;
        maximumHealth = maxHP;
        maximumMana = maxMP;
        currentHealth = currentHP;
        currentMana = currentMP;
    }




    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setStrength(int st) {
        strength = st;
    }

    public int getStrength() {
        return strength;
    }


    public void setAgility(int ag) {
        agility = ag;
    }

    public int getAgility() {
        return agility;
    }


    public void setIntellect(int in) {
        intellect = in;
    }

    public int getIntellect() {
        return intellect;
    }


    public void setMaximumHealth(int maxHP) {
        maximumHealth = maxHP;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }


    public void setMaximumMana(int maxMP) {
        maximumMana = maxMP;
    }

    public int getMaximumMana() {
        return maximumMana;
    }

    public void setCurrentHealth(int currentHP) {
        currentHealth = currentHP;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentMana(int currentMP) {
        currentMana = currentMP;
    }

    public int getCurrentMana() {
        return currentMana;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intellect=" + intellect +
                ", maximumHealth=" + maximumHealth +
                ", maximumMana=" + maximumMana +
                ", currentHealth=" + currentHealth +
                ", currentMana=" + currentMana +
                '}';
    }
}

