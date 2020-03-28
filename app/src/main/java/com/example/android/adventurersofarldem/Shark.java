package com.example.android.adventurersofarldem;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Shark extends Monster {
    public Shark() {
        super("Shark", 15, 10, 40, 2, 40, 2, 30, 50, 1, 1, 1, 1, 1);
    }


    public String toString() {
        return "Shark{" +
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

    public String SharkData(String monsterName, int armorClass, int baseDamage, int maximumHealth, int maximumMana, int currentHealth, int currentMana) {
        String SharkData = "Shark name is " + monsterName + ", \n Their AC is " + armorClass + "\n Their Base Damage is " + baseDamage;
        SharkData += "\n Their Max HP is " + maximumHealth + " and their current HP is " + currentHealth;
        SharkData += "\n Their Max MP is " + maximumMana + " and their current MP is " + currentMana;
        SharkData += "\n They are worth " + experience + " XP";

        return SharkData;
    }

    public int SharkStrength() {
        return getBaseDamage();
    }

    public int SharkHealth() {
        return getCurrentHealth();
    }

    public int SharkExperience() {
        return getExperience();
    }
}