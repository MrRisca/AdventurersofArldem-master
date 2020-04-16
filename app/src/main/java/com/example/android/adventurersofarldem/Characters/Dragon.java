package com.example.android.adventurersofarldem.Characters;

public class Dragon extends Monster {
    public Dragon() {
        super("Dragon", "Standard", 15, 2, 50, 0, 50, 0, 6, 5, 1, 1, 1, 1, 1);
    }


    @Override
    public void updateKills() {
        Player.getInstance().setDragonsKilled(Player.getInstance().getDragonsKilled() + 1);
    }
}