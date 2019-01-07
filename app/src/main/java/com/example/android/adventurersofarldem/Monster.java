package com.example.android.adventurersofarldem;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


abstract class Monster implements MonsterInterface{

    public String monsterName;
    public int armorClass;
    public int baseDamage;
    public int maximumHealth;
    public int maximumMana;
    public int currentHealth;
    public int currentMana;
    public int experience;
    public int gold;

    public Monster(String n, int ac, int bd, int maxHP, int maxMP, int currentHP, int currentMP, int xp, int gp) {
        monsterName = n;
        armorClass = ac;
        baseDamage = bd;
        maximumHealth = maxHP;
        maximumMana = maxMP;
        currentHealth = currentHP;
        currentMana = currentMP;
        experience = xp;
        gold = gp;
    }




    public void setMonsterName(String n) {
        monsterName = n;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setArmorClass(int ac) {
        armorClass = ac;
    }

    public int getArmorClass() {
        return armorClass;
    }


    public void setBaseDamage(int bd) {
        baseDamage = bd;
    }

    public int getBaseDamage() {
        return baseDamage;
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

    public void setExperience(int xp) {
        experience = xp;
    }

    public int getExperience() {
        return experience;
    }

    public void setGold(int gp) {
        gold = gp;
    }

    public int getGold() {
        return gold;
    }


    @Override
    public String toString() {
        return "Monster{" +
                "name='" + monsterName + '\'' +
                "Armor Class = " + armorClass +
                "Base Damage = " + baseDamage +
                ", maximumHealth=" + maximumHealth +
                ", maximumMana=" + maximumMana +
                ", currentHealth=" + currentHealth +
                ", currentMana=" + currentMana +
                '}';
    }
}

