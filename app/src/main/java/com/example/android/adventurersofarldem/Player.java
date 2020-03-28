package com.example.android.adventurersofarldem;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player implements CharacterInterface{

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
    public List<Ability> spellList;
    public static int playerGold;
    public static Player INSTANCE;

    public Player(String n, String pClass, int st, int ag, int in, int maxHP, int maxMP, int currentHP, int currentMP, int ac, int pXP, int level) {
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
        playerClass = pClass;
    }


    public void setSpellList(Ability spell1, Ability spell2, Ability spell3, Ability spell4){
        spellList = Arrays.asList(spell1, spell2, spell3, spell4);
    }

    public List<Ability> getSpellList() {
        return spellList;
    }

    public static void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public static void setClass(String pc) {
        playerClass = pc;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public static void setStrength(int st) {
        strength = st;
    }

    public int getStrength() {
        return strength;
    }


    public static void setAgility(int ag) {
        agility = ag;
    }

    public int getAgility() {
        return agility;
    }


    public static void setIntellect(int in) {
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

    @Override
    public int getExperience() {
        return 0;
    }

    @Override
    public void setExperience(int experience) {

    }

    public int getCurrentMana() {
        return currentMana;
    }

    @Override
    public void setArmorClass(int ac) {
        armorClass = ac;
    }

    @Override
    public int getBaseDamage() {
        return 0;
    }

    @Override
    public void setBaseDamage(int baseDamage) {

    }

    @Override
    public String getCharacterName() {
        return null;
    }

    @Override
    public void setCharacterName(String name) {

    }

    public int getArmorClass() {
        return armorClass;
    }

    public static void setPlayerExperience(int pXP) {
        playerXP = pXP;
    }

    public int getPlayerExperience() {
        return playerXP;
    }

    public static void setPlayerLevel(int level) {
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

    public static Player getInstance()
    {
        if (INSTANCE == null) {
            INSTANCE = new Player(name,playerClass, strength, agility,intellect, maximumHealth,maximumMana, currentHealth, currentMana, armorClass, playerXP, playerLevel);
        }
        return INSTANCE;
    }

    public int determineMod(){
        int playerMod = 0;
        if (Player.getInstance().getPlayerClass().equals("Wizard")) {
            playerMod = ((Player.getInstance().getIntellect() / 2) - 5);
        }
            else if (Player.getInstance().getPlayerClass().equals("Warrior")){
                playerMod = ((Player.getInstance().getStrength() / 2) - 5);
            }
            else if (Player.getInstance().getPlayerClass().equals("Ranger")){
                playerMod = ((Player.getInstance().getAgility() / 2) - 5);
        }

        return playerMod;
    }
}

