package com.example.android.adventurersofarldem;

import java.util.Arrays;

public class WorldMapClass {
    String[][] worldMap;

    public void create(String[] arg)
    {
        // declare and construct a 2D array


        String x = worldMap[Singleton.getInstance().playerPositionX][Singleton.getInstance().playerPositionY];

    }
    public String[][] getMap() {
        return worldMap;


    }

    public WorldMapClass() {
        worldMap = new String[][]{       {"M", "M", "M", "M", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"M", "M", "M", "M", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"M", "M", "M", "M", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"M", "M", "M", "M", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"M", "M", "M", "M", "M", "T", "T", "T", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "T", "T", "T", "R", "R", "R", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"M", "M", "M", "M", "M", "T", "T", "T", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "T", "T", "T", "R", "R", "R", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"M", "M", "M", "M", "M", "T", "T", "T", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "T", "T", "T", "R", "R", "R", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"M", "M", "M", "M", "M", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"M", "M", "M", "M", "M", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"M", "M", "M", "M", "M", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"M", "M", "M", "M", "M", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"H", "H", "H", "H", "H", "H", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo",  "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"H", "H", "H", "H", "H", "H", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo",  "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"H", "H", "H", "H", "H", "H", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo",  "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"H", "H", "H", "H", "H", "H", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo",  "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                        {"H", "H", "H", "H", "H", "H", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "H", "H", "H", "H", "H", "H", "H", "H", "H", "P", "P"},
                        {"H", "H", "H", "H", "H", "H", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "H", "H", "H", "H", "H", "H", "H", "H", "H", "P", "P"},
                        {"H", "H", "H", "H", "H", "H", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "T", "T", "T", "T", "T", "Fo", "Fo", "Fo", "Fo", "Fo", "H", "H", "H", "H", "H", "H", "H", "H", "H", "P", "P"},
                        {"H", "H", "H", "H", "H", "H", "C", "C", "C", "Fo", "Fo", "Fo", "Fo", "Fo", "T", "T", "T", "T", "T", "Fo", "Fo", "Fo", "Fo", "Fo", "H", "H", "H", "H", "H", "H", "H", "H", "H", "P", "P"},
                        {"H", "H", "H", "H", "H", "H", "C", "C", "C", "Fo", "Fo", "Fo", "Fo", "Fo", "T", "T", "T", "T", "T", "Fo", "Fo", "Fo", "Fo", "Fo", "H", "H", "H", "H", "H", "H", "H", "H", "H", "P", "P"},
                        {"H", "H", "H", "H", "H", "H", "C", "C", "C", "Fo", "Fo", "Fo", "Fo", "Fo", "T", "T", "T", "T", "T", "Fo", "Fo", "Fo", "Fo", "Fo", "H", "H", "H", "H", "H", "H", "H", "H", "H", "P", "P"},
                        {"H", "H", "H", "H", "H", "H", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "C", "C", "Fa", "Fa", "Fa", "H", "H", "H", "H", "H", "H", "H", "H", "H", "P", "P"},
                        {"H", "H", "H", "H", "H", "H", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "C", "C", "Fa", "Fa", "Fa", "H", "H", "H", "H", "H", "H", "H", "H", "H", "P", "P"},
                        {"H", "H", "H", "H", "H", "H", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "H", "H", "H", "H", "H", "H", "H", "H", "H", "P", "P"},
                        {"H", "H", "H", "H", "H", "H", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "H", "H", "H", "H", "H", "H", "H", "H", "H", "P", "P"},
                        {"H", "H", "H", "H", "H", "H", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "H", "H", "H", "H", "H", "H", "H", "H", "H", "P", "P"},
                        {"P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P"},
                        {"P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P"},
                        {"P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P"},
                        {"P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P", "P"},
                        {"D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
                        {"D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
                        {"D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
                        {"D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
                        {"D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
                        {"D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
                };

    }
}
