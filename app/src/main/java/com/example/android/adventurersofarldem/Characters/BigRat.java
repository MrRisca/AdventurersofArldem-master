package com.example.android.adventurersofarldem.Characters;


import android.util.Log;

public class BigRat extends Monster {
    public BigRat() {
        super("Big Rat", "Boss", 13, 2, 12, 0, 12, 0, 6, 5, 1, 1, 1, 1, 1);
    }


    @Override
    public void updateKills() {
        Log.d("No", "No");
    }
}