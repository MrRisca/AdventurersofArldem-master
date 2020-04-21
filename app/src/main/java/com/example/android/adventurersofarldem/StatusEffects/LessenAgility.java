package com.example.android.adventurersofarldem.StatusEffects;

import android.util.Log;

import com.example.android.adventurersofarldem.Characters.Character;

public class LessenAgility extends StatusEffect {
    public LessenAgility(int duration, int periodicDamage) {
        super(duration, periodicDamage, duration);
    }

    @Override
    public String getName() {
        return "LessenAgility";
    }

    @Override
    public void removeLessenAgilityEffect(Character character) {
        super.removeLessenAgilityEffect(character);
        }

    @Override
    public void addLessenAgilityEffect(Character character, int durationOfWeaken) {
        super.addLessenAgilityEffect(character, durationOfWeaken);

    }


}
