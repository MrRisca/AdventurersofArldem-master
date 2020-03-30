package com.example.android.adventurersofarldem.Abilities;

import com.example.android.adventurersofarldem.Attacks.Attack;
import com.example.android.adventurersofarldem.Attacks.FlameAttack;
import com.example.android.adventurersofarldem.Characters.Character;

public class Fireball extends Ability {

    private int spellLevel;


    public Fireball(int spellLevel) {
        super(spellLevel);
        this.spellLevel = spellLevel;
    }


    public Attack toAttack(Character character) {
        int directDamage = 4;
        Attack attack = new FlameAttack(directDamage);
        return attack;
    }

    @Override
    public String getName() {
        return "Fireball";
    }

    @Override
    public String getDescription() {
        return "I AM RAGNAROS";
    }
}