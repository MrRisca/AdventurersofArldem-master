package com.example.android.adventurersofarldem.Abilities;

import com.example.android.adventurersofarldem.Attacks.Attack;
import com.example.android.adventurersofarldem.Attacks.StatusAttack;
import com.example.android.adventurersofarldem.Characters.Character;
import com.example.android.adventurersofarldem.StatusEffects.StatusEffect;

public abstract class Ability {

    public int spellLevel;

    public Ability(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    public abstract Attack toAttack(Character character);

    public abstract StatusAttack addDamageEffect(Character character);

    public abstract StatusAttack addStunEffect(Character character);

    public abstract StatusEffect addWeakenEffect(Character character);

    public abstract String getName();

    public abstract String getDescription();

    public abstract boolean hasDamageEffect();

    public abstract boolean hasStunEffect();

    public abstract boolean hasWeakenEffect();

    public abstract boolean hasLeachEffect();

    public abstract void addLeachEffect(Character caster);
}