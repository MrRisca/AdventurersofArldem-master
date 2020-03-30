package com.example.android.adventurersofarldem.Abilities;

import com.example.android.adventurersofarldem.Attacks.Attack;
import com.example.android.adventurersofarldem.Attacks.FrostAttack;
import com.example.android.adventurersofarldem.Characters.Character;

public class Frostbolt extends Ability {

    private int spellLevel;


    public Frostbolt(int spellLevel) {
        super(spellLevel);
        this.spellLevel = spellLevel;
    }


    public Attack toAttack(Character character) {
        int directDamage = spellLevel * 5;
        Attack attack = new FrostAttack(directDamage);
        return attack;
    }

    @Override
    public String getName() {
        return "Frostbolt";
    }

    @Override
    public String getDescription() {
        return "Icy Blast of Frost";
    }
}
