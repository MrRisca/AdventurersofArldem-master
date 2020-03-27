package com.example.android.adventurersofarldem;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Player implements CharacterInterface{

    public static String name;
    public static String playerClass;
    public static int strength;
    public static int agility;
    public static int intellect;
    public static int maximumHealth;
    public static int maximumMana;
    public static int currentHealth;
    public static int currentMana;
    public static int armorClass;
    public static int playerXP;
    public static int playerLevel;
    public List<Attack> spellList;
    public static int playerGold;

    public Player(String n, int st, int ag, int in, int maxHP, int maxMP, int currentHP, int currentMP, int ac, int pXP, int level) {
        name = n;
        strength = st;
        agility = ag;
        intellect = in;
        maximumHealth = maxHP;
        maximumMana = maxMP;
        currentHealth = currentHP;
        currentMana = currentMP;
        armorClass = ac;
        playerXP = pXP;
        playerLevel = level;
    }


    public void setSpellList(Attack spell1, Attack spell2, Attack spell3, Attack spell4){
        spellList = Arrays.asList(spell1, spell2, spell3, spell4);
    }

    public List<Attack> getSpellList() {
        return spellList;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setStrength(int st) {
        strength = st;
    }

    public int getStrength() {
        return strength;
    }


    public void setAgility(int ag) {
        agility = ag;
    }

    public int getAgility() {
        return agility;
    }


    public void setIntellect(int in) {
        intellect = in;
    }

    public int getIntellect() {
        return intellect;
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

    @Override
    public void setArmorClass(int ac) {
        armorClass = ac;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setPlayerExperience(int pXP) {
        playerXP = pXP;
    }

    public int getPlayerExperience() {
        return playerXP;
    }

    public void setPlayerLevel(int level) {
        playerLevel = level;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerGold(int gold) {
        playerGold = gold;
    }
    public int getPlayerGold() {
        return playerGold;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intellect=" + intellect +
                ", maximumHealth=" + maximumHealth +
                ", maximumMana=" + maximumMana +
                ", currentHealth=" + currentHealth +
                ", currentMana=" + currentMana +
                '}';
    }
}

