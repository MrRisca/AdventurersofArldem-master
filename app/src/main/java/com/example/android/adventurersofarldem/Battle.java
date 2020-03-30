package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;

import java.util.Random;

public class Battle extends AppCompatActivity {

    public int tStrength;
    public int tArmorClass;
    public int tMaximumHealth;
    public int tMaximumMana;
    public int tCurrentHealth;
    public int tCurrentMana;
    public int cStrength;
    public int cAgility;
    public int cIntellect;
    public int cMaximumHealth;
    public int cMaximumMana;
    public int cCurrentHealth;
    public int cCurrentMana;
    public String cClass;
    public int cArmorClass = (10 + ((cAgility /2) -5));
    public int attackType = 1;
    public String caster;
    public String target;

    public Battle(int ps, int es, int ea, int emh, int emm, int ech, int ecm, int pa, int pi, int pmh, int pmm, int pch, int pcm, String pc, String cast, String tar) {
        cStrength = ps;
        cStrength = es;
        tArmorClass = ea;
        tMaximumHealth = emh;
        tMaximumMana = emm;
        tCurrentHealth = ech;
        tCurrentMana = ecm;
        cAgility = pa;
        cIntellect = pi;
        cMaximumHealth = pmh;
        cMaximumMana = pmm;
        cCurrentHealth = pch;
        cCurrentMana = pcm;
        cClass = pc;
        caster = cast;
        target = tar;
    }


    public int combatWarrior(int cStrength, int cAgility, String cClass, int tArmoryClass, int tCurrentHealth) {
        int didIHit = chanceToHit(cStrength, cAgility);
        int damage = calculateDamage(cClass, cStrength, cAgility);
        attackType = 1;
        if (didIHit > tArmoryClass) {

            return damage;
        } else return 0;

    }

    public int combatHeavy(int cStrength, int cAgility, String cClass, int tArmoryClass, int tCurrentHealth) {
        int didIHit = chanceToHit(cStrength, cAgility);
        int damage = calculateDamage(cClass, cStrength, cAgility);
        attackType = 2;
        if (didIHit > tArmoryClass) {
            damage += (damage * 0.1);
            return damage;
        }
        else return  0;
    }

    public int combatLight(int cStrength, int cAgility, String cClass, int tArmoryClass, int tCurrentHealth) {
        int didIHit = chanceToHit(cStrength, cAgility);
        int damage = calculateDamage(cClass, cStrength, cAgility);
        attackType = 3;
        if (didIHit > tArmoryClass) {
            damage -= (damage * 0.1);

            return damage;
        }
        else return  0;
    }



    public int combatEnemy(int baseDamage, int cArmorClass, int tCurrentHealth, int cCurrentHealth, int targetRoll) {
        Random rand = new Random();
        int randomNum = rand.nextInt((targetRoll) +1) + 1;
        if (attackType == 2) {
            cArmorClass -= 2;
            int didIHit = enemyChanceToHit(baseDamage, cArmorClass);
            int damage;
            cArmorClass +=2;
            if (didIHit == 1){
                damage = randomNum;
                return damage;}


            else return 0;
        }

        else if (attackType == 3) {
            cArmorClass += 2;
            int didIHit = enemyChanceToHit(baseDamage, cArmorClass);
            int damage;
            cArmorClass -=2;
            if (didIHit == 1) {
                damage = randomNum;
                return damage;
            }


            else return 0;
        }
        else {
            int didIHit = enemyChanceToHit(baseDamage, cArmorClass);
            int damage;
            if (didIHit == 1) {
                damage = randomNum;
                return damage;
            } else return 0;
        }
    }


    public int enemyChanceToHit(int baseDamage, int cArmorClass){
        Random rand = new Random();
        int roll = rand.nextInt((20) +1) + 1;
        if (roll > cArmorClass){

            int x = 1;
            return x;
        }
        else{
            int x = 0;
            return x;
        }

    }


    //Long set of IF statements basically giving players additional bonuses to their roll and damage for having high stats.

    //Note Oli: You can replace these IFs with: Modifier = (Score / 2 ) - 5 but you need to set the ints to doubles first and then round down and I cba to do it right now.

