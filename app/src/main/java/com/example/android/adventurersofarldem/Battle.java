package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;

public class Battle extends AppCompatActivity{

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

    public Battle(int ps, int es, int ea, int emh, int emm, int ech, int ecm, int pa, int pi, int pmh, int pmm, int pch, int pcm){
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
    }

    public int combat(int pStrength, int eArmorClass){
        if (pStrength > eArmorClass){
            return 1;
        }
        else{
            return 2;}
    }
}
