package com.example.android.adventurersofarldem.Quests.ExploreTheMine;

public class MineMapClass {
    String[][] mineMap;
    Boolean[][] mineMapGoLeft;
    Boolean[][] mineMapGoUp;
    Boolean[][] mineMapGoDown;
    Boolean[][] mineMapGoRight;

    public MineMapClass() {

        //mineMap is the implementation of the maze.
        //T = Treasure
        //B = Boss (obviously has loot too)
        //O = Orc
        //G = Goblin
        //E = Empty
        mineMap = new String[][]{
                {"T","B","E","E","M"},
                {"E","E","E","O","E"},
                {"E","E","E","E","E"},
                {"G","E","E","E","T"},
                {"T","E","E","E","E"},
                {"G","T","E","E","G"},
                {"E","E","E","E","T"},
        };

        //mineMapGoLeft/Up/Down/Right are Booleans that say whether the user can go in a direction
        //from where they are on the map at that point
        mineMapGoLeft = new Boolean[][]{
                {false, false, false, true, true},
                {false, true, true, true, true},
                {false, true, true, true, true},
                {false, true, true, true, true},
                {false, true, true, true, true},
                {false, true, false, true, true},
                {false, true, true, true, true},
        };

        mineMapGoRight = new Boolean[][]{
                {false, false, true, true, false},
                {true, true, true, true, false},
                {true, true, true, true, false},
                {true, true, true, true, false},
                {true, true, true, true, false},
                {true, false, true, true, false},
                {true, true, true, false, false},
        };

        mineMapGoUp = new Boolean[][]{
                {false, false, false, false, false},
                {true, true, true, false, true},
                {true, false, false, true, false},
                {false, false, false, false, true},
                {true, false, false, false, true},
                {true, false, true, false, true},
                {true, true, true, true, true},
        };

        mineMapGoDown = new Boolean[][]{
                {true, true, true, false, true},
                {true, false, false, true, false},
                {false, false, false, false, true},
                {true, false, false, false, true},
                {true, false, true, false, true},
                {true, true, true, true, false},
                {false, false, true, false, false},
        };
        }

        public void updateMineMap(int mapRow, int mapCol){
        mineMap[mapRow][mapCol] = "E";
        }
    }

