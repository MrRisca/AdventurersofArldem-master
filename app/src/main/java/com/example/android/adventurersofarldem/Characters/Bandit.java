package com.example.android.adventurersofarldem.Characters;


public class Bandit extends Monster {
    public Bandit() {
        super("Bandit", "Standard", 13, 2, 12, 0, 12, 0, 6, 5, 1, 1, 1, 1, 1);
    }


    @Override
    public void updateKills() {
        Player.getInstance().setBanditsKilled(Player.getInstance().getBanditsKilled() + 1);
    }
}