package com.example.android.adventurersofarldem.Talents;

import com.example.android.adventurersofarldem.Characters.Player;
import com.example.android.adventurersofarldem.R;

public class plusTwoInt extends Talent {
    public plusTwoInt(String cla, int minLvl) {
        super("Wizard", 1, R.drawable.plustwoint, R.drawable.plustwointyes);
    }

    @Override
    public void addPassiveEffect() {
        Player.getInstance().setIntellect(Player.getInstance().getIntellect() + 2);
    }

    @Override
    public void removePassiveEffect() {
        Player.getInstance().setIntellect(Player.getInstance().getIntellect() - 2);
    }

    @Override
    public String getAvailableClass() {
        return availableClass;
    }

    @Override
    public int getIconPath() {
        return R.drawable.plustwoint;
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
