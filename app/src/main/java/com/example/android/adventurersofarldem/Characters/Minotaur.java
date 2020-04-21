package com.example.android.adventurersofarldem.Characters;


public class Minotaur extends Monster {
    public Minotaur() {
        super("Minotaur", "Standard", 15, 2, 50, 0, 50, 0, 6, 5, 1, 1, 1, 1, 1);
    }


    @Override
    public void updateKills() {
        Player.getInstance().setMinotaursKilled(Player.getInstance().getMinotaursKilled() + 1);
    }
}