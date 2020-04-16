package com.example.android.adventurersofarldem.Characters;

import com.example.android.adventurersofarldem.Characters.Monster;


public class Shark extends Monster {
    public Shark() {
        super("Shark", "Standard", 15, 2, 50, 0, 50, 0, 6, 5, 1, 1, 1, 1, 1);
    }


    @Override
    public void updateKills() {
        Player.getInstance().setSharksKilled(Player.getInstance().getSharksKilled() + 1);
    }
}