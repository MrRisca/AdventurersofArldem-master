package com.example.android.adventurersofarldem;


public class Attack{
    int attackerRoll;
    int defenderRoll;
    int attackerMod;
    int defenderMod;
    int directDamage;
    int target;

    // I changed it from player/monster to attacker/defender so that monsters can share the same code
    public Attack(int attackerRoll, int defenderRoll, int attackerMod, int defenderMod, int directDamage){
        this.attackerRoll = attackerRoll;
        this.defenderRoll = defenderRoll;
        this.attackerMod = attackerMod;
        this.defenderMod = defenderMod;
        this.directDamage = directDamage;
    }

    public boolean isSuccessful(){
        return (attackerRoll + attackerMod) > (defenderRoll + defenderMod);
    }

    public void applyTo(Character character){
        if (isSuccessful()) {
            character.currentHealth -= directDamage;
        }
    }
}