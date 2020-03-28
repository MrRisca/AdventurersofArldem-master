package com.example.android.adventurersofarldem;

public class Warrior extends Player {
    public Warrior(String n, String pClass, int st, int ag, int in, int maxHP, int maxMP, int currentHP, int currentMP, int ac, int pXP, int level) {
        super(n, pClass, st, ag, in, maxHP, maxMP, currentHP, currentMP, ac, pXP, level);
    }



    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intellect=" + intellect +
                ", maximumHealth=" + maximumHealth +
                ", maximumMana=" + maximumMana +
                ", currentHealth=" + currentHealth +
                ", currentMana=" + currentMana +
                ", armor class" + armorClass +
                '}';
    }


}
