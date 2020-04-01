package com.example.android.adventurersofarldem.Abilities;

import com.example.android.adventurersofarldem.Attacks.Attack;
import com.example.android.adventurersofarldem.Attacks.FlameAttack;
import com.example.android.adventurersofarldem.Attacks.StatusAttack;
import com.example.android.adventurersofarldem.Characters.Character;
import com.example.android.adventurersofarldem.StatusEffects.StatusEffect;
import com.example.android.adventurersofarldem.StatusEffects.Burn;

public class Fireball extends Ability {


    public Fireball(int spellLevel) {
        super(spellLevel);
        this.spellLevel = spellLevel;
    }


    public Attack toAttack(Character character) {
        int directDamage = spellLevel * 4;
        Attack attack = new FlameAttack(directDamage);
        return attack;
    }


    public StatusAttack addDamageEffect(Character character) {
        int duration = 10;
        int periodicDamage = spellLevel * 2;
        StatusAttack attack = new StatusAttack(duration, periodicDamage);
        StatusEffect statusEffect = new StatusEffect(duration, periodicDamage, duration);
        statusEffect.addToList(character, new Burn(duration, periodicDamage));
        return attack;
    }

    @Override
    public StatusAttack addStunEffect(Character character) {
        return null;
    }

    @Override
    public StatusEffect addWeakenEffect(Character character) {

        return null;
    }

    @Override
    public String getName() {
        return "Fireball";
    }

    @Override
    public String getDescription() {
        return "I AM RAGNAROS";
    }

    @Override
    public boolean hasDamageEffect() {
        return true;
    }

    @Override
    public boolean hasStunEffect() {
        return false;
    }

    @Override
    public boolean hasWeakenEffect() {
        return false;
    }
}