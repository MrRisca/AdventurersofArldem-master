package com.example.android.adventurersofarldem.Characters;

import com.example.android.adventurersofarldem.Characters.Monster;


public class Troll extends Monster {
    public Troll() {
        super("Troll", "Standard", 15, 2, 50, 0, 50, 0, 6, 5, 1, 1, 1, 1, 1);
    }


    @Override
    public void updateKills() {
        Player.getInstance().setTrollsKilled(Player.getInstance().getTrollsKilled() + 1);
    }
}