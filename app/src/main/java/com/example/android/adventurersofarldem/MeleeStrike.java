package com.example.android.adventurersofarldem;

public class MeleeStrike extends Ability {

    private int spellLevel;


    public MeleeStrike(int spellLevel) {
        super(spellLevel);
    }

    @Override
    public Attack toAttack() {
        int directDamage = spellLevel * 3;
        Attack attack = new PhysicalAttack(directDamage);
        return attack;
    }

    @Override
    public String getName() {
        return "Melee Strike";
    }

    @Override
    public String getDescriotion() {
        return "I BEAT YOU UP";
    }
}
