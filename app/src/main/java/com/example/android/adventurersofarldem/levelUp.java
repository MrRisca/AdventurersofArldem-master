package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;

public class levelUp extends AppCompatActivity {

    public int enemyXP;
    public int playerExperience;
    public int xpToLevel;
    public int playerLevel;

    public levelUp(int exp, int pexp, int pl){
        enemyXP = exp;
        playerExperience = pexp;
        playerLevel = pl;
    }

    public int xpGained(int enemyXP, int playerExperience){
        playerExperience += enemyXP;
        return playerExperience;
    }

    public int isLevelUp(int playerLevel, int playerExperience){
        xpToLevel = playerLevel * 5;
        if (xpToLevel < playerExperience) {
            return 1;
        }
        else return 0;
    }


}
