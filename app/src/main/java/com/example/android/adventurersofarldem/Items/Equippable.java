package com.example.android.adventurersofarldem.Items;

import com.example.android.adventurersofarldem.Characters.Player;

public class Equippable extends Item {
    private int amount;
    private String slot;
    private String stat;
    private Equippable oldItem;

    public Equippable(String n, String des, boolean perma, int val, int rar, int iconP, int iconS, String sl, String st, int am) {
        super(n, des, perma, val, rar, iconP, iconS);
        slot = sl;
        stat = st;
        amount = am;
    }

    public String getSlot(){
        return slot;
    }

    public void equip(){
        if (slot.equals("Head")){
            oldItem = (Equippable) Player.getInstance().getItemInSlotHead();
            if (oldItem != null){
            oldItem.unequip();}
            Player.getInstance().setItemInSlotHead(this);
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
        oldItem = (Equippable) Player.getInstance().getItemInSlotHead();
        if (oldItem != null) {
            oldItem.statDecrease();
            if (oldItem.getSlot().equals("Head")){
                Player.getInstance().setItemInSlotHead(null);
            }
            if (oldItem.getSlot().equals("Chest")){
                Player.getInstance().setItemInSlotChest(null);
            }
            if (oldItem.getSlot().equals("Legs")){
                Player.getInstance().setItemInSlotLegs(null);
            }
            if (oldItem.getSlot().equals("Feet")){
                Player.getInstance().setItemInSlotFeet(null);
            }
            if (oldItem.getSlot().equals("Hands")){
                Player.getInstance().setItemInSlotHands(null);
            }
            if (oldItem.getSlot().equals("Ring")){
                Player.getInstance().setItemInSlotRing(null);
            }
            if (oldItem.getSlot().equals("Main Hand")){
                Player.getInstance().setItemInSlotMainHand(null);
            }
            if (oldItem.getSlot().equals("Off Hand")){
                Player.getInstance().setItemInSlotOffHand(null);
            }
            if (oldItem.getSlot().equals("Neck")){
                Player.getInstance().setItemInSlotNeck(null);
            }
        }
        Player.getInstance().addToInventory(this);

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
