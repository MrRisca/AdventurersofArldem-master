package com.example.android.adventurersofarldem.Quests.SlayTheLich;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.adventurersofarldem.Characters.Monster;
import com.example.android.adventurersofarldem.Characters.Player;
import com.example.android.adventurersofarldem.MazeGenerator;
import com.example.android.adventurersofarldem.Quests.ExploreTheMine.ExploreTheMineFightBigGhost;
import com.example.android.adventurersofarldem.Quests.ExploreTheMine.ExploreTheMineFightGoblin;
import com.example.android.adventurersofarldem.Quests.ExploreTheMine.ExploreTheMineFightMummy;
import com.example.android.adventurersofarldem.Quests.ExploreTheMine.ExploreTheMineFightOrc;
import com.example.android.adventurersofarldem.Quests.ExploreTheMine.ExploreTheMinePartFourFragment;
import com.example.android.adventurersofarldem.Quests.ExploreTheMine.ExploreTheMinePartTwoFragment;
import com.example.android.adventurersofarldem.R;

public class SlayTheLichActivity extends AppCompatActivity {

    public int playerOldExperience;
    public int playerNewExperience;
    public int playerOldGold;
    public int playerNewGold;
    public int playerOldLevel;
    public int x = 5;
    public int y = 5;
    public MazeGenerator questMaze = new MazeGenerator(x,y,1);
    public Monster monsterSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slay_the_lich);
        questMaze.display();
        playerOldExperience = Player.getInstance().getExperience();
        playerOldGold = Player.getInstance().getGold();
        playerOldLevel = Player.getInstance().getLevel();
        Player.getInstance().setQuestPosX(questMaze.getX());
        Player.getInstance().setQuestPosY(questMaze.getY());
        questMaze.selectEnemies();
        updateNavigation();
        loadFragment(new ExploreTheMinePartTwoFragment());
    }

    private void updateNavigation(){
        TextView locX = findViewById(R.id.locX);
        TextView locY = findViewById(R.id.locY);
        ImageView leftButton = findViewById(R.id.goWest);
        ImageView rightButton = findViewById(R.id.goEast);
        ImageView upButton = findViewById(R.id.goNorth);
        ImageView downButton = findViewById(R.id.goSouth);
        locX.setText(String.valueOf(Player.getInstance().getQuestPosX()));
        locY.setText(String.valueOf(Player.getInstance().getQuestPosY()));
        if (questMaze.canMoveWestFrom((Player.getInstance().getQuestPosX()), (Player.getInstance().getQuestPosY()))){
            leftButton.setImageResource(R.drawable.west);
        }


        else {
            leftButton.setImageResource(R.drawable.noiconshrunk);

        }
        if (questMaze.canMoveEastFrom((Player.getInstance().getQuestPosX()), (Player.getInstance().getQuestPosY()))){
            rightButton.setImageResource(R.drawable.east);

        }
        else {
            rightButton.setImageResource(R.drawable.noiconshrunk);
        }
        if (questMaze.canMoveNorthFrom((Player.getInstance().getQuestPosX()), (Player.getInstance().getQuestPosY()))){
            upButton.setImageResource(R.drawable.north);

        }
        else {
            upButton.setImageResource(R.drawable.noiconshrunk);

        }
        if (questMaze.canMoveSouthFrom((Player.getInstance().getQuestPosX()), (Player.getInstance().getQuestPosY()))){
            downButton.setImageResource(R.drawable.south);

        }
        else {
            downButton.setImageResource(R.drawable.noiconshrunk);

        }
    }

    private void loadFragment(Fragment fragment) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    private void checkRoomForMonster() {
        TextView mainTextField = findViewById(R.id.dungeonText);
        mainTextField.setText("You find nothing of interest in this room. Keep going or flee!");
        int[][] playerLocation = new int[Player.getInstance().getQuestPosX()][Player.getInstance().getQuestPosY()];
        if (questMaze.monsterLocation.contains(playerLocation)) {
            loadFragment(new ExploreTheMineFightGoblin());
        }
    }


    private void checkRoomForTreasure() {
        TextView mainTextField = findViewById(R.id.dungeonText);
        mainTextField.setText("You find nothing of interest in this room. Keep going or flee!");
        int[][] playerLocation = new int[Player.getInstance().getQuestPosX()][Player.getInstance().getQuestPosY()];
        if (questMaze.treasureLocation.contains(playerLocation)) {
            Player.getInstance().setGold(Player.getInstance().getGold() + 10);
            mainTextField.setText("You found 10GP worth of treasure!");
        }
    }

    public void checkRoomForBoss() {
        TextView mainTextField = findViewById(R.id.dungeonText);
        int[][] playerLocation = new int[Player.getInstance().getQuestPosX()][Player.getInstance().getQuestPosY()];
        int[][] bossLocation = new int[questMaze.getBossX()][questMaze.getBossY()];
        if (playerLocation.equals(bossLocation)) {
            mainTextField.setText("You see a spooky ghost!");
            loadFragment(new ExploreTheMineFightBigGhost());
            ImageView runAway = findViewById(R.id.runAway);
            runAway.setImageResource(R.drawable.treasurechest);
            runAway.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    continueQuest(view);
                }
            });
        }
    }

    public void checkRoom(){
        checkRoomForBoss();
        checkRoomForMonster();
        checkRoomForTreasure();
    }

    public void goLeft(View view) {
        if (questMaze.canMoveWestFrom(Player.getInstance().getQuestPosX(),Player.getInstance().getQuestPosY())) {
            if (Player.getInstance().getQuestPosY() > 1) {

                Player.getInstance().setQuestPosY(Player.getInstance().getQuestPosY());
                checkRoom();

            }
            updateNavigation();
        }
    }


    public void goRight(View view){
        if (questMaze.canMoveEastFrom(Player.getInstance().getQuestPosX(),Player.getInstance().getQuestPosY())) {
            if (Player.getInstance().getQuestPosY() < x) {

                Player.getInstance().setQuestPosY(Player.getInstance().getQuestPosY() + 1);
                checkRoom();

            }
            updateNavigation();
        }
    }


    public void goUp(View view){
        if (questMaze.canMoveNorthFrom(Player.getInstance().getQuestPosX(),Player.getInstance().getQuestPosY())) {
            if (Player.getInstance().getQuestPosX() > 1) {

                Player.getInstance().setQuestPosX(Player.getInstance().getQuestPosX() - 1);
                checkRoom();

            }
            updateNavigation();
        }
    }


    public void goDown(View view){
        if (questMaze.canMoveSouthFrom(Player.getInstance().getQuestPosX(),Player.getInstance().getQuestPosY())) {
            if (Player.getInstance().getQuestPosX() < y) {

                Player.getInstance().setQuestPosX(Player.getInstance().getQuestPosX() + 1);
                checkRoom();

            }
            updateNavigation();
        }
    }

    public void continueQuest(View view) {
        loadFragment(new ExploreTheMinePartFourFragment());
    }

}
