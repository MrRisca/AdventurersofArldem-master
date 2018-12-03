package com.example.android.adventurersofarldem;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Goblin extends Monster {
    public Goblin() {
    //public Goblin(String n, int ac, int bd, int maxHP, int maxMP, int currentHP, int currentMP, int xp) {
        super("Bob", 12, 8, 15, 10, 15, 10, 10);
    }



    public String toString(){
        return "Goblin{" +
                "name='" + monsterName + '\'' +
                ", armor class= " + armorClass +
                ", base damage= " + baseDamage +
                ", maximumHealth=" + maximumHealth +
                ", maximumMana=" + maximumMana +
                ", currentHealth=" + currentHealth +
                ", currentMana=" + currentMana +
                '}';

    }



    public String GoblinData(String monsterName, int armorClass, int baseDamage, int maximumHealth, int maximumMana, int currentHealth, int currentMana){
        String GoblinData = "Goblin name is " + monsterName + ", \n Their AC is " + armorClass + "\n Their Base Damage is " + baseDamage;
        GoblinData += "\n Their Max HP is " + maximumHealth + " and their current HP is " + currentHealth;
        GoblinData += "\n Their Max MP is " + maximumMana + " and their current MP is " + currentMana;
        GoblinData += "\n They are worth " + experience + " XP";

        return GoblinData;
    }

    public int GoblinStrength(){
        return getBaseDamage();
    }

    public int GoblinHealth(){
        return  getCurrentHealth();
    }

    public int GoblinExperience(){
        return getExperience();}
}