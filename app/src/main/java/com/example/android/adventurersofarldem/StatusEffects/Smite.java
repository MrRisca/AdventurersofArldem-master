package com.example.android.adventurersofarldem.StatusEffects;

import com.example.android.adventurersofarldem.Characters.Character;
import com.example.android.adventurersofarldem.StatusEffect;

public class Smite extends StatusEffect {
    public Smite(int duration, int periodicDamage) {
        super(duration, periodicDamage);
    }

    @Override
    public void removeEffect(Character character) {
        Smite.this.duration = 0;
   }
}
