package com.example.android.adventurersofarldem.Quests.SlayTheBigRatQuests;

import android.app.Activity;
import android.content.Intent;

import com.example.android.adventurersofarldem.Characters.BigRat;
import com.example.android.adventurersofarldem.Characters.Monster;
import com.example.android.adventurersofarldem.Characters.Player;
import com.example.android.adventurersofarldem.Items.Equippable;
import com.example.android.adventurersofarldem.Items.Equippables.HatOfStrength;
import com.example.android.adventurersofarldem.Items.Equippables.HatOfWisdom;
import com.example.android.adventurersofarldem.Quests.Quest;
import com.example.android.adventurersofarldem.levelUp;

public class SlayTheBigRatQuest extends Quest {
    private static int questExperience = 20;
    public int playerOldExperience;
    public static int playerNewExperience;
    public int playerOldGold;
    public static int playerNewGold;
    public int minimumLevel = 1;
    Monster monster = new BigRat();
    public static int questGold = 30;

    public SlayTheBigRatQuest() {
    }

    public int getMinimumLevel() {
        return minimumLevel;
    }

    public void startQuest(Activity activity){
        Intent confirmIntent = new Intent(activity, SlayTheBigRatPartOneActivity.class);
    }

    public static Equippable questRewardOne(){
        return new HatOfWisdom();
    }


    public static Equippable questRewardTwo(){
        return new HatOfStrength();
    }

    public static int getQuestExperience(){
        return questExperience;
    }

    public static int getQuestGold(){
        return questGold;
    }

    public static void completeQuest() {
        playerNewExperience = Player.getInstance().experience + getQuestExperience();
        playerNewGold = Player.getInstance().gold + getQuestGold();
        Player.getInstance().setExperience(playerNewExperience);
        Player.getInstance().setGold(playerNewGold);
        levelUp check = new levelUp(playerNewExperience, Player.getInstance().getExperience());
        int experienceNeeded = check.experienceNeeded(Player.getInstance().level);
        if (experienceNeeded < Player.getInstance().getExperience()) {
            Player.getInstance().setLevel(Player.getInstance().getLevel() + 1);
            Player.getInstance().setAvailablePoints(Player.getInstance().getAvailablePoints() + 1);
        }


    }
}
