package com.example.android.adventurersofarldem.Abilities;

import com.example.android.adventurersofarldem.Attacks.Attack;
import com.example.android.adventurersofarldem.Attacks.FlameAttack;
import com.example.android.adventurersofarldem.Characters.Character;

public class HolyStrike extends Ability {

    private int spellLevel;


    public HolyStrike(int spellLevel) {
        super(spellLevel);
        this.spellLevel = spellLevel;
    }


    public Attack toAttack(Character character) {
        int directDamage = spellLevel * 5;
        Attack attack = new FlameAttack(directDamage);
        return attack;
    }

    @Override
    public String getName() {
        return "Holy Strike";
    }

    @Override
    public String getDescription() {
        return "The power of Christ compels you!";
    }
}