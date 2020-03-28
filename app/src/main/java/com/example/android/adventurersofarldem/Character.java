package com.example.android.adventurersofarldem;

import java.util.Arrays;
import java.util.List;

public class Character {

    public String characterType;
    public int strength;
    public String characterName;
    public int armorClass;
    public int baseDamage;
    public int maximumHealth;
    public int maximumMana;
    public int currentHealth;
    public int currentMana;
    public int experience;
    public int gold;
    public List <StatusEffect> statusEffect;
    public int speed;
    public int agility;
    public int intellect;
    public int level;

    public Character(String n, int ac, int bd, int maxHP, int maxMP, int currentHP, int currentMP, int xp, int gp, int sp, int st, int ag, int in, int lvl) {
        characterName = n;
        armorClass = ac;
        baseDamage = bd;
        maximumHealth = maxHP;
        maximumMana = maxMP;
        currentHealth = currentHP;
        currentMana = currentMP;
        experience = xp;
        gold = gp;
        speed = sp;
        strength = st;
        agility = ag;
        intellect = in;
        level = lvl;
        
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
    
    public int attack(String target, String spell){
        int attackDamage = 0;

        return attackDamage;
    }


    public void setCharacterName(String n) {
        characterName = n;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterType(String type) {
        characterType = type;
    }

    public String getCharacterType() {
        return characterType;
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

    public void setSpeed(int sp) {
        speed = sp;
    }

    public int getSpeed() {
        return speed;
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

    public void setLevel(int lvl) {
        level = lvl;
    }

    public int getLevel() {
        return level;
    }

    public void addStatusEffect(StatusEffect effectName){
        statusEffect = Arrays.asList(effectName);

    }

    public List<StatusEffect> getStatusEffect() {
        return statusEffect;
    }


    public int determineMod(){
        int characterMod = 0;
        return characterMod;
    }


    @Override
    public String toString() {
        return "Character{" +
                "name='" + characterName + '\'' +
                "Armor Class = " + armorClass +
                "Base Damage = " + baseDamage +
                ", maximumHealth=" + maximumHealth +
                ", maximumMana=" + maximumMana +
                ", currentHealth=" + currentHealth +
                ", currentMana=" + currentMana +
                '}';
    }

}
