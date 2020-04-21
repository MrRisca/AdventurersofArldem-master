package com.example.android.adventurersofarldem.Talents;

import com.example.android.adventurersofarldem.Abilities.Ability;
import com.example.android.adventurersofarldem.Characters.Player;

public abstract class Talent {

    public String availableClass;
    public int minimumLevel;
    public int iconPath;
    public int confPath;

    public Talent(String cla, int minLvl, int iPath, int cPath){
        availableClass = cla;
        minimumLevel = minLvl;
        iconPath = iPath;
        confPath = cPath;
    }

    public abstract void addPassiveEffect();

    public abstract void removePassiveEffect();

    public abstract String getAvailableClass();

    public abstract int getIconPath();

    public abstract void setIconPath(String iPath);


    public abstract void setAvailableClass(String cla);

    public abstract int getMinimumLevel();

    public abstract void setMinimumLevel(int minLvL);
}
