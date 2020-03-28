package com.example.android.adventurersofarldem;

public abstract class Ability {


    public Ability(int spellLevel) {
    }

    public abstract Attack toAttack();


    public abstract String getName();

    public abstract String getDescriotion();
}