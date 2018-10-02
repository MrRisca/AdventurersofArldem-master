package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class playerConfirm extends AppCompatActivity {

    public String playerName;
    public String playerClass;
    public int playerStrength;
    public int playerAgility;
    public int playerIntellect;
    public int playerMaxHP;
    public int playerMaxMP;
    public int playerCurrentMP;
    public int playerCurrentHP;

    public Dragon dragon = new Dragon("Bob", 10, 15, 20, 20, 10 ,20 );
    public String monsterName;
    public int armorClass;
    public int baseDamage;
    public int maximumHealth;
    public int maximumMana;
    public int currentHealth;
    public int currentMana;
    Battle battle = new Battle(playerStrength, baseDamage, armorClass, maximumHealth, maximumMana, currentHealth, currentMana, playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP, playerClass);



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Import the Player's name, class and stats from where they just entered them

        playerName = getIntent().getStringExtra("playerName");
        playerClass = getIntent().getStringExtra("playerClass");
        playerStrength = getIntent().getIntExtra("playerStrength", 0);
        playerAgility = getIntent().getIntExtra("playerAgility", 0);
        playerIntellect = getIntent().getIntExtra("playerIntellect", 0);
        playerMaxHP = getIntent().getIntExtra("playerMaxHP", 0);
        playerMaxMP = getIntent().getIntExtra("playerMaxMP",0);
        playerCurrentHP = getIntent().getIntExtra("playerCurrentHP", 0);
        playerCurrentMP = getIntent().getIntExtra("playerCurrentMP", 0);

        // Set the monster's details from the dragon we made above called Bob.
        monsterName = dragon.getMonsterName();
        armorClass = dragon.getArmorClass();
        baseDamage = dragon.getBaseDamage();
        maximumHealth = dragon.getMaximumHealth();
        maximumMana = dragon.getMaximumMana();
        currentHealth = dragon.getCurrentHealth();
        currentMana = dragon.getCurrentMana();

        //Create strings of the player information and monster information to make sure it's correct in testing.
        setContentView(R.layout.activity_player_confirm);
        String playerData = Singleton.getInstance().receivePlayerData(playerName, playerClass, playerStrength, playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP);
        String dragonInfo = dragon.dragonData(monsterName, armorClass, baseDamage, maximumHealth, maximumMana, currentHealth, currentMana);

        //Update playerData textview to pump out test result. Works fine.
        TextView confirmPlayerName = (TextView) findViewById(R.id.confirmedName);
        confirmPlayerName.setText(playerData);


        //Update dragonInfo in similar way.
        TextView confirmDragonName = (TextView) findViewById(R.id.confirmedDragon);
        confirmDragonName.setText(dragonInfo);

        //Set final TextView to have the dragon's current health.
        TextView confirmTest = (TextView) findViewById(R.id.test);
        confirmTest.setText((String.valueOf(dragon.dragonHealth())));


        }

        //Perform battle to compare dragons' AC vs player's roll to see if damage is done.
    public void battle(View view) {
        int x = battle.combatWarrior(playerStrength, playerAgility, playerClass, armorClass, currentHealth);
        currentHealth = currentHealth - x;
        //This will then update the dragon's health to show they were damaged.
        if (currentHealth == 0){
            displayDragonHealth(toString("The dragon's dead, Dave"));
        }
        displayDragonHealth(currentHealth);
    }

        //Method to update the TextView showing dragon's HP.
    public void displayDragonHealth(int currentHealth){
        TextView dragonHPTest = (TextView) findViewById(R.id.test);
        dragonHPTest.setText(String.valueOf(currentHealth));
    }

}
