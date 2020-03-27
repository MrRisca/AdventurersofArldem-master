package com.example.android.adventurersofarldem;

public class FlameAttack extends Attack implements StatusAttack {
    int periodicDamage;
    int durationTurns;

    public FlameAttack(int attackerRoll, int defenderRoll, int attackerMod, int defenderMod, int periodicDamage, int durationTurns){
        super(attackerRoll, defenderRoll, attackerMod, defenderMod, 0); // We put 0 as our direct damage, I've assumed FlameAttack is just a d-o-t

        this.periodicDamage = periodicDamage;
        this.durationTurns = durationTurns;
    }

    public int getDuration() {
        return durationTurns;
    }

    @Override
    public void applyTo(Character character){
        super.applyTo(character); // If we hadn't put 0 as our direct damage, this would apply whatever damage via the superclass

        // Your character/battle system can manage the list of statuses and have them fall off after durationTurns turns
//        character.addStatusEffect(this, durationTurns, periodicDamage);
    }

    public void onCharacterEndedTurn(Character character) {
        // The idea is that your battle system would loop through StatusAttacks on the character and call this at the end of each turn.
        // You could do cooler things like RNG or adding more statuses etc

        character.currentHealth -= periodicDamage;
    }
}