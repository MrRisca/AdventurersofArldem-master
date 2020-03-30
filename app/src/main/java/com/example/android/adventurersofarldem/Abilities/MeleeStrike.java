package com.example.android.adventurersofarldem.Abilities;

import android.util.Log;

import com.example.android.adventurersofarldem.Attacks.Attack;
import com.example.android.adventurersofarldem.Attacks.FlameAttack;
import com.example.android.adventurersofarldem.Characters.Character;

public class MeleeStrike extends Ability {


    public MeleeStrike(int spellLevel) {
        super(spellLevel);
    }

    @Override
    public Attack toAttack(Character character) {

        int directDamage = (this.spellLevel * character.getBaseDamage());
        Log.d("sl in MeleeStrike", String.valueOf(this.spellLevel));
        Log.d("bd in MeleeStrike", String.valueOf(character.getBaseDamage()));
        Log.d("dd in MeleeStrike", String.valueOf(directDamage));
        Attack attack = new FlameAttack(directDamage);
        return attack;
    }

    @Override
    public String getName() {
        return "Melee Strike";
    }

    @Override
    public String getDescription() {
        return "I BEAT YOU UP";
    }
}
