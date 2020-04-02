package com.example.android.adventurersofarldem.Characters;


import com.example.android.adventurersofarldem.Abilities.Ability;
import com.example.android.adventurersofarldem.CharacterInterface;
import com.example.android.adventurersofarldem.Items.*;
import com.example.android.adventurersofarldem.StatusEffects.StatusEffect;

import java.util.Arrays;
import java.util.List;

public class Player extends Character implements CharacterInterface {

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
    public static int playerGold;
    public static Player INSTANCE;
    public static int baseDamage;
    public static int playerSpeed;
    public List<Ability> spellList;
    public static int posX;
    public static int posY;
    public Monster nextEnemy;
    public int availablePoints;
    private Item itemInSlotHead;
    private Item itemInSlotChest;
    private Item itemInSlotLegs;
    private Item itemInSlotHands;
    private Item itemInSlotFeet;
    private Item itemInSlotNeck;
    private Item itemInSlotRing;
    private Item itemInSlotMainHand;
    private Item itemInSlotOffHand;
    public List<Item> inventory;

    public Player(String n, String pClass, int ac, int bd, int maxHP, int maxMP, int currentHP, int currentMP, int xp, int gp, int sp, int st, int ag, int in, int lvl) {
        super(n, pClass, ac, bd, maxHP, maxMP, currentHP, currentMP, xp, gp, sp, st, ag, in, lvl);
    }


    public void setSpellList(Ability spell1, Ability spell2, Ability spell3, Ability spell4){
        spellList = Arrays.asList(spell1, spell2, spell3, spell4);
    }

    public List<Ability> getSpellList() {
        return spellList;
    }

    public static Player getInstance()
    {
        if (INSTANCE == null) {
            INSTANCE = new Player(name,playerClass, armorClass, baseDamage, maximumHealth,maximumMana, currentHealth, currentMana, playerXP, playerGold, playerSpeed, strength, agility, intellect, playerLevel);
        }
        return INSTANCE;
    }

    public int determineMod(){
        int playerMod = 0;
        if (Player.getInstance().getCharacterClass().equals("Wizard")) {
            playerMod = ((Player.getInstance().getIntellect() / 2) - 5);
        }
            else if (Player.getInstance().getCharacterClass().equals("Warrior")){
                playerMod = ((Player.getInstance().getStrength() / 2) - 5);
            }
            else if (Player.getInstance().getCharacterClass().equals("Ranger")){
                playerMod = ((Player.getInstance().getAgility() / 2) - 5);
        }

        return playerMod;
    }

    public int getPosX(){
        return posX;
    }

    public void setPosX(int pX){
        posX = pX;
    }

    public int getPosY(){
        return posY;
    }

    public void setPosY(int pY){
        posY = pY;
    }

    public Monster getNextEnemy(){
        return nextEnemy;
    }

    public void setNextEnemy(Monster monster){
        nextEnemy = monster;
    }

    public void setAvailablePoints(int points){
        availablePoints = points;
    }

    public int getAvailablePoints(){
        return availablePoints;
    }

    public Item getItemInSlotHead(){
        return itemInSlotHead;
    }

    public void setItemInSlotHead(Equippable item){
            itemInSlotHead = item;
            removeFromInventory(item);
    }

    public Item getItemInSlotChest(){
        return itemInSlotChest;
    }

    public void setItemInSlotChest(Equippable item){
            itemInSlotChest = item;
            removeFromInventory(item);
    }

    public Item getItemInSlotLegs(){
        return itemInSlotLegs;
    }

    public void setItemInSlotLegs(Equippable item){
            itemInSlotLegs = item;
            removeFromInventory(item);
    }

    public Item getItemInSlotHands(){
        return itemInSlotHands;
    }

    public void setItemInSlotHands(Equippable item){
            itemInSlotHands = item;
            removeFromInventory(item);
    }
    public Item getItemInSlotFeet(){
        return itemInSlotFeet;
    }

    public void setItemInSlotFeet(Equippable item){
            itemInSlotFeet = item;
            removeFromInventory(item);
    }

    public Item getItemInSlotNeck(){
        return itemInSlotNeck;
    }

    public void setItemInSlotNeck(Equippable item){
            itemInSlotNeck = item;
            removeFromInventory(item);
    }

    public Item getItemInSlotRing(){
        return itemInSlotRing;
    }

    public void setItemInSlotRing(Equippable item){
            itemInSlotRing = item;
            removeFromInventory(item);

    }

    public Item getItemInSlotMainHand(){
        return itemInSlotMainHand;
    }

    public void setItemInSlotMainHand(Equippable item){
            itemInSlotMainHand = item;
            removeFromInventory(item);
    }

    public Item getItemInSlotOffHand(){
        return itemInSlotOffHand;
    }

    public void setItemInSlotOffHand(Equippable item){
            itemInSlotOffHand = item;
            removeFromInventory(item);
    }

    public void addToInventory(Item itemName){
        inventory.add(itemName);

    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void removeFromInventory(Item itemName){
        if (Arrays.asList(inventory).contains(itemName)){
            inventory.remove(itemName);
        }
    }

}

