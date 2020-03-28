package com.example.android.adventurersofarldem;

public class Fireball extends Ability {

    private int spellLevel;


    public Fireball(int spellLevel) {
        super(spellLevel);
        this.spellLevel = spellLevel;
    }


    public Attack toAttack() {
        int directDamage = 4;
        Attack attack = new FlameAttack(directDamage);
        return attack;
    }

    @Override
    public String getName() {
        return "Fireball";
    }

    @Override
    public String getDescriotion() {
        return "I AM RAGNAROS";
    }
}