package com.example.android.adventurersofarldem;

public class HolyStrike extends Ability {

    private int spellLevel;


    public HolyStrike(int spellLevel) {
        super(spellLevel);
        this.spellLevel = spellLevel;
    }


    public Attack toAttack() {
        int directDamage = spellLevel * 5;
        Attack attack = new FlameAttack(directDamage);
        return attack;
    }

    @Override
    public String getName() {
        return "Holy Strike";
    }

    @Override
    public String getDescriotion() {
        return "The power of Christ compels you!";
    }
}