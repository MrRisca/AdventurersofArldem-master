package com.example.android.adventurersofarldem.Quests.ExploreTheMine;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.android.adventurersofarldem.Characters.Player;
import com.example.android.adventurersofarldem.R;

import com.example.android.adventurersofarldem.fight_launcher;


public class ExploreTheMinePartTwoActivity extends AppCompatActivity {

    public int levelComplete = 0;


    public String playerPosition;
    public MineMapClass mineMapOverall;
    public Boolean canPlayerGoLeft, canPlayerGoRight, canPlayerGoUp, canPlayerGoDown;
    public int playerOldExperience;
    public int playerNewExperience;
    public int playerOldGold;
    public int playerNewGold;
    public int playerOldLevel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_the_mine_part_two);
        Player.getInstance().setQuestPosX(6);
        Player.getInstance().setQuestPosY(2);
        playerOldExperience = Player.getInstance().getExperience();
        playerOldGold = Player.getInstance().getGold();
        playerOldLevel = Player.getInstance().getLevel();
        mineMapOverall = new MineMapClass();
        playerPosition = mineMapOverall.mineMap[Player.getInstance().getQuestPosX()][Player.getInstance().getQuestPosY()];
        //Import the Player's name, class and stats from where they just entered them

        updateNavigation();
        loadFragment(new ExploreTheMinePartTwoFragment());

    }

    private void updateNavigation(){
        playerPosition = mineMapOverall.mineMap[Player.getInstance().getQuestPosX()][Player.getInstance().getQuestPosY()];
        ImageView leftButton = findViewById(R.id.goWest);
        ImageView rightButton = findViewById(R.id.goEast);
        ImageView upButton = findViewById(R.id.goNorth);
        ImageView downButton = findViewById(R.id.goSouth);
        if (mineMapOverall.mineMapGoLeft[Player.getInstance().getQuestPosX()][Player.getInstance().getQuestPosY()]){
            leftButton.setImageResource(R.drawable.west);
            canPlayerGoLeft = true;
        }
        else {
            leftButton.setImageResource(R.drawable.noiconshrunk);
            canPlayerGoLeft = false;
        }
        if (mineMapOverall.mineMapGoRight[Player.getInstance().getQuestPosX()][Player.getInstance().getQuestPosY()]){
            rightButton.setImageResource(R.drawable.east);
            canPlayerGoRight = true;
        }
        else {
            rightButton.setImageResource(R.drawable.noiconshrunk);
            canPlayerGoRight = false;
        }
        if (mineMapOverall.mineMapGoUp[Player.getInstance().getQuestPosX()][Player.getInstance().getQuestPosY()]){
            upButton.setImageResource(R.drawable.north);
            canPlayerGoUp = true;
        }
        else {
            upButton.setImageResource(R.drawable.noiconshrunk);
            canPlayerGoUp = false;
        }
        if (mineMapOverall.mineMapGoDown[Player.getInstance().getQuestPosX()][Player.getInstance().getQuestPosY()]){
            downButton.setImageResource(R.drawable.south);
            canPlayerGoDown = true;
        }
        else {
            downButton.setImageResource(R.drawable.noiconshrunk);
            canPlayerGoDown = false;
        }
    }

    private void loadFragment(Fragment fragment) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    //mineMap is the implementation of the maze.
    //T = Treasure
    //B = Boss (obviously has loot too)
    //O = Orc
    //G = Goblin
    //E = Empty
    @SuppressLint("SetTextI18n")
    private void checkRoom(){
        playerPosition = mineMapOverall.mineMap[Player.getInstance().getQuestPosX()][Player.getInstance().getQuestPosY()];
        TextView mainTextField = findViewById(R.id.dungeonText);
        if (playerPosition.equals("E")){
            mainTextField.setText("You find nothing of interest in this room. Keep going or flee!");
        }
        if (playerPosition.equals("G")){
            mainTextField.setText("You see a hideous Goblin");
            loadFragment(new ExploreTheMineFightGoblin());
            mineMapOverall.updateMineMap(Player.getInstance().getQuestPosX(),Player.getInstance().getQuestPosY());
        }
        if (playerPosition.equals("O")){
            mainTextField.setText("You see a hideous Orc");
            loadFragment(new ExploreTheMineFightOrc());
            mineMapOverall.updateMineMap(Player.getInstance().getQuestPosX(),Player.getInstance().getQuestPosY());
        }
        if (playerPosition.equals("M")){
            mainTextField.setText("You see a hideous Mummy");
            loadFragment(new ExploreTheMineFightMummy());
            mineMapOverall.updateMineMap(Player.getInstance().getQuestPosX(),Player.getInstance().getQuestPosY());
        }
        if (playerPosition.equals("T")){
            Player.getInstance().setGold(Player.getInstance().getGold() + 20);
            mainTextField.setText("You have found 20 gold!");
            mineMapOverall.updateMineMap(Player.getInstance().getQuestPosX(),Player.getInstance().getQuestPosY());
        }
        if (playerPosition.equals("B")){
            mainTextField.setText("You see a spooky ghost!");
            loadFragment(new ExploreTheMineFightBigGhost());
            ImageView runAway = findViewById(R.id.runAway);
            runAway.setImageResource(R.drawable.treasurechest);
            canPlayerGoDown = false;
            canPlayerGoUp = false;
            canPlayerGoRight = false;
            canPlayerGoLeft = false;
            mineMapOverall.updateMineMap(Player.getInstance().getQuestPosX(),Player.getInstance().getQuestPosY());
            runAway.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    continueQuest(view);
                }
            });
        }
    }


    public void goLeft(View view) {
        if (canPlayerGoLeft) {
            if (Player.getInstance().getQuestPosY() > 0) {
                Player.getInstance().setQuestPosY(Player.getInstance().getQuestPosY() - 1);
                checkRoom();
            }
            updateNavigation();
        }
    }


    public void goRight(View view){
        if (canPlayerGoRight) {
            if (Player.getInstance().getQuestPosY() < 4) {
                Player.getInstance().setQuestPosY(Player.getInstance().getQuestPosY() + 1);

                checkRoom();
            }
            updateNavigation();
        }
    }


    public void goUp(View view){
        if (canPlayerGoUp) {
            if (Player.getInstance().getQuestPosX() > 0) {
                Player.getInstance().setQuestPosX(Player.getInstance().getQuestPosX() - 1);

                checkRoom();
            }
            updateNavigation();
        }
    }


    public void goDown(View view){
        if (canPlayerGoDown) {
            if (Player.getInstance().getQuestPosX() < 6) {
                Player.getInstance().setQuestPosX(Player.getInstance().getQuestPosX() + 1);

                checkRoom();
            }
            updateNavigation();
        }
    }



    public void runAway(View view) {
        Intent confirmIntent = new Intent(ExploreTheMinePartTwoActivity.this, fight_launcher.class);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent);
        }
    }

    public void continueQuest(View view) {
            loadFragment(new ExploreTheMinePartFourFragment());
    }
}