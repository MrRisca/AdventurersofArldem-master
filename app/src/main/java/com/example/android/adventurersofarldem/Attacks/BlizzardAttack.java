//package com.example.android.adventurersofarldem;
//
//import com.example.android.adventurersofarldem.Attacks.Attack;
//import com.example.android.adventurersofarldem.Attacks.RicochetAttack;
//import com.example.android.adventurersofarldem.Attacks.StatusAttack;
//
//import java.util.List;
//import java.util.Random;
//
//public class BlizzardAttack extends Attack implements StatusAttack, RicochetAttack {
//    int periodicDamage = 1;
//
//    public BlizzardAttack(int attackerRoll, int defenderRoll, int attackerMod, int defenderMod){
//        super(attackerRoll, defenderRoll, attackerMod, defenderMod, 10);
//    }
//    public int getDuration() {
//        return 10;
//    }
//
//    @Override
//    public void applyTo(Character character){
//        super.applyTo(character);
//
//        // Your character/battle system can manage the list of statuses and have them fall off after durationTurns turns
//        character.addStatusEffect(this, getDuration());
//    }
//
//    public void onCharacterEndedTurn(Character character) {
//        if(Random.nextBoolean()) {
//            character.frozenTurns++;
//        }
//
//        character.currentHealth -= periodicDamage;
//
//        if(character.frozenTurns > 0){
//            periodicDamage++; // If the character is still frozen, we'll deal more damage next turn
//        }
//    }
//
//    // Maybe we only want Blizzard to richochet itself to characters that aren't already blizzarded
//    private boolean isValidTarget(Character character){
//        for(StatusAttack existingStatusAttack : character.getStatusEffect()){
//            if(existingStatusAttack instanceof BlizzardAttack){
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    @Override
//    public void receiveAdditionalTargets(List<Character> potentialTargetList) {
//        for(character : potentialTargetList){
//            if(!isValidTarget(character)){
//                continue;
//            }
//
//            this.applyTo(character);
//        }
//    }
//}