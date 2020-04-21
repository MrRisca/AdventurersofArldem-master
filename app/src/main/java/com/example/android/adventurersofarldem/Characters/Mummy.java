package com.example.android.adventurersofarldem.Characters;

import com.example.android.adventurersofarldem.Characters.Monster;


public class Mummy extends Monster {
    public Mummy() {
        super("Mummy", "Standard", 15, 2, 50, 0, 50, 0, 6, 5, 1, 1, 1, 1, 1);
    }


    @Override
    public void updateKills() {
        Player.getInstance().setMummysKilled(Player.getInstance().getMummysKilled() + 1);
    }
}