    public int chanceToHit(int cStrength, int cAgility) {
        Random rand = new Random();
        int roll;
        int cModifier = 0;
        int randomNum = rand.nextInt((20) + 1) + 1;
        if (cClass == "Ranger") {
            if (cAgility < 8) {
                cModifier -= 2;
            } else if (cAgility > 7 && cAgility < 10) {
                cModifier -= 1;
            } else if (cAgility > 9 && cAgility < 12) {
                cModifier += 0;
            } else if (cAgility > 11 && cAgility < 14) {
                cModifier += 1;
            } else if (cAgility > 13 && cAgility < 16) {
                cModifier += 2;
            } else if (cAgility > 15 && cAgility < 18) {
                cModifier += 3;
            } else if (cAgility > 17 && cAgility < 20) {
                cModifier += 4;
            } else if (cAgility > 19 && cAgility < 22) {
                cModifier += 5;
            } else if (cAgility > 21 && cAgility < 24) {
                cModifier += 6;
            } else if (cAgility > 23 && cAgility < 26) {
                cModifier += 7;
            } else if (cAgility > 25 && cAgility < 28) {
                cModifier += 8;
            } else if (cAgility > 27 && cAgility < 30) {
                cModifier += 9;
            } else {
                cModifier += 10;
            }}

        
        else if (cStrength < 8) {
            cModifier -= 2;
        } else if (cStrength > 7 && cStrength < 10) {
            cModifier -= 1;
        } else if (cStrength > 9 && cStrength < 12) {
            cModifier += 0;
        } else if (cStrength > 11 && cStrength < 14) {
            cModifier += 1;
        } else if (cStrength > 13 && cStrength < 16) {
            cModifier += 2;
        } else if (cStrength > 15 && cStrength < 18) {
            cModifier += 3;
        } else if (cStrength > 17 && cStrength < 20) {
            cModifier += 4;
        } else if (cStrength > 19 && cStrength < 22) {
            cModifier += 5;
        } else if (cStrength > 21 && cStrength < 24) {
            cModifier += 6;
        } else if (cStrength > 23 && cStrength < 26) {
            cModifier += 7;
        } else if (cStrength > 25 && cStrength < 28) {
            cModifier += 8;
        } else if (cStrength > 27 && cStrength < 30) {
            cModifier += 9;
        } else {
            cModifier += 10;
        }
        roll = randomNum + cModifier + 2;
        return roll;
    }

    public int calculateDamage(String cClass, int cStrength, int cAgility) {
        Random rand = new Random();
        int damageRoll = 0;
        int cModifier = 0;
        int randomNum = rand.nextInt((6) + 1) + 1;
        if (cClass.equals("Warrior")) {
            if (cStrength < 8) {
                cModifier -= 2;
            } else if (cStrength > 7 && cStrength < 10) {
                cModifier -= 1;
            } else if (cStrength > 9 && cStrength < 12) {
                cModifier += 0;
            } else if (cStrength > 11 && cStrength < 14) {
                cModifier += 1;
            } else if (cStrength > 13 && cStrength < 16) {
                cModifier += 2;
            } else if (cStrength > 15 && cStrength < 18) {
                cModifier += 3;
            } else if (cStrength > 17 && cStrength < 20) {
                cModifier += 4;
            } else if (cStrength > 19 && cStrength < 22) {
                cModifier += 5;
            } else if (cStrength > 21 && cStrength < 24) {
                cModifier += 6;
            } else if (cStrength > 23 && cStrength < 26) {
                cModifier += 7;
            } else if (cStrength > 25 && cStrength < 28) {
                cModifier += 8;
            } else if (cStrength > 27 && cStrength < 30) {
                cModifier += 9;
            } else {
                cModifier += 10;
            }}

            else if (cClass.equals("Ranger")) {
                if (cAgility < 8) {
                    cModifier -= 2;
                } else if (cAgility > 7 && cAgility < 10) {
                    cModifier -= 1;
                } else if (cAgility > 9 && cAgility < 12) {
                    cModifier += 0;
                } else if (cAgility > 11 && cAgility < 14) {
                    cModifier += 1;
                } else if (cAgility > 13 && cAgility < 16) {
                    cModifier += 2;
                } else if (cAgility > 15 && cAgility < 18) {
                    cModifier += 3;
                } else if (cAgility > 17 && cAgility < 20) {
                    cModifier += 4;
                } else if (cAgility > 19 && cAgility < 22) {
                    cModifier += 5;
                } else if (cAgility > 21 && cAgility < 24) {
                    cModifier += 6;
                } else if (cAgility > 23 && cAgility < 26) {
                    cModifier += 7;
                } else if (cAgility > 25 && cAgility < 28) {
                    cModifier += 8;
                } else if (cAgility > 27 && cAgility < 30) {
                    cModifier += 9;
                } else if (cAgility > 29) {
                    cModifier += 10;
                }} else {
                    cModifier += 1;
                }

            damageRoll = randomNum + cModifier;


        return damageRoll;
    }
}