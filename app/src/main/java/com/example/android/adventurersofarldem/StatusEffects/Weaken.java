package com.example.android.adventurersofarldem.StatusEffects;

import com.example.android.adventurersofarldem.Attacks.StatusAttack;
import com.example.android.adventurersofarldem.Characters.Character;
import com.example.android.adventurersofarldem.StatusEffect;

public class Weaken extends StatusEffect {
    public Weaken(int duration, int periodicDamage) {
        super(duration, periodicDamage);
    }

    @Override
    public void removeEffect(Character character) {
        character.setBaseDamage(character.getBaseDamage() * 2);
        }

    @Override
    public void applySpecificEffect(Character character) {
        character.setBaseDamage(character.getBaseDamage() / 2);
    }


}
