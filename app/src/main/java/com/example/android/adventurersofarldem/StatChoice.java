package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StatChoice extends AppCompatActivity {

    public String playerName;
    public String playerClass;
    public int playerStrength;
    public int playerAgility;
    public int playerIntellect;
    public int playerMaxHP;
    public int playerMaxMP;
    public int playerCurrentHP;
    public int playerCurrentMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat_choice);
        String playerName = getIntent().getStringExtra("playerName");
        String playerClass = getIntent().getStringExtra("playerClass");
        int playerStrength = getIntent().getIntExtra("playerSt", 0);
        int playerAgility = getIntent().getIntExtra("playerAg", 0);
        int playerIntellect = getIntent().getIntExtra("playerIn", 0);
        int playerMaxHP = getIntent().getIntExtra("playerMHP", 0);
        int playerMaxMP = getIntent().getIntExtra("playerMMP", 0);
        int playerCurrentHP = getIntent().getIntExtra("playerCHP", 0);
        int playerCurrentMP = getIntent().getIntExtra("playerCMP", 0);
        strengthDisplay(playerStrength);
        agilityDisplay(playerAgility);
        intellectDisplay(playerIntellect);
        maxHPDisplay(playerMaxHP);
        maxMPDisplay(playerMaxMP);
    }

    public void strengthDisplay(int stat) {
        TextView strengthView = (TextView) findViewById(R.id.strength_number);
        strengthView.setText(String.valueOf(stat));
    }

    public void increaseStrength(View view) {
        playerStrength += 1;

        strengthDisplay(playerStrength);
    }

    public void decreaseStrength(View view) {
        playerStrength -= 1;

        strengthDisplay(playerStrength);
    }

    public void agilityDisplay(int stat) {
        TextView agilityView = (TextView) findViewById(R.id.agility_number);
        agilityView.setText(String.valueOf(stat));
    }

    public void increaseAgility(View view) {
        playerAgility += 1;

        agilityDisplay(playerAgility);
    }

    public void decreaseAgility(View view) {
        playerAgility -= 1;

        agilityDisplay(playerAgility);
    }

    public void intellectDisplay(int stat) {
        TextView intellectView = (TextView) findViewById(R.id.intellect_number);
        intellectView.setText(String.valueOf(stat));
    }

    public void increaseIntellect(View view) {
        playerIntellect += 1;

        intellectDisplay(playerIntellect);
    }

    public void decreaseIntellect(View view) {
        playerIntellect -= 1;

        intellectDisplay(playerIntellect);
    }

    public void maxHPDisplay(int stat) {
        TextView maxHPView = (TextView) findViewById(R.id.hp_number);
        maxHPView.setText(String.valueOf(stat));
    }

    public void increaseHP(View view) {
        playerMaxHP += 1;

        maxHPDisplay(playerMaxHP);
    }

    public void decreaseHP(View view) {
        playerMaxHP -= 1;

        maxHPDisplay(playerMaxHP);
    }

    public void maxMPDisplay(int stat) {
        TextView maxMPView = (TextView) findViewById(R.id.mp_number);
        maxMPView.setText(String.valueOf(stat));
    }

    public void increaseMP(View view) {
        playerMaxMP += 1;

        maxMPDisplay(playerMaxMP);
    }

    public void decreaseMP(View view) {
        playerMaxMP -= 1;

        maxMPDisplay(playerMaxMP);
    }
}




