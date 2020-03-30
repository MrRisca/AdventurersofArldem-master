package com.example.android.adventurersofarldem.Attacks;


import com.example.android.adventurersofarldem.Characters.Character;

public class Attack{
    int directDamage;

    public Attack(int directDamage){
        this.directDamage = directDamage;

    }

    public void applyTo(Character character){
          character.currentHealth -= directDamage;
        }
    }
