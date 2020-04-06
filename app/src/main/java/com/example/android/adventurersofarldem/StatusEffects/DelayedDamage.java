package com.example.android.adventurersofarldem.StatusEffects;

public class DelayedDamage extends StatusEffect {
    public DelayedDamage(int duration, int periodicDamage, int startDuration) {
        super(duration, periodicDamage, duration);
    }

    public int definePeriodicDamage(StatusEffect statusEffect){
        int damageThisTurn = statusEffect.duration + (statusEffect.startDuration * 100);
        return statusEffect.periodicDamage * damageThisTurn;
    }

    @Override
    public String getName() {
        return "DelayedDamage";
    }

}
