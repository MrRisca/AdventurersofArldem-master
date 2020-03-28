package com.example.android.adventurersofarldem;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Djinni extends Monster {
    public Djinni() {
        super("Djinni", 15, 10, 30, 20, 30, 20, 40, 50, 1, 1, 1, 1, 1);
    }


    public String toString() {
        return "Djinni{" +
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

    public String DjinniData(String monsterName, int armorClass, int baseDamage, int maximumHealth, int maximumMana, int currentHealth, int currentMana) {
        String DjinniData = "Djinni name is " + monsterName + ", \n Their AC is " + armorClass + "\n Their Base Damage is " + baseDamage;
        DjinniData += "\n Their Max HP is " + maximumHealth + " and their current HP is " + currentHealth;
        DjinniData += "\n Their Max MP is " + maximumMana + " and their current MP is " + currentMana;
        DjinniData += "\n They are worth " + experience + " XP";

        return DjinniData;
    }

    public int DjinniStrength() {
        return getBaseDamage();
    }

    public int DjinniHealth() {
        return getCurrentHealth();
    }

    public int DjinniExperience() {
        return getExperience();
    }
}