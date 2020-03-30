package com.example.android.adventurersofarldem;

import com.example.android.adventurersofarldem.Characters.Djinni;
import com.example.android.adventurersofarldem.Characters.Dragon;
import com.example.android.adventurersofarldem.Characters.Goblin;
import com.example.android.adventurersofarldem.Characters.Kraken;
import com.example.android.adventurersofarldem.Characters.Monster;
import com.example.android.adventurersofarldem.Characters.Orc;
import com.example.android.adventurersofarldem.Characters.Shark;
import com.example.android.adventurersofarldem.Characters.Troll;
import com.example.android.adventurersofarldem.Characters.Warg;

public class monsterTableClass {
    Monster[][] monsterTable;

//    public void create(String[] arg)
//    {
//        // declare and construct a 2D array
//
//
//        String x = monsterTable[Singleton.getInstance().playerPositionX][Singleton.getInstance().playerPositionY];
//
//    }
    public Monster[][] getMonsterTable() {
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

    //"Goblin", "Orc", "Troll", "Dragon", "Mummy", "Warg", "Djinni", "Shark", "Kraken"

//    public Monster[][] monsterTableClass(int pos, int level){
//        Monster[][] monsterTable = new Monster[][]{{new Goblin(),new Goblin(),new Goblin(),new Goblin(),new Goblin()},
//                {new Orc(),new Orc(),new Troll(),new Troll(),new Dragon()},
//                {new Orc(),new Orc(),new Troll(),new Troll(),new Dragon()},
//                {new Orc(),new Troll(),new Troll(),new Troll(),new Dragon()},
//                {new Warg(), new Warg(), new Djinni(), new Djinni(), new Dragon()},
//                {new Goblin(),new Orc(),new Orc(),new Troll(),new Dragon()},
//                {new Goblin(),new Troll(),new Troll(),new Troll(), new Troll()},
//                {new Goblin(), new Orc(), new Troll(), new Dragon(),new Dragon()},
//                {new Goblin(), new Goblin(), new Orc(), new Orc(), new Troll()},
//                {new Shark(), new Shark(), new Shark(), new Shark(), new Kraken()}
//
//        };
//        return monsterTable;
//    }

    public monsterTableClass() {
        monsterTable = new Monster[][]{
                {new Goblin(),new Goblin(),new Goblin(),new Goblin(),new Goblin()},
                {new Orc(),new Orc(),new Troll(),new Troll(),new Dragon()},
                {new Orc(),new Orc(),new Troll(),new Troll(),new Dragon()},
                {new Orc(),new Troll(),new Troll(),new Troll(),new Dragon()},
                {new Warg(), new Warg(), new Djinni(), new Djinni(), new Dragon()},
                {new Goblin(),new Orc(),new Orc(),new Troll(),new Dragon()},
                {new Goblin(),new Troll(),new Troll(),new Troll(), new Troll()},
                {new Goblin(), new Orc(), new Troll(), new Dragon(),new Dragon()},
                {new Goblin(), new Goblin(), new Orc(), new Orc(), new Troll()},
                {new Shark(), new Shark(), new Shark(), new Shark(), new Kraken()}
        };
    }
}
