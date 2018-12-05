package com.example.android.adventurersofarldem;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dragon extends Monster {
    public Dragon() {
        super("Dragon", 18, 15, 1000, 100, 1000, 100, 500);
    }



    public String toString(){
        return "Dragon{" +
                "name='" + monsterName + '\'' +
                ", armor class= " + armorClass +
                ", base damage= " + baseDamage +
                ", maximumHealth=" + maximumHealth +
                ", maximumMana=" + maximumMana +
                ", currentHealth=" + currentHealth +
                ", currentMana=" + currentMana +
                '}';

    }

    public String dragonData(String monsterName, int armorClass, int baseDamage, int maximumHealth, int maximumMana, int currentHealth, int currentMana){
        String dragonData = "Dragon name is " + monsterName + ", \n Their AC is " + armorClass + "\n Their Base Damage is " + baseDamage;
        dragonData += "\n Their Max HP is " + maximumHealth + " and their current HP is " + currentHealth;
        dragonData += "\n Their Max MP is " + maximumMana + " and their current MP is " + currentMana;
        dragonData += "\n They are worth " + experience + " XP";
        return dragonData;
    }

    public int dragonStrength(){
        return getBaseDamage();
    }

    public int dragonHealth(){
    return  getCurrentHealth();
    }

    public int dragonExperience() {return getExperience();}
}