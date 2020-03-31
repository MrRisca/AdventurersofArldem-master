//package com.example.android.adventurersofarldem;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import java.util.*;
//
//
//public class EndOfTurn extends AppCompatActivity {
//    ArrayList enemies = getIntent().getStringArrayListExtra("enemyList");
//    int attackerRoll;
//    int defenderRoll;
//    int attackerMod;
//    int defenderMod;
//    int directDamage;
//    int enemiesLength = enemies.size();
//    ArrayList fighters = (ArrayList) enemies.clone();
//    Random rand = new Random();
//    int playerRoll = rand.nextInt((20) +1) + 1;
//
//
//
//
//    public void OnCreate(){
//        int i = 0;
//        while (i < enemies.size()) {
//            List<Character> enemiesList = new ArrayList<Character>();
//            i += 1;
//        fighters.add(0,"Player");
//        int fighterIterator = 0;
//        while (fighterIterator < fighters.size()){
//            if (fighterIterator == 0){
//                defenderRoll = rand.nextInt((20) + 1);
//                if (Character.characterType == "Warrior") {
//                    attackerMod = ((Character.strength / 2) - 5);
//                }
//
//                }
//
//            //Go through and bring in all the characters fighting
//            //Do their attacks
//            //Resolve health
//            fighterIterator += 1;
//        }
//
//        }
//
//    }
//
//}
