package com.example.android.adventurersofarldem.StatusEffects;

import com.example.android.adventurersofarldem.Characters.Character;
import com.example.android.adventurersofarldem.StatusEffect;

public class Burn extends StatusEffect {
    public Burn(int duration, int periodicDamage) {
        super(duration, periodicDamage);
    }

    @Override
    public void removeEffect(Character character) {
        Burn.this.duration = 0;
    }
}
