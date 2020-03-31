package com.example.android.adventurersofarldem.Abilities;

import android.util.Log;

import com.example.android.adventurersofarldem.Attacks.Attack;
import com.example.android.adventurersofarldem.Attacks.FlameAttack;
import com.example.android.adventurersofarldem.Attacks.StatusAttack;
import com.example.android.adventurersofarldem.Characters.Character;
import com.example.android.adventurersofarldem.StatusEffect;
import com.example.android.adventurersofarldem.StatusEffects.Burn;
import com.example.android.adventurersofarldem.StatusEffects.Smite;

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
    public StatusAttack addDamageEffect(Character character) {
        int duration = 5;
        int periodicDamage = spellLevel * 1;
        StatusAttack attack = new StatusAttack(duration, periodicDamage);
        StatusEffect statusEffect = new StatusEffect(duration, periodicDamage);
        statusEffect.addToList(character, new Smite(duration, periodicDamage));
        return attack;
    }

    @Override
    public StatusAttack addStunEffect(Character character) {
        return null;
    }

    @Override
    public String getName() {
        return "Holy Strike";
    }

    @Override
    public String getDescription() {
        return "The power of Christ compels you!";
    }

    @Override
    public boolean hasDamageEffect() {
        return true;
    }

    @Override
    public boolean hasStunEffect() {
        return false;
    }
}