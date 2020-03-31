package com.example.android.adventurersofarldem.Attacks;

import com.example.android.adventurersofarldem.Characters.Character;

public class StatusAttack{

    int duration;
    int periodicDamage;

    public StatusAttack(int duration, int periodicDamage){
        this.duration = duration;
        this.periodicDamage = periodicDamage;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int dur){
        duration = dur;
    }

    public int getPeriodicDamage(){
        return periodicDamage;
    }

    public void setPeriodicDamage(int periodicD){
        periodicDamage = periodicD;
    }

    public void onCharacterEndedTurn(Character character){
        if (duration > 0){
            character.setCurrentHealth(character.getCurrentHealth() - periodicDamage);
        }
    }
}

