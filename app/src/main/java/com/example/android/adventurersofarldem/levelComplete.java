package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class levelComplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_level_complete);
        playerName = getIntent().getStringExtra("playerName");
        playerClass = getIntent().getStringExtra("playerClass");
        playerStrength = getIntent().getIntExtra("playerStrength", 0);
        playerAgility = getIntent().getIntExtra("playerAgility", 0);
        playerIntellect = getIntent().getIntExtra("playerIntellect", 0);
        playerMaxHP = getIntent().getIntExtra("playerMaxHP", 0);
        playerMaxMP = getIntent().getIntExtra("playerMaxMP",0);
        playerCurrentHP = getIntent().getIntExtra("playerCurrentHP", 0);
        playerCurrentMP = getIntent().getIntExtra("playerCurrentMP", 0);
        pArmorClass  = ((10 +(playerAgility / 2)) - 5);
        playerExperience = getIntent().getIntExtra("playerExperience", 0);
        playerLevel = getIntent().getIntExtra("playerLevel", 0);
        playerGold = getIntent().getIntExtra("playerGold", playerGold);
        TextView confirmPlayerGold = (TextView) findViewById(R.id.gold_count);
        confirmPlayerGold.setText(String.valueOf(playerGold));
    }

=======
       setContentView(R.layout.activity_level_complete);
    }
>>>>>>> parent of 0a0fdf8... Updated gold system
}
