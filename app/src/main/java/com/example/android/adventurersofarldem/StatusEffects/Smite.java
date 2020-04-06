package com.example.android.adventurersofarldem.StatusEffects;

import com.example.android.adventurersofarldem.Characters.Character;

public class Smite extends StatusEffect {
    public Smite(int duration, int periodicDamage) {
        super(duration, periodicDamage, duration);
    }

    @Override
    public void removeWeakenEffect(Character character){
   }
    @Override
    public String getName() {
        return "Smite";
    }
}
