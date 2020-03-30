package com.example.android.adventurersofarldem.Abilities;

import com.example.android.adventurersofarldem.Attacks.Attack;
import com.example.android.adventurersofarldem.Characters.Character;

public abstract class Ability {

    public int spellLevel;

    public Ability(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    public abstract Attack toAttack(Character character);


    public abstract String getName();

    public abstract String getDescription();


}