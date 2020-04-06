package com.example.android.adventurersofarldem.Abilities;

import android.util.Log;

import com.example.android.adventurersofarldem.Attacks.Attack;
import com.example.android.adventurersofarldem.Attacks.PhysicalAttack;
import com.example.android.adventurersofarldem.Attacks.StatusAttack;
import com.example.android.adventurersofarldem.Characters.Character;
import com.example.android.adventurersofarldem.StatusEffects.StatusEffect;
import com.example.android.adventurersofarldem.StatusEffects.Weaken;

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


    public StatusEffect addWeakenEffect(Character character){
        int duration = 4;
        int periodicDamage = 0;
        StatusEffect statusEffect = new StatusEffect(duration, periodicDamage, duration);
        statusEffect.addToList(character, new Weaken(duration, periodicDamage));
        statusEffect.addWeakenEffect(character, spellLevel * 2);
        Log.d("MS", String.valueOf(character.getBaseDamage()));
        return statusEffect;
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

    public boolean hasWeakenEffect(){
        return true;
    }

    @Override
    public boolean hasLeachEffect() {
        return false;
    }

    @Override
    public void addLeachEffect(Character caster) {

    }

}
