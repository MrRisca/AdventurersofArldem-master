package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class levelComplete extends AppCompatActivity {

    public String playerName;
    public String playerClass;
    public int playerStrength;
    public int playerAgility;
    public int playerIntellect;
    public int playerMaxHP;
    public int playerMaxMP;
    public int playerCurrentMP;
    public int playerCurrentHP;
    public int pArmorClass;
    public int playerExperience;
    public int playerLevel;
    public int playerGold = 1;
    public int levelComplete = 0;
    public int playerOldExperience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        playerOldExperience = getIntent().getIntExtra("playerOldExperience", 0);
        playerLevel = getIntent().getIntExtra("playerLevel", 0);
        playerGold = getIntent().getIntExtra("playerGold", playerGold);
        int experienceDifference = playerExperience - playerOldExperience;
        TextView confirmExperienceDifference = (TextView) findViewById(R.id.experience_gained);
        confirmExperienceDifference.setText(String.valueOf(experienceDifference));
        TextView confirmPlayerGold = (TextView) findViewById(R.id.gold_count);
        confirmPlayerGold.setText(String.valueOf(playerGold));
    }

    public void continueGame(View view){
        Intent confirmIntent = new Intent(levelComplete.this, fight_launcher.class);
        confirmIntent.putExtra("playerStrength", playerStrength);
        confirmIntent.putExtra("playerAgility", playerAgility);
        confirmIntent.putExtra("playerIntellect", playerIntellect);
        confirmIntent.putExtra("playerMaxHP", playerMaxHP);
        confirmIntent.putExtra("playerMaxMP", playerMaxMP);
        confirmIntent.putExtra("playerCurrentHP", playerCurrentHP);
        confirmIntent.putExtra("playerCurrentMP", playerCurrentMP);
        confirmIntent.putExtra("playerClass", playerClass);
        confirmIntent.putExtra("playerName", playerName);
        confirmIntent.putExtra("playerExperience", playerExperience);
        confirmIntent.putExtra("playerLevel", playerLevel);
        confirmIntent.putExtra("playerGold", playerGold);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }
    }

}
