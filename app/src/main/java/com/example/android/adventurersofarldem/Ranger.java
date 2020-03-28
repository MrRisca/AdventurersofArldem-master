package com.example.android.adventurersofarldem;


import android.os.Parcel;
import android.os.Parcelable;

public class Ranger extends Player {
    public Ranger(String n, String pClass, int st, int ag, int in, int maxHP, int maxMP, int currentHP, int currentMP, int ac, int pXP, int level) {
        super(n, pClass, st, ag, in, maxHP, maxMP, currentHP, currentMP, ac, pXP, level);
    }


    @Override
    public String toString() {
        return "Ranger{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intellect=" + intellect +
                ", maximumHealth=" + maximumHealth +
                ", maximumMana=" + maximumMana +
                ", currentHealth=" + currentHealth +
                ", currentMana=" + currentMana +
                ", Armor Class=" + armorClass +
                '}';
    }


}
