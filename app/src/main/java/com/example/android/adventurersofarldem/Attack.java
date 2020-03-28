package com.example.android.adventurersofarldem;


public class Attack{
    int directDamage;

    public Attack(int directDamage){
        this.directDamage = directDamage;

    }

    public void applyTo(Character character){
          character.currentHealth -= directDamage;
        }
    }
