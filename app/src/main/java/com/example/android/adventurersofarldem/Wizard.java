package com.example.android.adventurersofarldem;

import android.os.Parcel;
import android.os.Parcelable;

public class Wizard extends Player {
    public Wizard(String n, int st, int ag, int in, int maxHP, int maxMP, int currentHP, int currentMP) {
        super(n, st, ag, in, maxHP, maxMP, currentHP, currentMP);
    }


    @Override
    public String toString() {
        return "Wizard{" +
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
