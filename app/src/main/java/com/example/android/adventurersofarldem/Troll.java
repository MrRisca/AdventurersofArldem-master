package com.example.android.adventurersofarldem;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Troll extends Monster {
    public Troll() {
        super("Troll", 15, 10, 70, 2, 70, 2, 30, 50, 1, 1, 1, 1, 1);
    }


    public String toString() {
        return "Troll{" +
                "name='" + characterName + '\'' +
                ", armor class= " + armorClass +
                ", base damage= " + baseDamage +
                ", maximumHealth=" + maximumHealth +
                ", maximumMana=" + maximumMana +
                ", currentHealth=" + currentHealth +
                ", currentMana=" + currentMana +
                '}';

    }


    public String getSpecialAttack() {
        return null;
    }


    public void setSpecialAttack() {

    }

    public String TrollData(String monsterName, int armorClass, int baseDamage, int maximumHealth, int maximumMana, int currentHealth, int currentMana) {
        String TrollData = "Troll name is " + monsterName + ", \n Their AC is " + armorClass + "\n Their Base Damage is " + baseDamage;
        TrollData += "\n Their Max HP is " + maximumHealth + " and their current HP is " + currentHealth;
        TrollData += "\n Their Max MP is " + maximumMana + " and their current MP is " + currentMana;
        TrollData += "\n They are worth " + experience + " XP";

        return TrollData;
    }

    public int TrollStrength() {
        return getBaseDamage();
    }

    public int TrollHealth() {
        return getCurrentHealth();
    }

    public int TrollExperience() {
        return getExperience();
    }
}