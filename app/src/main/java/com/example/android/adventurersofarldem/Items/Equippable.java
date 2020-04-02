package com.example.android.adventurersofarldem.Items;

import com.example.android.adventurersofarldem.Characters.Player;

public class Equippable extends Item {
    private int amount;
    private String slot;
    private String stat;

    public Equippable(String n, String des, boolean perma, int val, int rar, String sl, String st, int am) {
        super(n, des, perma, val, rar);
        slot = sl;
        stat = st;
        amount = am;
    }

    public String getSlot(){
        return slot;
    }

    public void equip(){
        if (slot.equals("Head")){
            Player.getInstance().setItemInSlotHead(this);
            Player.getInstance().removeFromInventory(this);
            statIncrease();
        }
        else if (slot.equals("Chest")){
            Player.getInstance().setItemInSlotChest(this);
            Player.getInstance().removeFromInventory(this);
            statIncrease();
        }
        else if (slot.equals("Legs")){
            Player.getInstance().setItemInSlotLegs(this);
            Player.getInstance().removeFromInventory(this);
            statIncrease();
        }
        else if (slot.equals("Hands")){
            Player.getInstance().setItemInSlotHands(this);
            Player.getInstance().removeFromInventory(this);
            statIncrease();
        }
        else if (slot.equals("Feet")){
            Player.getInstance().setItemInSlotFeet(this);
            Player.getInstance().removeFromInventory(this);
            statIncrease();
        }
        else if (slot.equals("Neck")){
            Player.getInstance().setItemInSlotNeck(this);
            Player.getInstance().removeFromInventory(this);
            statIncrease();
        }
        else if (slot.equals("Ring")){
            Player.getInstance().setItemInSlotRing(this);
            Player.getInstance().removeFromInventory(this);
            statIncrease();
        }
        else if (slot.equals("Main Hand")){
            Player.getInstance().setItemInSlotMainHand(this);
            Player.getInstance().removeFromInventory(this);
            statIncrease();
        }
        else if (slot.equals("Off Hand")){
            Player.getInstance().setItemInSlotOffHand(this);
            Player.getInstance().removeFromInventory(this);
            statIncrease();
        }
    }


    public void unequip(){
        Player.getInstance().addToInventory(this);
        statDecrease();
        //Create a 0 value item and replace the existing item with it.
    }

    public void statIncrease(){
        if (stat.equals("Strength")){
            Player.getInstance().setStrength(Player.getInstance().getStrength() + amount);
        }
        if (stat.equals("Agility")){
            Player.getInstance().setAgility(Player.getInstance().getAgility() + amount);
        }
        if (stat.equals("Intellect")){
            Player.getInstance().setIntellect(Player.getInstance().getIntellect() + amount);
        }
        if (stat.equals("Base Damage")){
            Player.getInstance().setBaseDamage(Player.getInstance().getBaseDamage() + amount);
        }
        if (stat.equals("Maximum Health")){
            Player.getInstance().setMaximumHealth(Player.getInstance().getMaximumHealth() + amount);
        }
        if (stat.equals("Maximum Mana")){
            Player.getInstance().setMaximumMana(Player.getInstance().getMaximumMana() + amount);
        }
        if (stat.equals("Armor Class")){
            Player.getInstance().setArmorClass(Player.getInstance().getArmorClass() + amount);
        }
    }

    public void statDecrease(){
        if (stat.equals("Strength")){
            Player.getInstance().setStrength(Player.getInstance().getStrength() - amount);
        }
        if (stat.equals("Agility")){
            Player.getInstance().setAgility(Player.getInstance().getAgility() - amount);
        }
        if (stat.equals("Intellect")){
            Player.getInstance().setIntellect(Player.getInstance().getIntellect() - amount);
        }
        if (stat.equals("Base Damage")){
            Player.getInstance().setBaseDamage(Player.getInstance().getBaseDamage() - amount);
        }
        if (stat.equals("Maximum Health")){
            Player.getInstance().setMaximumHealth(Player.getInstance().getMaximumHealth() - amount);
        }
        if (stat.equals("Maximum Mana")){
            Player.getInstance().setMaximumMana(Player.getInstance().getMaximumMana() - amount);
        }
        if (stat.equals("Armor Class")){
            Player.getInstance().setArmorClass(Player.getInstance().getArmorClass() - amount);
        }
    }


}
