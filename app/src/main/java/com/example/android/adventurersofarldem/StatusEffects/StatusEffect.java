package com.example.android.adventurersofarldem.StatusEffects;

import com.example.android.adventurersofarldem.Attacks.StatusAttack;
import com.example.android.adventurersofarldem.Characters.Character;

public class StatusEffect {

    public int duration;
    public int periodicDamage;
    public int weakenedDuration;
    public StatusEffect statusEffect;
    public String name;
    public int startDuration;

    public StatusEffect(int duration, int periodicDamage, int startDuration){
        this.duration = duration;
        this.periodicDamage = periodicDamage;
        this.startDuration = startDuration;


    }

    public String getName(){
        return name;
    }

    public int definePeriodicDamage(StatusEffect statusEffect) {
        return periodicDamage;
    }

    public void applyPeriodicDamage(Character character){
        character.currentHealth -= periodicDamage;
        duration -= 1;
    }

    public void addToList(Character character, StatusEffect nameOfStatus){
        character.addStatusEffects(nameOfStatus);
    }

    public void applyStunDuration(Character character, int durationOfStun){
        character.setStunnedTurns(durationOfStun);
    }

    public void removeWeakenEffect(Character character) {
        character.setBaseDamage(character.getBaseDamage() * 2);

    }

    public void addWeakenEffect(Character character, int durationOfWeaken){
        character.setBaseDamage(character.getBaseDamage() / 2);
        character.setWeakenedTurns(durationOfWeaken);
    }

    public void removeLessenAgilityEffect(Character character) {
        character.setAgility(character.getAgility() * 2);

    }

    public void addLessenAgilityEffect(Character character, int durationOfWeaken){
        character.setAgility(character.getAgility() / 2);
        character.setWeakenedTurns(durationOfWeaken);
    }

    public void removeLessenIntellectEffect(Character character) {
        character.setIntellect(character.getIntellect() * 2);

    }

    public void addLessenIntellectEffect(Character character, int durationOfWeaken){
        character.setIntellect(character.getIntellect() / 2);
        character.setWeakenedTurns(durationOfWeaken);
    }
}
