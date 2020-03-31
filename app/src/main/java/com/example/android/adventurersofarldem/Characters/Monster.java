package com.example.android.adventurersofarldem.Characters;

import com.example.android.adventurersofarldem.CharacterInterface;
import com.example.android.adventurersofarldem.Characters.Character;


public class Monster extends Character implements CharacterInterface {

    public Monster(String n, String pClass, int ac, int bd, int maxHP, int maxMP, int currentHP, int currentMP, int xp, int gp, int sp, int st, int ag, int in, int lvl) {
        super(n, pClass, ac, bd, maxHP, maxMP, currentHP, currentMP, xp, gp, sp, st, ag, in, lvl);
    }


}

