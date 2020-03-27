package com.example.android.adventurersofarldem;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Troll extends Monster {
    public Troll() {
        super("Troll", 15, 10, 70, 2, 70, 2, 30, 50, "Bleed");
    }


    public String toString() {
        return "Troll{" +
                "name='" + monsterName + '\'' +
                ", armor class= " + armorClass +
                ", base damage= " + baseDamage +
                ", maximumHealth=" + maximumHealth +
                ", maximumMana=" + maximumMana +
                ", currentHealth=" + currentHealth +
                ", currentMana=" + currentMana +
                '}';

    }

    @Override
    public String getSpecialAttack() {
        return null;
    }

    @Override
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