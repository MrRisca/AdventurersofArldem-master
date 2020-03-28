package com.example.android.adventurersofarldem;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Mummy extends Monster {
    public Mummy() {
        super("Mummy", 15, 8, 30, 20, 30, 20, 20, 40, 1, 1, 1, 1, 1);
    }


    public String toString() {
        return "Mummy{" +
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

    public String MummyData(String monsterName, int armorClass, int baseDamage, int maximumHealth, int maximumMana, int currentHealth, int currentMana) {
        String MummyData = "Mummy name is " + monsterName + ", \n Their AC is " + armorClass + "\n Their Base Damage is " + baseDamage;
        MummyData += "\n Their Max HP is " + maximumHealth + " and their current HP is " + currentHealth;
        MummyData += "\n Their Max MP is " + maximumMana + " and their current MP is " + currentMana;
        MummyData += "\n They are worth " + experience + " XP";

        return MummyData;
    }

    public int MummyStrength() {
        return getBaseDamage();
    }

    public int MummyHealth() {
        return getCurrentHealth();
    }

    public int MummyExperience() {
        return getExperience();
    }
}