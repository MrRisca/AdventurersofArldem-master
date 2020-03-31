package com.example.android.adventurersofarldem;

import com.example.android.adventurersofarldem.Characters.Character;

public class StatusEffect {

    public int duration;
    public int periodicDamage;
    public Character character;

    public StatusEffect(int duration, int periodicDamage){
        this.duration = duration;
        this.periodicDamage = periodicDamage;


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

    public void removeEffect(Character character) {
        this.character = character;
    }

    public void applySpecificEffect(Character character){
        this.character = character;
    }












}
