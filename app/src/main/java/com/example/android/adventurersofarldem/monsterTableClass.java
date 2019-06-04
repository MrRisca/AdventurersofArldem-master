package com.example.android.adventurersofarldem;

public class monsterTableClass {
    Integer[][] monsterTable;

//    public void create(String[] arg)
//    {
//        // declare and construct a 2D array
//
//
//        String x = monsterTable[Singleton.getInstance().playerPositionX][Singleton.getInstance().playerPositionY];
//
//    }
    public Integer[][] getMonsterTable() {
        return monsterTable;




    }

    //Table makeup is as follows
    //  |1-2|3-5|6-10|11-20|21+
    //--------------------
    //Town|N/A|N/A|N/A |N/A  |N/A
    //--------------------
    //Forest|
    //--------------------
    //Farmland|
    //--------------------
    //Mountains|
    //--------------------
    //Dessert|
    //--------------------
    //Hills|
    //--------------------
    //Ruins|
    //--------------------
    //Cave|
    //--------------------
    //Plains|
    //--------------------
    //Ocean|

    public monsterTableClass(){
        monsterTable = new Integer[][]{{0,0,0,0,0},
                {1,1,2,2,3},
                {1,1,1,2,3},
                {2,3,3,3,4},
                {6,6,7,7,4},
                {1,2,2,3,4},
                {1,3,3,3,3},
                {1,2,3,4,4},
                {1,1,2,2,3},
                {8,8,8,8,9}
        };

    }
}
