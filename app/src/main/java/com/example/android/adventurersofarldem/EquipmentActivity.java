package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.adventurersofarldem.Characters.Player;
import com.example.android.adventurersofarldem.Items.Equippable;
import com.example.android.adventurersofarldem.Items.Equippables.HatOfStrength;
import com.example.android.adventurersofarldem.Items.Equippables.HatOfWisdom;
import com.example.android.adventurersofarldem.Items.Item;

import java.util.List;

public class EquipmentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
        displayPlayerStats();
        Log.d("Player", String.valueOf(Player.getInstance().getCurrentHealth()) );


    }
    public void displayPlayerStats() {
        TextView confirmPlayerStrength = findViewById(R.id.playerCurrentStrength);
        confirmPlayerStrength.setText(String.valueOf(Player.getInstance().getStrength()));

        TextView confirmPlayerIntellect = findViewById(R.id.playerCurrentIntellect);
        confirmPlayerIntellect.setText(String.valueOf(Player.getInstance().getIntellect()));

        TextView itemOnHead = findViewById(R.id.itemOnHead);
        if (Player.getInstance().getItemInSlotHead() != null) {
            itemOnHead.setText(String.valueOf(Player.getInstance().getItemInSlotHead().getName()));
        }
        else itemOnHead.setText("Nothing equipped");

        TextView invDisplay = findViewById(R.id.invArray);
        invDisplay.setText(String.valueOf(Player.getInstance().inventory));
    }

    public void addIntHead(View view){
        Equippable helm = new HatOfWisdom();
        Log.d("helm name", String.valueOf(helm.getName()));
        Player.getInstance().addToInventory(helm);
        refreshButtons();
        displayPlayerStats();

    }

    public void addStrHead(View view){
        Equippable helm = new HatOfStrength();
        Player.getInstance().addToInventory(helm);
        refreshButtons();
        displayPlayerStats();
    }

    public void refreshButtons(){
        if (Player.getInstance().inventory.size() > 0) {
            Equippable itemOne = Player.getInstance().inventory.get(0);
            Button equip1 = findViewById(R.id.equipItemOne);
            equip1.setText(String.format("Equip %s", String.valueOf(itemOne.getName())));
            Button unequip1 = findViewById(R.id.unequipItemOne);
            unequip1.setText(String.format("Unequip %s", String.valueOf(itemOne.getName())));
            if (Player.getInstance().inventory.size() > 1) {
                Equippable itemTwo = Player.getInstance().inventory.get(1);
                Button equip2 = findViewById(R.id.equipItemTwo);
                equip2.setText(String.format("Equip %s", String.valueOf(itemTwo.getName())));
            }
        }
    }

    public void equipItemOne(View view) {
        if (Player.getInstance().inventory.size() > 0) {
            Equippable oldItem = (Equippable) Player.getInstance().getItemInSlotHead();
            Equippable itemOne = Player.getInstance().inventory.get(0);
            if (oldItem != null && oldItem != itemOne) {
                oldItem.unequip();
            }

            itemOne.equip();
            Player.getInstance().removeFromInventory(itemOne);
            displayPlayerStats();
            refreshButtons();
        }
    }

    public void equipItemTwo(View view) {
        if (Player.getInstance().inventory.size() > 1) {
            Equippable oldItem = (Equippable) Player.getInstance().getItemInSlotHead();
            Equippable itemTwo = Player.getInstance().inventory.get(1);
            if (oldItem != null && oldItem != itemTwo) {
                oldItem.unequip();
            }

            itemTwo.equip();
            Player.getInstance().removeFromInventory(itemTwo);
            displayPlayerStats();
            refreshButtons();
        }
    }

    public void unequipItemOne(View view){
        Equippable oldItem = (Equippable) Player.getInstance().getItemInSlotHead();
        Log.d("item was", String.valueOf(oldItem));
        if (oldItem != null) {
            oldItem.unequip();
            displayPlayerStats();
            refreshButtons();
            Log.d("item in if", String.valueOf(oldItem));
        }
        Log.d("item out of if", String.valueOf(oldItem));

    }

//    public void unequipItemTwo(View view) {
//        Equippable oldItem = (Equippable) Player.getInstance().getItemInSlotHead();
//        if (oldItem != null) {
//
//            Equippable itemTwo = Player.getInstance().inventory.get(1);
//            itemTwo.unequip();
//            displayPlayerStats();
//            refreshButtons();
//        }
//    }
}