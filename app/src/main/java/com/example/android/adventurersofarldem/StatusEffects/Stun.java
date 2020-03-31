package com.example.android.adventurersofarldem.StatusEffects;

import com.example.android.adventurersofarldem.Characters.Character;
import com.example.android.adventurersofarldem.StatusEffect;

public class Stun extends StatusEffect {
    public Stun(int duration, int periodicDamage) {
        super(duration, periodicDamage);
    }

    @Override
    public void removeEffect(Character character) {
        character.setStunnedTurns(0);
        return null;
    }
}
