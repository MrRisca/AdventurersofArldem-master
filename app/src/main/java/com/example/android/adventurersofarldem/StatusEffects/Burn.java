package com.example.android.adventurersofarldem.StatusEffects;

import com.example.android.adventurersofarldem.Characters.Character;

public class Burn extends StatusEffect {
    public Burn(int duration, int periodicDamage) {
        super(duration, periodicDamage, duration);
    }

    @Override
    public void removeWeakenEffect(Character character) {
    }

    public int definePeriodicDamage(StatusEffect statusEffect){
        return periodicDamage;
    }

    @Override
    public String getName() {
        return "Burn";
    }
}
