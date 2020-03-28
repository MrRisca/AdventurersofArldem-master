package com.example.android.adventurersofarldem;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Kraken extends Monster {
    public Kraken() {
        super("Kraken", 20, 15, 80, 10, 80, 10, 50, 100, 1, 1, 1, 1, 1);
    }


    public String toString() {
        return "Kraken{" +
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

    public String KrakenData(String monsterName, int armorClass, int baseDamage, int maximumHealth, int maximumMana, int currentHealth, int currentMana) {
        String KrakenData = "Kraken name is " + monsterName + ", \n Their AC is " + armorClass + "\n Their Base Damage is " + baseDamage;
        KrakenData += "\n Their Max HP is " + maximumHealth + " and their current HP is " + currentHealth;
        KrakenData += "\n Their Max MP is " + maximumMana + " and their current MP is " + currentMana;
        KrakenData += "\n They are worth " + experience + " XP";

        return KrakenData;
    }

    public int KrakenStrength() {
        return getBaseDamage();
    }

    public int KrakenHealth() {
        return getCurrentHealth();
    }

    public int KrakenExperience() {
        return getExperience();
    }
}