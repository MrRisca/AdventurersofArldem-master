package com.example.android.adventurersofarldem;

import com.example.android.adventurersofarldem.Characters.Player;

import java.util.Arrays;

public class WorldMapClass {
    String[][] worldMap;

    public void create(String[] arg)
    {
        // declare and construct a 2D array


        String x = worldMap[Player.getInstance().getPosX()][Player.getInstance().getPosY()];

    }
    public String[][] getMap() {
        return worldMap;


    }

    public WorldMapClass() {
        worldMap = new String[][]{
                        {"Mo", "Mo", "Mo", "Mo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Mo", "Mo", "Mo", "Mo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Mo", "Mo", "Mo", "Mo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Mo", "Mo", "Mo", "Mo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Mo", "Mo", "Mo", "Mo", "Mo", "To", "To", "To", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "To", "To", "To", "Ri", "Ri", "Ri", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Mo", "Mo", "Mo", "Mo", "Mo", "To", "To", "To", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "To", "To", "To", "Ri", "Ri", "Ri", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Mo", "Mo", "Mo", "Mo", "Mo", "To", "To", "To", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "To", "To", "To", "Ri", "Ri", "Ri", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Mo", "Mo", "Mo", "Mo", "Mo", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Mo", "Mo", "Mo", "Mo", "Mo", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Mo", "Mo", "Mo", "Mo", "Mo", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Mo", "Mo", "Mo", "Mo", "Mo", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc", "Oc"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Pl", "Pl", "Pl"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Fo", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Pl", "Pl", "Pl"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Fa", "Fa", "Fa", "Fo", "Fo", "Fo", "Fo", "Fo", "To", "To", "To", "To", "To", "Fo", "Fo", "Fo", "Fo", "Fo", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Pl", "Pl", "Pl"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Ca", "Ca", "Ca", "Fo", "Fo", "Fo", "Fo", "Fo", "To", "To", "To", "To", "To", "Fo", "Fo", "Fo", "Fo", "Fo", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Pl", "Pl", "Pl"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Ca", "Ca", "Ca", "Fo", "Fo", "Fo", "Fo", "Fo", "To", "To", "To", "To", "To", "Fo", "Fo", "Fo", "Fo", "Fo", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Pl", "Pl", "Pl"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Ca", "Ca", "Ca", "Fo", "Fo", "Fo", "Fo", "Fo", "To", "To", "To", "To", "To", "Fo", "Fo", "Fo", "Fo", "Fo", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Pl", "Pl", "Pl"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Ca", "Ca", "Fa", "Fa", "Fa", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Pl", "Pl", "Pl"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Ca", "Ca", "Fa", "Fa", "Fa", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Pl", "Pl", "Pl"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Pl", "Pl", "Pl"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Pl", "Pl", "Pl"},
                        {"Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Hi", "Pl", "Pl", "Pl"},
                        {"Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl"},
                        {"Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl"},
                        {"Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl"},
                        {"Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl", "Pl"},
                        {"De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De"},
                        {"De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De"},
                        {"De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De"},
                        {"De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De"},
                        {"De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De"},
                        {"De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De", "De"},
                };

    }
}
