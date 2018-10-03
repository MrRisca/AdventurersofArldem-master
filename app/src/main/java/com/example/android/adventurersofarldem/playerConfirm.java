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
    public int pArmorClass = 10;


    public Dragon dragon = new Dragon("Bob", 15, 5, 20, 20, 10 ,20 );
    public String monsterName;
    public int armorClass;
    public int baseDamage;
    public int maximumHealth;
    public int maximumMana;
    public int currentHealth;
    public int currentMana;
    Battle battle = new Battle(playerStrength, baseDamage, pArmorClass, maximumHealth, maximumMana, currentHealth, currentMana, playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP, playerClass);



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
        String playerData = Singleton.getInstance().receivePlayerData(playerName, playerClass, playerStrength, playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP, pArmorClass);
        String dragonInfo = dragon.dragonData(monsterName, armorClass, baseDamage, maximumHealth, maximumMana, currentHealth, currentMana);

        //Update playerData textview to pump out test result. Works fine.
        TextView confirmPlayerAgility = (TextView) findViewById(R.id.playerCurrentAgility);
        confirmPlayerAgility.setText(String.valueOf(playerAgility));


        //Update dragonInfo in similar way.
        TextView confirmPlayerStrength = (TextView) findViewById(R.id.playerCurrentStrength);
        confirmPlayerStrength.setText(String.valueOf(playerStrength));

        //Set final TextView to have the dragon's current health.
        TextView confirmPlayerIntellect = (TextView) findViewById(R.id.playerCurrentIntellect);
        confirmPlayerIntellect.setText(String.valueOf(playerIntellect));

        TextView confirmPlayerMaxHP = (TextView) findViewById(R.id.playerMaxHealth);
        confirmPlayerMaxHP.setText(String.valueOf(playerMaxHP));

        TextView confirmPlayerCurrentHP = (TextView) findViewById(R.id.playerCurrentHealth);
        confirmPlayerCurrentHP.setText(String.valueOf(playerCurrentHP));

        TextView confirmPlayerMaxMP = (TextView) findViewById(R.id.playerMaxMana);
        confirmPlayerMaxMP.setText(String.valueOf(playerMaxMP));

        TextView confirmPlayerCurrentMP = (TextView) findViewById(R.id.playerCurrentMana);
        confirmPlayerCurrentMP.setText(String.valueOf(playerCurrentMP));

        TextView confirmPlayerArmorClass = (TextView) findViewById(R.id.playerCurrentArmor);
        confirmPlayerArmorClass.setText(String.valueOf(pArmorClass));
        }

        //Perform battle to compare dragons' AC vs player's roll to see if damage is done.
    public void fight(View view) {
        if (currentHealth < 1){

            displayDragonDead();
        }
        else {int x = battle.combatWarrior(playerStrength, playerAgility, playerClass, armorClass, currentHealth);
        currentHealth = currentHealth - x;
        //This will then update the dragon's health to show they were damaged.
        if (currentHealth < 1){
            displayDragonHealth(0);
        }
        else {displayDragonHealth(currentHealth);
        int y = battle.combatEnemy(baseDamage, pArmorClass, currentHealth, playerCurrentHP);
        playerCurrentHP = playerCurrentHP - y;
        if (playerCurrentHP < 1){
            displayPlayerDead();
        }
        else {
            String damageReport = "You were hit for " + String.valueOf(y) + " damage, and now you have " + playerCurrentHP + " left";
            displayDragonDamage(damageReport);
        }
        }}
    }

        //Method to update the TextView showing dragon's HP.
    public void displayDragonHealth(int currentHealth){
        TextView dragonHPTest = (TextView) findViewById(R.id.attackResults);
        dragonHPTest.setText(String.valueOf(currentHealth));
    }

    public void displayDragonDead(){
        TextView dragonHPTest = (TextView) findViewById(R.id.attackResults);
        String x = "The Dragon's dead Dave";
        dragonHPTest.setText(x);
    }

    public void displayDragonDamage(String x){
        TextView returnDamage = (TextView) findViewById(R.id.attackResults);
        returnDamage.setText(x);
    }

    public void displayPlayerDead(){
        TextView returnDamage = (TextView) findViewById(R.id.attackResults);
        String x = "You are Dead";
        returnDamage.setText(x);
    }



}
