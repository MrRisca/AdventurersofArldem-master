package com.example.android.adventurersofarldem.Characters;


import com.example.android.adventurersofarldem.Characters.Player;

public class Ranger extends Player {
    public Ranger(String n, String pClass, int ac, int bd, int maxHP, int maxMP, int currentHP, int currentMP, int xp, int gp, int sp, int st, int ag, int in, int lvl) {
        super(n, pClass, ac, bd, maxHP, maxMP, currentHP, currentMP, xp, gp, sp, st, ag, in, lvl);
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
