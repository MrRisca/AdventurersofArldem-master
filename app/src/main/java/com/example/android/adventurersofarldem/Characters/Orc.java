package com.example.android.adventurersofarldem.Characters;

public class Orc extends Monster {
    public Orc() {
        super("Orc", "Standard", 13, 2, 12, 0, 12, 0, 6, 5, 1, 1, 1, 1, 1);
    }


    @Override
    public void updateKills() {
        Player.getInstance().setOrcsKilled(Player.getInstance().getOrcsKilled() + 1);
    }

}