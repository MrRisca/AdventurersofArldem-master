package com.example.android.adventurersofarldem;

import android.location.Location;
import android.os.Bundle;

import com.example.android.adventurersofarldem.Characters.Bandit;
import com.example.android.adventurersofarldem.Characters.BigRat;
import com.example.android.adventurersofarldem.Characters.Djinni;
import com.example.android.adventurersofarldem.Characters.Dragon;
import com.example.android.adventurersofarldem.Characters.Goblin;
import com.example.android.adventurersofarldem.Characters.Monster;
import com.example.android.adventurersofarldem.Characters.Mummy;
import com.example.android.adventurersofarldem.Characters.Orc;
import com.example.android.adventurersofarldem.Characters.Troll;
import com.example.android.adventurersofarldem.Characters.Warg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class MazeGenerator {
    private int x;
    private int y;
    private final int[][] maze;
    private int difficultyLevel;
    private int startingX;
    private int startingY;
    private int bossX;
    private int bossY;
    private int playerPosX;
    private int playerPosY;
    public Monster monsterSelected;
    public List<int[][]> monsterLocation = new ArrayList<>();
    public List<int[][]> treasureLocation = new ArrayList<>();

    public MazeGenerator(int x, int y, int difficultyLevel) {
        this.x = x;
        this.y = y;
        this.difficultyLevel = difficultyLevel;
        int numberOfEnemies = difficultyLevel * 6;
        int numberOfTreasure = difficultyLevel * 6;
        setStartingPositions();
        setBossStartingPosition();
        selectEnemies();
        for (int i = 0; i < numberOfEnemies; i++){
            int monsterSpawnX = setMonsterSpawnX();
            int monsterSpawnY = setMonsterSpawnY();
            int[][] monsterSpawn = new int[monsterSpawnX][monsterSpawnY];
            if (monsterSpawnX != bossX || monsterSpawnY != bossY){
                monsterLocation.add(monsterSpawn);
            }
        }
        for (int i = 0; i < numberOfTreasure; i++){
            int treasureSpawnX = setTreasureSpawnX();
            int treasureSpawnY = setTreasureSpawnY();
            int[][] treasureSpawn = new int[treasureSpawnX][treasureSpawnY];
                treasureLocation.add(treasureSpawn);
            }


        maze = new int[this.x][this.y];
        generateMaze(0, 0);

        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[i].length; j++){
                int cell = maze[i][j];

                System.out.println("Row "+i+" column "+j+" can move:");
                String dirString = "";
                for(DIR direction : DIR.values()){
                    if((cell & direction.bit) != 0){
                        dirString += direction.name();
                    }
                }
                System.out.println(dirString);
            }
        }
    }

    public void setStartingPositions(){
        Random rand = new Random();
        startingX = 0;
        startingY = 0;

    }

    public void setBossStartingPosition(){
        Random rand = new Random();
        bossX = rand.nextInt((x - 2) + 1);
        bossY = rand.nextInt((y - 2) + 1);
        if ((bossX == startingX) && bossX != x){
            bossX = x;
        }
        else if((bossY == startingY) && bossY != y){
            bossY = y;

        }

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
        monsterMap.put(0, bigRat);
        monsterMap.put(1, goblin);
        monsterMap.put(2, bandit);
        monsterMap.put(3, orc);
        monsterMap.put(4, warg);
        monsterMap.put(5, troll);
        monsterMap.put(6, mummy);
        monsterMap.put(7, djinni);
        monsterMap.put(8, dragon);
        Random rand = new Random();
        int monsterRoll = rand.nextInt(difficultyLevel + 2);
        if (monsterRoll > 7){
            monsterRoll = 8;
        }
        monsterSelected = monsterMap.get(monsterRoll);
        return monsterSelected;
    }

    public int setMonsterSpawnX(){
        Random rand = new Random();
        int monsterX = rand.nextInt((x - 2) + 1);
        return monsterX;
    }

    public int setMonsterSpawnY(){
        Random rand = new Random();
        int monsterY = rand.nextInt((y - 2) + 1);
        return monsterY;
    }

    public int setTreasureSpawnX(){
        Random rand = new Random();
        int treasureX = rand.nextInt((x - 2) + 1);
        return treasureX;
    }

    public int setTreasureSpawnY(){
        Random rand = new Random();
        int treasureY = rand.nextInt((y - 2) + 1);
        return treasureY;
    }

    public int getX(){
        return x;
    }
    public void setX(int newX){
        x = newX;
    }

    public int getY(){
        return y;
    }

    public void setY(int newY){
        y = newY;
    }

    public int getBossX(){
        return bossX;
    }

    public int getBossY(){
        return bossY;
    }

    public boolean canMoveNorthFrom(int row, int col){
        return canMoveDirectionFrom(DIR.N, row, col);
    }
    public boolean canMoveSouthFrom(int row, int col){
        return canMoveDirectionFrom(DIR.S, row, col);
    }
    public boolean canMoveEastFrom(int row, int col){
        return canMoveDirectionFrom(DIR.E, row, col);
    }
    public boolean canMoveWestFrom(int row, int col){
        return canMoveDirectionFrom(DIR.W, row, col);
    }
    private boolean canMoveDirectionFrom(DIR dir, int row, int col){
        return (maze[row][col] & dir.bit) != 0;
    }

    public void display() {
        for (int i = 0; i < y; i++) {
            // draw the north edge
            for (int j = 0; j < x; j++) {
                System.out.print((maze[j][i] & 1) == 0 ? "+---" : "+   ");
            }
            System.out.println("+");
            // draw the west edge
            for (int j = 0; j < x; j++) {
                System.out.print((maze[j][i] & 8) == 0 ? "|   " : "    ");
            }
            System.out.println("|");
        }
        // draw the bottom line
        for (int j = 0; j < x; j++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    private void generateMaze(int cx, int cy) {
        DIR[] dirs = DIR.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (DIR dir : dirs) {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (between(nx, x) && between(ny, y)
                    && (maze[nx][ny] == 0)) {
                maze[cx][cy] |= dir.bit;
                maze[nx][ny] |= dir.opposite.bit;
                generateMaze(nx, ny);
            }
        }
    }

    private static boolean between(int v, int upper) {
        return (v >= 0) && (v < upper);
    }

    private enum DIR {
        N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
        private final int bit;
        private final int dx;
        private final int dy;
        private DIR opposite;

        // use the static initializer to resolve forward references
        static {
            N.opposite = S;
            S.opposite = N;
            E.opposite = W;
            W.opposite = E;
        }

        private DIR(int bit, int dx, int dy) {
            this.bit = bit;
            this.dx = dx;
            this.dy = dy;
        }
    };


}