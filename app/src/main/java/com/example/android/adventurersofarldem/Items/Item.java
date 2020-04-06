package com.example.android.adventurersofarldem.Items;

import java.util.ArrayList;
import java.util.List;

public class Item {

    public String name;
    public String description;
    public boolean permanence;
    public List<String> classesWhoCanUse;
    public int value;
    public int rarity;
    public int iconPath;


    public Item(String n, String des, boolean perma, int val, int rar, int iconP){
        name = n;
        description = des;
        permanence = perma;
        classesWhoCanUse = new ArrayList<>();
        value = val;
        rarity = rar;
        iconPath = iconP;
    }

    public void setName(String n){
    name = n;
    }

    public String getName(){
        return name;
    }


    public void setDescription(String des){
        description = des;
    }

    public String getDescription(){
        return description;
    }

    public void setPermanence(boolean perm){
        permanence = perm;
    }

    public boolean getPermanence(){
        return permanence;
    }

    public void addClassesWhoCanUse(String classes){
        classesWhoCanUse.add(classes);
    }

    public List<String> getClassesWhoCanUse(){
        return classesWhoCanUse;
    }

    public void setRarity(int rar){
        rarity = rar;
    }

    public int getRarity(){
        return rarity;
    }

}
