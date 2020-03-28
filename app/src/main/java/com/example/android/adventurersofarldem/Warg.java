package com.example.android.adventurersofarldem;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Warg extends Monster {
    public Warg() {
        super("Warg", 15, 20, 20, 10, 20, 10, 25, 35, 1, 1, 1, 1, 1);
    }


    public String toString() {
        return "Warg{" +
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

    public String WargData(String monsterName, int armorClass, int baseDamage, int maximumHealth, int maximumMana, int currentHealth, int currentMana) {
        String WargData = "Warg name is " + monsterName + ", \n Their AC is " + armorClass + "\n Their Base Damage is " + baseDamage;
        WargData += "\n Their Max HP is " + maximumHealth + " and their current HP is " + currentHealth;
        WargData += "\n Their Max MP is " + maximumMana + " and their current MP is " + currentMana;
        WargData += "\n They are worth " + experience + " XP";

        return WargData;
    }

    public int WargStrength() {
        return getBaseDamage();
    }

    public int WargHealth() {
        return getCurrentHealth();
    }

    public int WargExperience() {
        return getExperience();
    }
}