package com.example.android.adventurersofarldem.Characters;


public class Kraken extends Monster {
    public Kraken() {
        super("Kraken", "Standard", 15, 2, 50, 0, 50, 0, 6, 5, 1, 1, 1, 1, 1);
    }


    @Override
    public void updateKills() {
        Player.getInstance().setKrakensKilled(Player.getInstance().getKrakensKilled() + 1);
    }
}