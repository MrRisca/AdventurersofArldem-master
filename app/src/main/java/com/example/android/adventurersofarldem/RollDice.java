package com.example.android.adventurersofarldem;

public class RollDice {

    private int attackerRoll;
    private int defenderRoll;
    private int attackerMod;
    private int defenderMod;

    public RollDice(int attackerRoll, int defenderRoll, int attackerMod, int defenderMod){
        this.attackerRoll = attackerRoll;
        this.defenderRoll = defenderRoll;
        this.attackerMod = attackerMod;
        this.defenderMod = defenderMod;
    }

    public boolean isSuccessful(){
        return (attackerRoll + attackerMod) > (defenderRoll + defenderMod);
    }

}
