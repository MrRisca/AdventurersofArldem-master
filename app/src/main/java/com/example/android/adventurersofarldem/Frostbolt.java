package com.example.android.adventurersofarldem;

public class Frostbolt extends Ability {

    private int spellLevel;


    public Frostbolt(int spellLevel) {
        super(spellLevel);
        this.spellLevel = spellLevel;
    }


    public Attack toAttack() {
        int directDamage = spellLevel * 5;
        Attack attack = new FrostAttack(directDamage);
        return attack;
    }

    @Override
    public String getName() {
        return "Frostbolt";
    }

    @Override
    public String getDescriotion() {
        return "Icy Blast of Frost";
    }
}
