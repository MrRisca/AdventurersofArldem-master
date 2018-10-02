package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;

import java.util.Random;

public class Battle extends AppCompatActivity {

    public int eStrength;
    public int eArmorClass;
    public int eMaximumHealth;
    public int eMaximumMana;
    public int eCurrentHealth;
    public int eCurrentMana;
    public int pStrength;
    public int pAgility;
    public int pIntellect;
    public int pMaximumHealth;
    public int pMaximumMana;
    public int pCurrentHealth;
    public int pCurrentMana;
    public String pClass;

    public Battle(int ps, int es, int ea, int emh, int emm, int ech, int ecm, int pa, int pi, int pmh, int pmm, int pch, int pcm, String pc) {
        pStrength = ps;
        eStrength = es;
        eArmorClass = ea;
        eMaximumHealth = emh;
        eMaximumMana = emm;
        eCurrentHealth = ech;
        eCurrentMana = ecm;
        pAgility = pa;
        pIntellect = pi;
        pMaximumHealth = pmh;
        pMaximumMana = pmm;
        pCurrentHealth = pch;
        pCurrentMana = pcm;
        pClass = pc;
    }

    //This is supposed to see if the player hit, do damage to the dragon if so, and then update the eCurrentHealth stat

   // public int combatWarrior(int pStrength, int pAgility, String pClass, int eArmorClass, int eCurrentHP) {
   //     int didIHit = chanceToHit(pStrength, pAgility);
   //     int damage = calculateDamage(pClass, pStrength, pAgility);
  //      if (didIHit > eArmorClass) {
   //         eCurrentHP = eCurrentHP - damage;
   //         eCurrentHealth = eCurrentHP;
    //        return eCurrentHealth;
    //    } else return eCurrentHealth;

   // }

    public int combatWarrior(int pStrength, int pAgility, String pClass, int eArmorClass, int eCurrentHealth) {
        int didIHit = chanceToHit(pStrength, pAgility);
        int damage = calculateDamage(pClass, pStrength, pAgility);
        if (didIHit > eArmorClass) {

            return damage;
        } else return eCurrentHealth;

    }

    //Long set of IF statements basically giving players additional bonuses to their roll and damage for having high stats.

    //Note Oli: You can replace these IFs with: Modifier = (Score / 2 ) - 5 but you need to set the ints to doubles first and then round down and I cba to do it right now.

    public int chanceToHit(int pStrength, int pAgility) {
        Random rand = new Random();
        int roll;
        int pModifier = 0;
        int randomNum = rand.nextInt((20) + 1) + 1;
        if (pClass == "Ranger") {
            if (pAgility < 8) {
                pModifier -= 2;
            } else if (pAgility > 7 && pAgility < 10) {
                pModifier -= 1;
            } else if (pAgility > 9 && pAgility < 12) {
                pModifier += 0;
            } else if (pAgility > 11 && pAgility < 14) {
                pModifier += 1;
            } else if (pAgility > 13 && pAgility < 16) {
                pModifier += 2;
            } else if (pAgility > 15 && pAgility < 18) {
                pModifier += 3;
            } else if (pAgility > 17 && pAgility < 20) {
                pModifier += 4;
            } else if (pAgility > 19 && pAgility < 22) {
                pModifier += 5;
            } else if (pAgility > 21 && pAgility < 24) {
                pModifier += 6;
            } else if (pAgility > 23 && pAgility < 26) {
                pModifier += 7;
            } else if (pAgility > 25 && pAgility < 28) {
                pModifier += 8;
            } else if (pAgility > 27 && pAgility < 30) {
                pModifier += 9;
            } else {
                pModifier += 10;
            }}

        
        else if (pStrength < 8) {
            pModifier -= 2;
        } else if (pStrength > 7 && pStrength < 10) {
            pModifier -= 1;
        } else if (pStrength > 9 && pStrength < 12) {
            pModifier += 0;
        } else if (pStrength > 11 && pStrength < 14) {
            pModifier += 1;
        } else if (pStrength > 13 && pStrength < 16) {
            pModifier += 2;
        } else if (pStrength > 15 && pStrength < 18) {
            pModifier += 3;
        } else if (pStrength > 17 && pStrength < 20) {
            pModifier += 4;
        } else if (pStrength > 19 && pStrength < 22) {
            pModifier += 5;
        } else if (pStrength > 21 && pStrength < 24) {
            pModifier += 6;
        } else if (pStrength > 23 && pStrength < 26) {
            pModifier += 7;
        } else if (pStrength > 25 && pStrength < 28) {
            pModifier += 8;
        } else if (pStrength > 27 && pStrength < 30) {
            pModifier += 9;
        } else {
            pModifier += 10;
        }
        roll = randomNum + pModifier;
        return roll;
    }

    public int calculateDamage(String pClass, int pStrength, int pAgility) {
        Random rand = new Random();
        int damageRoll = 0;
        int cModifier = 0;
        int randomNum = rand.nextInt((6) + 1) + 1;
        if (pClass == "Warrior") {
            if (pStrength < 8) {
                cModifier -= 2;
            } else if (pStrength > 7 && pStrength < 10) {
                cModifier -= 1;
            } else if (pStrength > 9 && pStrength < 12) {
                cModifier += 0;
            } else if (pStrength > 11 && pStrength < 14) {
                cModifier += 1;
            } else if (pStrength > 13 && pStrength < 16) {
                cModifier += 2;
            } else if (pStrength > 15 && pStrength < 18) {
                cModifier += 3;
            } else if (pStrength > 17 && pStrength < 20) {
                cModifier += 4;
            } else if (pStrength > 19 && pStrength < 22) {
                cModifier += 5;
            } else if (pStrength > 21 && pStrength < 24) {
                cModifier += 6;
            } else if (pStrength > 23 && pStrength < 26) {
                cModifier += 7;
            } else if (pStrength > 25 && pStrength < 28) {
                cModifier += 8;
            } else if (pStrength > 27 && pStrength < 30) {
                cModifier += 9;
            } else {
                cModifier += 10;
            }}

            else if (pClass == "Ranger") {
                if (pAgility < 8) {
                    cModifier -= 2;
                } else if (pAgility > 7 && pAgility < 10) {
                    cModifier -= 1;
                } else if (pAgility > 9 && pAgility < 12) {
                    cModifier += 0;
                } else if (pAgility > 11 && pAgility < 14) {
                    cModifier += 1;
                } else if (pAgility > 13 && pAgility < 16) {
                    cModifier += 2;
                } else if (pAgility > 15 && pAgility < 18) {
                    cModifier += 3;
                } else if (pAgility > 17 && pAgility < 20) {
                    cModifier += 4;
                } else if (pAgility > 19 && pAgility < 22) {
                    cModifier += 5;
                } else if (pAgility > 21 && pAgility < 24) {
                    cModifier += 6;
                } else if (pAgility > 23 && pAgility < 26) {
                    cModifier += 7;
                } else if (pAgility > 25 && pAgility < 28) {
                    cModifier += 8;
                } else if (pAgility > 27 && pAgility < 30) {
                    cModifier += 9;
                } else if (pAgility > 29) {
                    cModifier += 10;
                }} else {
                    cModifier += 1;
                }

            damageRoll = randomNum + cModifier;


        return damageRoll;
    }
}