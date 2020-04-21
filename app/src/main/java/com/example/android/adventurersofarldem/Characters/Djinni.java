package com.example.android.adventurersofarldem.Characters;


public class Djinni extends Monster {
    public Djinni() {
        super("Djinni", "Standard", 15, 2, 50, 0, 50, 0, 6, 5, 1, 1, 1, 1, 1);
    }


    @Override
    public void updateKills() {
        Player.getInstance().setDjinnisKilled(Player.getInstance().getDjinnisKilled() + 1);
    }
}