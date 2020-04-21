package com.example.android.adventurersofarldem.StatusEffects;

import com.example.android.adventurersofarldem.Characters.Character;

public class LessenIntellect extends StatusEffect {
    public LessenIntellect(int duration, int periodicDamage) {
        super(duration, periodicDamage, duration);
    }

    @Override
    public String getName() {
        return "LessenIntellect";
    }

    @Override
    public void removeLessenIntellectEffect(Character character) {
        super.removeLessenIntellectEffect(character);
        }

    @Override
    public void addLessenIntellectEffect(Character character, int durationOfWeaken) {
        super.addLessenIntellectEffect(character, durationOfWeaken);

    }


}
