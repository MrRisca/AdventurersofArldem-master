package com.example.android.adventurersofarldem.StatusEffects;

import android.util.Log;

import com.example.android.adventurersofarldem.Characters.Character;

public class Weaken extends StatusEffect {
    public Weaken(int duration, int periodicDamage) {
        super(duration, periodicDamage, duration);
    }

    @Override
    public String getName() {
        return "Weaken";
    }

    @Override
    public void removeWeakenEffect(Character character) {
        super.removeWeakenEffect(character);
        }

    @Override
    public void addWeakenEffect(Character character, int durationOfWeaken) {
        super.addWeakenEffect(character, durationOfWeaken);
        Log.d("Weaken BD", String.valueOf(character.getBaseDamage()));
    }


}
