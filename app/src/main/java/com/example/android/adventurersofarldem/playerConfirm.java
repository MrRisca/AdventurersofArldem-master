package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class playerConfirm extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String playerName = getIntent().getStringExtra("playerName");
        String playerClass = getIntent().getStringExtra("playerClass");
        int playerStrength = getIntent().getIntExtra("playerStrength", 0);
        int playerAgility = getIntent().getIntExtra("playerAgility", 0);
        int playerIntellect = getIntent().getIntExtra("playerIntellect", 0);
        int playerMaxHP = getIntent().getIntExtra("playerMaxHP", 0);
        int playerMaxMP = getIntent().getIntExtra("playerMaxMP",0);
        int playerCurrentHP = getIntent().getIntExtra("playerCurrentHP", 0);
        int playerCurrentMP = getIntent().getIntExtra("playerCurrentMP", 0);



        Dragon dragon = new Dragon("Bob", 10, 15, 20, 20, 10, 20);

        String monsterName = dragon.getMonsterName();
        int armorClass = dragon.getArmorClass();
        int baseDamage = dragon.getBaseDamage();
        int maximumHealth = dragon.getMaximumHealth();
        int maximumMana = dragon.getMaximumMana();
        int currentHealth = dragon.getCurrentHealth();
        int currentMana = dragon.getCurrentMana();


        setContentView(R.layout.activity_player_confirm);
        String playerData = Singleton.getInstance().receivePlayerData(playerName, playerClass, playerStrength, playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP);
        String dragonInfo = dragon.dragonData(monsterName, armorClass, baseDamage, maximumHealth, maximumMana, currentHealth, currentMana);

        Battle battle = new Battle(playerStrength, baseDamage, armorClass, maximumHealth, maximumMana, currentHealth, currentMana, playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP);

        int x = battle.combat(playerStrength, baseDamage);

        TextView confirmPlayerName = (TextView) findViewById(R.id.confirmedName);
        confirmPlayerName.setText(playerData);

        TextView confirmDragonName = (TextView) findViewById(R.id.confirmedDragon);
        confirmDragonName.setText(dragonInfo);

        TextView confirmTest = (TextView) findViewById(R.id.test);
        confirmTest.setText(Integer.toString(x));
    }
}
