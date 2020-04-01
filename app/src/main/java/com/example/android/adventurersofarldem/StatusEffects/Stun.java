package com.example.android.adventurersofarldem.StatusEffects;

import com.example.android.adventurersofarldem.Characters.Character;

public class Stun extends StatusEffect {
    public Stun(int duration, int periodicDamage) {
        super(duration, periodicDamage, duration);
    }

    @Override
    public void removeWeakenEffect(Character character) {

    }
}
