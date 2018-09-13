package com.example.android.adventurersofarldem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class StatSelection extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String playerName = getIntent().getStringExtra("playerName");
        String playerClass = getIntent().getStringExtra("playerClass");
        int playerStrength = getIntent().getIntExtra("playerSt", 0);
        int playerAgility = getIntent().getIntExtra("playerAg", 0);
        int playerIntellect = getIntent().getIntExtra("playerIn", 0);
        int playerMaxHP = getIntent().getIntExtra("playerMHP", 0);
        int playerMaxMP = getIntent().getIntExtra("playerMMP", 0);
        int playerCurrentHP = getIntent().getIntExtra("playerCHP", 0);
        int playerCurrentMP = getIntent().getIntExtra("playerCMP", 0);
    }
}
