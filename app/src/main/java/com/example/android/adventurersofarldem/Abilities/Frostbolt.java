package com.example.android.adventurersofarldem.Abilities;

import com.example.android.adventurersofarldem.Attacks.Attack;
import com.example.android.adventurersofarldem.Attacks.FrostAttack;
import com.example.android.adventurersofarldem.Attacks.StatusAttack;
import com.example.android.adventurersofarldem.Characters.Character;
import com.example.android.adventurersofarldem.StatusEffects.StatusEffect;
import com.example.android.adventurersofarldem.StatusEffects.Stun;

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
    public StatusAttack addDamageEffect(Character character) {
        return null;
    }

    public StatusAttack addStunEffect(Character character){
        int duration = 3;
        int periodicDamage = 0;
        StatusAttack attack = new StatusAttack(duration, periodicDamage);
        StatusEffect statusEffect = new StatusEffect(duration, periodicDamage, duration);
        statusEffect.addToList(character, new Stun(duration, periodicDamage));
        statusEffect.applyStunDuration(character, duration);
        return attack;
    }

    @Override
    public StatusEffect addWeakenEffect(Character character) {

        return null;
    }

    @Override
    public String getName() {
        return "Frostbolt";
    }

    @Override
    public String getDescription() {
        return "Icy Blast of Frost";
    }

    @Override
    public boolean hasDamageEffect() {
        return false;
    }

    @Override
    public boolean hasStunEffect() {
        return true;
    }

    @Override
    public boolean hasWeakenEffect() {
        return false;
    }


}
