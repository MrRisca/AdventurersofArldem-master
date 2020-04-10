package com.example.android.adventurersofarldem.Items;

public abstract class Potion extends Item {

    public int numberOfUses;

    public Potion(String n, String des, boolean perma, int val, int rar, int iconP, int iconS, int nOU) {
        super(n, des, perma, val, rar, iconP, iconS);
        numberOfUses = nOU;
    }

    public void setNumberOfUses(int nOU){
        numberOfUses = nOU;
    }

    public int getNumberOfUses(){
        return numberOfUses;
    }

    public abstract void use();
}
