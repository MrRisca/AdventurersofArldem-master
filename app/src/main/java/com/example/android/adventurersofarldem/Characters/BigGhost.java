package com.example.android.adventurersofarldem.Characters;


import android.util.Log;

public class BigGhost extends Monster {
    public BigGhost() {
        super("Big Ghost", "Boss", 13, 2, 12, 0, 12, 0, 6, 5, 1, 1, 1, 1, 1);
    }


    @Override
    public void updateKills() {
        Log.d("NoUpdate", "No update");
    }
}