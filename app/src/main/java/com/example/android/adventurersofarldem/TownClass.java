package com.example.android.adventurersofarldem;

import com.example.android.adventurersofarldem.Items.Item;
import com.example.android.adventurersofarldem.Quests.Quest;

import java.util.List;

public class TownClass {

    public List<Item> merchantItems;
    public List<Item> allItems;
    public List<Quest> availableQuests;
    public List<Quest> allQuests;

    public TownClass(){

    }

    public List<Item> getMerchantItems(){
            return merchantItems;}

    public void setMerchantItems(Item mI){
        merchantItems.add(mI);
    }

    public List<Quest> getAvailableQuests(){
        return availableQuests;
    }

    public void setAvailableQuests(Quest que){
        availableQuests.add(que);
    }
}
