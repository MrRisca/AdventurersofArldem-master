package com.example.android.adventurersofarldem.Abilities;

import android.util.Log;

import com.example.android.adventurersofarldem.Attacks.Attack;
import com.example.android.adventurersofarldem.Attacks.FlameAttack;
import com.example.android.adventurersofarldem.Attacks.PhysicalAttack;
import com.example.android.adventurersofarldem.Attacks.StatusAttack;
import com.example.android.adventurersofarldem.Characters.Character;

public class MeleeStrike extends Ability {


    public MeleeStrike(int spellLevel) {
        super(spellLevel);
    }

    @Override
    public Attack toAttack(Character character) {

        int directDamage = (this.spellLevel * character.getBaseDamage());
        Attack attack = new PhysicalAttack(directDamage);
        return attack;
    }

    @Override
    public StatusAttack addDamageEffect(Character character) {
        return null;
    }

    @Override
    public StatusAttack addStunEffect(Character character) {
        return null;
    }

    @Override
    public String getName() {
        return "Melee Strike";
    }

    @Override
    public String getDescription() {
        return "I BEAT YOU UP";
    }

    @Override
    public boolean hasDamageEffect() {
        return false;
    }

    @Override
    public boolean hasStunEffect() {
        return false;
    }
}
