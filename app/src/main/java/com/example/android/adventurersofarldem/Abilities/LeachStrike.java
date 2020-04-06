package com.example.android.adventurersofarldem.Abilities;

import com.example.android.adventurersofarldem.Attacks.Attack;
import com.example.android.adventurersofarldem.Attacks.LeachAttack;
import com.example.android.adventurersofarldem.Attacks.StatusAttack;
import com.example.android.adventurersofarldem.Characters.Character;
import com.example.android.adventurersofarldem.StatusEffects.StatusEffect;

public class LeachStrike extends Ability {
    public LeachStrike(int spellLevel) {
        super(spellLevel);
    }

    @Override
    public Attack toAttack(Character character) {
        int directDamage = spellLevel * 4;
        Attack attack = new LeachAttack(directDamage);
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
    public StatusEffect addWeakenEffect(Character character) {
        return null;
    }

    @Override
    public void addLeachEffect(Character caster) {
        int directDamage = spellLevel * 4;
        LeachAttack attack = new LeachAttack(directDamage);
        attack.leachDamage(caster);
    }

    @Override
    public String getName() {
        return "Leach Strike";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public boolean hasDamageEffect() {
        return false;
    }

    @Override
    public boolean hasStunEffect() {
        return false;
    }

    @Override
    public boolean hasWeakenEffect() {
        return false;
    }

    @Override
    public boolean hasLeachEffect() {
        return true;
    }
}
