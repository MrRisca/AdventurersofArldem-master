package com.example.android.adventurersofarldem.Talents;

import com.example.android.adventurersofarldem.Characters.Player;
import com.example.android.adventurersofarldem.R;

public class plusTwoStr extends Talent {
    public plusTwoStr(String cla, int minLvl) {
        super("Warrior", 1, R.drawable.plustwostr, R.drawable.plustwostryes);
    }

    @Override
    public void addPassiveEffect() {
        Player.getInstance().setStrength(Player.getInstance().getStrength() + 2);
    }

    @Override
    public void removePassiveEffect() {
        Player.getInstance().setStrength(Player.getInstance().getStrength() - 2);
    }

    @Override
    public String getAvailableClass() {
        return availableClass;
    }

    @Override
    public int getIconPath() {
        return R.drawable.plustwostr;
    }

    @Override
    public void setIconPath(String iPath) {

    }

    @Override
    public void setAvailableClass(String cla) {
        availableClass = cla;
    }

    @Override
    public int getMinimumLevel() {
        return minimumLevel;
    }

    @Override
    public void setMinimumLevel(int minLvL) {
        minimumLevel = minLvL;
    }
}
