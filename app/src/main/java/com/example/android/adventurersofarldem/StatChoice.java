package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;


public class StatChoice extends AppCompatActivity {

    public String pName;
    public String pClass;
    public int strength;
    public int agility;
    public int intellect;
    public int maxHP;
    public int maxMP;
    public int minStrength;
    public int minAgility;
    public int minIntellect;
    public int minMaxHP;
    public int minMaxMP;
    public int statsAvailable = 6;
    public int currentHP;
    public int currentMP;
    public int pExperience;
    public int pLevel;


    // Imports the characters existing stats which will be based on their class chosen, and then
    // converts these into local variables to be edited by the methods
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
        int playerExperience = getIntent().getIntExtra("playerExperience", 0);
        int playerLevel = getIntent().getIntExtra("playerLevel", 0);
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
        currentHP = playerCurrentHP;
        currentMP = playerCurrentMP;
        statsDisplay(statsAvailable);
        pName = playerName;
        pClass = playerClass;
        pExperience = playerExperience;
        pLevel = playerLevel;

    }

    //Submits updated stats and existing name and class to the confirmation intent

    public void submitStats(View view) {
        //String pName = pName;
        //String pClass = playerClass;
        Intent confirmIntent = new Intent(StatChoice.this, level1.class);
        confirmIntent.putExtra("playerStrength", strength);
        confirmIntent.putExtra("playerAgility", agility);
        confirmIntent.putExtra("playerIntellect", intellect);
        confirmIntent.putExtra("playerMaxHP", maxHP);
        confirmIntent.putExtra("playerMaxMP", maxMP);
        confirmIntent.putExtra("playerCurrentHP", currentHP);
        confirmIntent.putExtra("playerCurrentMP", currentMP);
        confirmIntent.putExtra("playerClass", pClass);
        confirmIntent.putExtra("playerName", pName);
        confirmIntent.putExtra("playerExperience", pExperience);
        confirmIntent.putExtra("playerLevel", pLevel);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }


    }

    //statsDisplay shows how many stats the user has remaining to use. Currently they don't have
    // to use any or all of them, this will be updated at later time.

    public void statsDisplay(int stat) {
        TextView statDisplay = (TextView) findViewById(R.id.statCounter);
        statDisplay.setText(String.valueOf(stat));
    }

    //strengthDisplay updates the number in between the two buttons to show the value of Strength

    public void strengthDisplay(int stat) {
        TextView strengthView = (TextView) findViewById(R.id.strength_number);
        strengthView.setText(String.valueOf(stat));
    }

    //increaseStrength checks if there are stats available, gives +1 to strength and takes an
    // available stat away.

    public void increaseStrength(View view) {
        if (statsAvailable > 0) {
            strength += 1;
            statsAvailable -= 1;
            strengthDisplay(strength);
            statsDisplay(statsAvailable);
        }
    }

    //decreaseStrength checks if the use has less than 6 (the max stats available on creation)
    // stats available, and if so will reduce strength by 1 and increase the number of stats
    // available by 1

    public void decreaseStrength(View view) {
        if (strength > minStrength) {

            if (statsAvailable < 6) {

                strength -= 1;
                statsAvailable += 1;

                strengthDisplay(strength);
                statsDisplay(statsAvailable);
            }
        }
    }

    //The above commands are then replicated below but for the different stats to be changed

    public void agilityDisplay(int stat) {
        TextView agilityView = (TextView) findViewById(R.id.agility_number);
        agilityView.setText(String.valueOf(stat));
    }

    public void increaseAgility(View view) {
        if (statsAvailable > 0) {

            agility += 1;
            statsAvailable -= 1;
            agilityDisplay(agility);
            statsDisplay(statsAvailable);
        }
    }

    public void decreaseAgility(View view) {
        if (agility > minAgility) {
            if (statsAvailable < 6) {
                agility -= 1;
                statsAvailable += 1;
                agilityDisplay(agility);
                statsDisplay(statsAvailable);
            }
        }
    }

    public void intellectDisplay(int stat) {
        TextView intellectView = (TextView) findViewById(R.id.intellect_number);
        intellectView.setText(String.valueOf(stat));
    }

    public void increaseIntellect(View view) {
        if (statsAvailable > 0) {

            intellect += 1;
            statsAvailable -= 1;
            intellectDisplay(intellect);
            statsDisplay(statsAvailable);
        }
    }

    public void decreaseIntellect(View view) {
        if (intellect > minIntellect) {
            if (statsAvailable < 6) {
                intellect -= 1;
                statsAvailable += 1;
                intellectDisplay(intellect);
                statsDisplay(statsAvailable);
            }
        }
    }

    public void maxHPDisplay(int stat) {
        TextView maxHPView = (TextView) findViewById(R.id.hp_number);
        maxHPView.setText(String.valueOf(stat));
    }

    public void increaseHP(View view) {
        if (statsAvailable > 0) {

            maxHP += 1;
            currentHP +=1;
            statsAvailable -= 1;
            maxHPDisplay(maxHP);
            statsDisplay(statsAvailable);
        }
    }

    public void decreaseHP(View view) {
        if (maxHP > minMaxHP) {
            if (statsAvailable < 6) {
                maxHP -= 1;
                currentHP -=1;
                statsAvailable += 1;
                maxHPDisplay(maxHP);
            }
            statsDisplay(statsAvailable);
        }
    }

    public void maxMPDisplay(int stat) {
        TextView maxMPView = (TextView) findViewById(R.id.mp_number);
        maxMPView.setText(String.valueOf(stat));
    }

    public void increaseMP(View view) {
        if (statsAvailable > 0) {

            maxMP += 1;
            statsAvailable -= 1;
            maxMPDisplay(maxMP);
            statsDisplay(statsAvailable);
        }
    }

    public void decreaseMP(View view) {
        if (maxMP > minMaxMP) {
            if (statsAvailable < 6) {
                maxMP -= 1;
                statsAvailable += 1;
                maxMPDisplay(maxMP);
                statsDisplay(statsAvailable);
            }
        }
    }
}




