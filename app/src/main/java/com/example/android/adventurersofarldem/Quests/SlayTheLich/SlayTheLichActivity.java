package com.example.android.adventurersofarldem.Quests.SlayTheLich;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.adventurersofarldem.Characters.Bandit;
import com.example.android.adventurersofarldem.Characters.BigGhost;
import com.example.android.adventurersofarldem.Characters.BigRat;
import com.example.android.adventurersofarldem.Characters.Djinni;
import com.example.android.adventurersofarldem.Characters.Dragon;
import com.example.android.adventurersofarldem.Characters.Goblin;
import com.example.android.adventurersofarldem.Characters.Minotaur;
import com.example.android.adventurersofarldem.Characters.Monster;
import com.example.android.adventurersofarldem.Characters.Mummy;
import com.example.android.adventurersofarldem.Characters.Orc;
import com.example.android.adventurersofarldem.Characters.Player;
import com.example.android.adventurersofarldem.Characters.Troll;
import com.example.android.adventurersofarldem.Characters.Warg;
import com.example.android.adventurersofarldem.MazeGenerator;
import com.example.android.adventurersofarldem.Quests.DungeonRewardFragment;
import com.example.android.adventurersofarldem.Quests.ExploreTheMine.ExploreTheMineFightBigGhost;
import com.example.android.adventurersofarldem.Quests.ExploreTheMine.ExploreTheMineFightGoblin;
import com.example.android.adventurersofarldem.Quests.ExploreTheMine.ExploreTheMineFightMummy;
import com.example.android.adventurersofarldem.Quests.ExploreTheMine.ExploreTheMineFightOrc;
import com.example.android.adventurersofarldem.Quests.ExploreTheMine.ExploreTheMinePartFourFragment;
import com.example.android.adventurersofarldem.Quests.ExploreTheMine.ExploreTheMinePartTwoFragment;
import com.example.android.adventurersofarldem.R;
import com.example.android.adventurersofarldem.Room;
import com.example.android.adventurersofarldem.RoomContent;
import com.example.android.adventurersofarldem.Treasure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SlayTheLichActivity extends AppCompatActivity {

    public int playerOldExperience;
    public int playerNewExperience;
    public int playerOldGold;
    public int playerNewGold;
    public int playerOldLevel;
    public int x = 5;
    public int y = 5;
    public int startingX;
    public int startingY;
    public int bossX;
    public int bossY;
    public int difficultyLevel = 1;
    public MazeGenerator questMaze;
    public Monster monsterSelected;
    public int playerPosX;
    public int playerPosY;
    HashMap<Room, List<RoomContent>> roomContents= new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slay_the_lich);
        questMaze = new MazeGenerator(x,y);
        questMaze.display();
        playerOldExperience = Player.getInstance().getExperience();
        playerOldGold = Player.getInstance().getGold();
        playerOldLevel = Player.getInstance().getLevel();
        setStartingPositions();
        setBossStartingPosition();
        int numberOfTreasures = 5;

        selectEnemies();
        updateNavigation();
        loadFragment(new ExploreTheMinePartTwoFragment());
        System.out.println("X in Act " +playerPosX+ " Y in Act "+playerPosY);
        addTreasurechests(numberOfTreasures);
        ArrayList<RoomContent> treasureContent = new ArrayList<>();
        ArrayList<RoomContent> aRoomContent = new ArrayList<>();
        ArrayList<RoomContent> bRoomContent = new ArrayList<>();
        Room treasureRoom = new Room(1,1);
        roomContents.put(treasureRoom, treasureContent);
        aRoomContent.add(monsterSelected);
        bRoomContent.add(new BigGhost());
        Room room1 = new Room(1,1);
        Room room2 = new Room(2,3);
        Room room3 = new Room(3,1);
        Room room4 = new Room(4,2);
        Room room5 = new Room(3,3);
        Room bossRoom = new Room(bossX, bossY);
        roomContents.put(room1, aRoomContent);
        roomContents.put(room2, aRoomContent);
        roomContents.put(room3, aRoomContent);
        roomContents.put(room4, aRoomContent);
        roomContents.put(room5, aRoomContent);
        roomContents.put(bossRoom, bRoomContent);


        System.out.println("Room1 = "+roomContents.get(room1));
        System.out.println("Boss Room = "+roomContents.get(bossRoom));

    }


    public void setStartingPositions(){
        Random rand = new Random();
        startingX = 0;
        startingY = 1;

    }

    public void setBossStartingPosition(){
        Random rand = new Random();
        bossX = 3;
        bossY = 3;
        //bossX = rand.nextInt((x - 2) )+ 1;
        //bossY = rand.nextInt((y - 2)) + 1;
        if ((bossX == startingX) && bossX != x){
            bossX = x -1;
        }
        else if((bossY == startingY) && bossY != y){
            bossY = y -1;

        }

    }

    public void addTreasurechests(int numberOfChests){
        for (int i = 0; i < numberOfChests; i++){
            ArrayList<RoomContent> aRoomContent = new ArrayList<>();
            aRoomContent.add(new Treasure());
            Random rand = new Random();
            int tcX = rand.nextInt(x - 2) + 1;
            int tcY = rand.nextInt(x - 2) + 1;
            Room room = new Room(tcX, tcY);
            roomContents.put(room, aRoomContent);
        }

    }



    public int getX(){
        return startingX;
    }
    public void setX(int newX){
        startingX = newX;
    }

    public int getY(){
        return startingY;
    }

    public void setY(int newY){
        startingY = newY;
    }

    public int getBossX(){
        return bossX;
    }

    public int getBossY(){
        return bossY;
    }

    public Monster selectEnemies(){
        Map<Integer, Monster> monsterMap = new HashMap<Integer, Monster>();
        Monster orc = new Orc();
        Monster goblin = new Goblin();
        Monster bandit = new Bandit();
        Monster bigRat = new BigRat();
        Monster djinni = new Djinni();
        Monster dragon = new Dragon();
        Monster mummy = new Mummy();
        Monster troll = new Troll();
        Monster warg = new Warg();
        Monster minotaur = new Minotaur();
        monsterMap.put(0, bigRat);
        monsterMap.put(1, goblin);
        monsterMap.put(2, bandit);
        monsterMap.put(3, orc);
        monsterMap.put(4, warg);
        monsterMap.put(5, troll);
        monsterMap.put(6, mummy);
        monsterMap.put(7, djinni);
        monsterMap.put(8, minotaur);
        monsterMap.put(9, dragon);
        Random rand = new Random();
        int monsterRoll = rand.nextInt(difficultyLevel + 2);
        if (monsterRoll > 7){
            monsterRoll = 8;
        }
        monsterSelected = monsterMap.get(monsterRoll);
        return monsterSelected;
    }

    private void updateNavigation(){
        TextView locX = findViewById(R.id.locX);
        TextView locY = findViewById(R.id.locY);
        ImageView leftButton = findViewById(R.id.goWest);
        ImageView rightButton = findViewById(R.id.goEast);
        ImageView upButton = findViewById(R.id.goNorth);
        ImageView downButton = findViewById(R.id.goSouth);
       locX.setText(String.valueOf(playerPosX));
        locY.setText(String.valueOf(playerPosY));
        if (questMaze.canMoveWestFrom((playerPosX), (playerPosY))){
            leftButton.setImageResource(R.drawable.west);
        }


        else {
            leftButton.setImageResource(R.drawable.noiconshrunk);

        }
        if (questMaze.canMoveEastFrom(playerPosX,  playerPosY)){
            rightButton.setImageResource(R.drawable.east);

        }
        else {
            rightButton.setImageResource(R.drawable.noiconshrunk);
        }
        if (questMaze.canMoveNorthFrom(playerPosX,  playerPosY)){
            upButton.setImageResource(R.drawable.north);

        }
        else {
            upButton.setImageResource(R.drawable.noiconshrunk);

        }
        if (questMaze.canMoveSouthFrom(playerPosX,  playerPosY)){
            downButton.setImageResource(R.drawable.south);

        }
        else {
            downButton.setImageResource(R.drawable.noiconshrunk);

        }
        System.out.println("X in UpdNav " +playerPosX+ " Y in UpdNav "+playerPosY);
        //draw(playerPosX, playerPosY);

    }

    private void loadFragment(Fragment fragment) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    private void checkRoomForMonster() {


        Room room = new Room(playerPosX, playerPosY);
        List<RoomContent> thisRoomContents = roomContents.get(room);
        if (thisRoomContents != null) {

            for (RoomContent content : thisRoomContents)

                if (content instanceof Monster) {
                    System.out.println("yes is instance of monster");
                    loadFragment(new ExploreTheMineFightOrc());
                }
        }
    }


    private void checkRoomForTreasure() {
        TextView mainTextField = findViewById(R.id.dungeonText);
        mainTextField.setText("You find nothing of interest in this room. Keep going or flee!");
        Room room = new Room(playerPosX, playerPosY);
        List<RoomContent> thisRoomContents = roomContents.get(room);
        if (thisRoomContents != null) {

            for (RoomContent content : thisRoomContents)

                if (content instanceof Treasure) {
                    mainTextField.setText("You find 20 gold!");
                    Player.getInstance().setGold(Player.getInstance().getGold() + 20);
                }
        }
    }

    public void checkRoom(){
        checkRoomForTreasure();
        checkRoomForBoss();
        checkRoomForMonster();
        System.out.println("X in checkRoom " +playerPosX+ " Y "+playerPosY);

    }

    public void checkRoomForBoss() {
        Room room = new Room(playerPosX, playerPosY);
        System.out.println("CheckBoss X "+playerPosX+" CheckBoss Y "+playerPosY);
        System.out.println("room = "+room);
        List<RoomContent> thisRoomContents = roomContents.get(room);
        System.out.println("RoomContent = " +thisRoomContents);
        if (thisRoomContents != null) {
            for (RoomContent content : thisRoomContents)

                if (content instanceof BigGhost) {
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
    }

    public void draw(int row, int col){
        for (int i = 0; i < y; i++) {
            // draw the north edge
            for (int j = 0; j < x; j++) {
                System.out.print((questMaze.maze[j][i] & 1) == 0 ? "+---" : "+   ");
                if (j == playerPosX && i == playerPosY){
                    System.out.println("X");
            }
            }
            System.out.println("+");
            // draw the west edge
            for (int j = 0; j < x; j++) {
                System.out.print((questMaze.maze[j][i] & 8) == 0 ? "|   " : "    ");
            }
            System.out.println("|");
        }
        // draw the bottom line
        for (int j = 0; j < x; j++) {
            System.out.print("+---");
        }
        System.out.println("+");



    }



    public void goLeft(View view) {
        if (questMaze.canMoveWestFrom(playerPosX,playerPosY)) {
            if (playerPosX > 0) {
                playerPosX -= 1;
                checkRoom();


            }
            updateNavigation();
        }
    }


    public void goRight(View view){
        if (questMaze.canMoveEastFrom(playerPosX,playerPosY)) {
            if (playerPosX < (y -1)) {
                playerPosX += 1;
                checkRoom();


            }
            updateNavigation();
        }
    }


    public void goUp(View view){
        if (questMaze.canMoveNorthFrom(playerPosX,playerPosY)) {
            if (playerPosY> 0) {
                playerPosY -=1;
                checkRoom();


            }
            updateNavigation();
        }
    }


    public void goDown(View view){
        if (questMaze.canMoveSouthFrom(playerPosX,playerPosY)) {
            if (playerPosY < (y -1)) {
                playerPosY += 1;
                checkRoom();


            }
            updateNavigation();
        }
    }

    public void continueQuest(View view) {
        loadFragment(new DungeonRewardFragment());
    }

}