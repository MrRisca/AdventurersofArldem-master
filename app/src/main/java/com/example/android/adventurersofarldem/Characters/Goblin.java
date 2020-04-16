package com.example.android.adventurersofarldem.Characters;


public class Goblin extends Monster {
    public Goblin() {
        super("Goblin", "Standard", 12, 2, 7, 0, 70, 0, 6, 5, 1, 1, 1, 1, 1);
    }


    @Override
    public void updateKills() {
        Player.getInstance().setGoblinsKilled(Player.getInstance().getGoblinsKilled() + 1);
    }
}

