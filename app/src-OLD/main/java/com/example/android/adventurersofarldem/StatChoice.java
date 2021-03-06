package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StatChoice extends AppCompatActivity {

    public String playerName;
    public String playerClass;
    public int strength;
    public int agility;
    public int intellect;
    public int maxHP;
    public int maxMP;
    public int playerCurrentHP;
    public int playerCurrentMP;
    public int minStrength;
    public int minAgility;
    public int minIntellect;
    public int minMaxHP;
    public int minMaxMP;
    public int statsAvailable = 6;

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
        strength = playerStrength;
        agility = playerAgility;
        intellect = playerIntellect;
        maxHP = playerMaxHP;
        maxMP = playerMaxMP;
        minStrength = playerStrength;
        minAgility = playerAgility;
        minIntellect = playerIntellect;
        minMaxHP = playerMaxHP;
        minMaxMP = playerMaxMP;
    }

    public void strengthDisplay(int stat) {
        TextView strengthView = (TextView) findViewById(R.id.strength_number);
        strengthView.setText(String.valueOf(stat));
    }

    public void increaseStrength(View view) {
        if (statsAvailable > 0) {
        strength += 1;
        statsAvailable -= 1;
        strengthDisplay(strength); }
    }

    public void decreaseStrength(View view) {
        if (strength > minStrength) {

            if (statsAvailable < 6) {

                strength -= 1;
                statsAvailable +=1;

            strengthDisplay(strength); } }
    }

    public void agilityDisplay(int stat) {
        TextView agilityView = (TextView) findViewById(R.id.agility_number);
        agilityView.setText(String.valueOf(stat));
    }

    public void increaseAgility(View view) {
        if (statsAvailable > 0) {

            agility += 1;
            statsAvailable -= 1;
        agilityDisplay(agility); }
    }

    public void decreaseAgility(View view) {
        if (agility > minAgility) {
            if (statsAvailable < 6) {
            agility -= 1;
            statsAvailable += 1;
            agilityDisplay(agility); } }
    }

    public void intellectDisplay(int stat) {
        TextView intellectView = (TextView) findViewById(R.id.intellect_number);
        intellectView.setText(String.valueOf(stat));
    }

    public void increaseIntellect(View view) {
        if (statsAvailable > 0) {

            intellect += 1;
            statsAvailable -= 1;
        intellectDisplay(intellect); }
    }

    public void decreaseIntellect(View view) {
        if (intellect > minIntellect) {
            if (statsAvailable < 6) {
            intellect -= 1;
            statsAvailable += 1;
            intellectDisplay(intellect); } }
    }

    public void maxHPDisplay(int stat) {
        TextView maxHPView = (TextView) findViewById(R.id.hp_number);
        maxHPView.setText(String.valueOf(stat));
    }

    public void increaseHP(View view) {
        if (statsAvailable > 0) {

            maxHP += 1;
            statsAvailable -= 1;
        maxHPDisplay(maxHP); }
    }

    public void decreaseHP(View view) {
        if (maxHP > minMaxHP) {
            if (statsAvailable < 6) {
            maxHP -= 1;
            statsAvailable += 1;
            maxHPDisplay(maxHP); } }
    }

    public void maxMPDisplay(int stat) {
        TextView maxMPView = (TextView) findViewById(R.id.mp_number);
        maxMPView.setText(String.valueOf(stat));
    }

    public void increaseMP(View view) {
        if (statsAvailable > 0) {

            maxMP += 1;
            statsAvailable -= 1;
        maxMPDisplay(maxMP); }
    }

    public void decreaseMP(View view) {
        if (maxMP > minMaxMP) {
            if (statsAvailable < 6) {
            maxMP -= 1;
            statsAvailable += 1;
            maxMPDisplay(maxMP); } }
    }
}




