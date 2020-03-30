package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;

public class levelUp extends AppCompatActivity {

    public int enemyXP;
    public int playerExperience;
    public int xpToLevel;
    public int playerLevel;

    public levelUp(int pexp, int pl){
//        enemyXP = exp;
        playerExperience = pexp;
        playerLevel = pl;
    }

    public int xpGained(int enemyXP, int playerExperience){
        playerExperience += enemyXP;
        return playerExperience;
    }

    public int isLevelUp(int playerLevel, int playerExperience){
        xpGained(enemyXP, playerExperience);
        int xpNeeded = experienceNeeded(playerLevel);
        if (xpNeeded < (playerExperience)) {
            return 1;
        }
        else return 0;
    }

    public int levelsGained(){
    int levelsGained;
    if (isLevelUp(playerLevel, playerExperience) == 1)
    levelsGained = 1;
    else levelsGained = 0;
    return levelsGained;
    }

    public int experienceNeeded(int playerLevel){

        if (playerLevel == 1){
            return 5;
            }
        else if (playerLevel == 2){
            return 15;
        }
        else if (playerLevel == 3){
            return 30;
        }
        else if (playerLevel == 4){
            return 60;
        }
        else if (playerLevel == 5){
            return 120;
        }
        else if (playerLevel == 6) {
            return 240;
        }
        else if (playerLevel == 7){
            return 480;
        }
        else if (playerLevel == 8){
            return 960;
        }
        else if (playerLevel == 9){
            return 1920;
        }
        else if (playerLevel == 10){
            return 3840;
        }
        else if (playerLevel == 11) {
            return 7680;
        }
        else return 8000;
    }


}
