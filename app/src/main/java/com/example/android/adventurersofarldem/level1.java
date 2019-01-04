package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


public class level1 extends AppCompatActivity {



    public String playerName;
    public String playerClass;
    public int playerStrength;
    public int playerAgility;
    public int playerIntellect;
    public int playerMaxHP;
    public int playerMaxMP;
    public int playerCurrentMP;
    public int playerCurrentHP;
    public int pArmorClass;
    public int playerExperience;
    public int playerLevel;
    public int levelComplete = 0;
    public int playerGold = 0;
    public String enemyChoice = "Goblin";



    public Dragon dragon = new Dragon();
    public Goblin goblin = new Goblin();
    //("Bob", 12, 2, 7, 0, 7 ,0, 6);
    public String monsterName;
    public int armorClass;
    public int baseDamage;
    public int maximumHealth;
    public int maximumMana;
    public int currentHealth;
    public int currentMana;
    public int monsterExperience;
    public int playerOldExperience;
    public int goblinRoll = 4;
    Battle battle = new Battle(playerStrength, baseDamage, pArmorClass, maximumHealth, maximumMana, currentHealth, currentMana, playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP, playerClass);
    levelUp levelUp = new levelUp(monsterExperience, playerExperience, playerLevel);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);



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
        pArmorClass  = ((10 +(playerAgility / 2)) - 5);
        playerExperience = getIntent().getIntExtra("playerExperience", 0);
        playerLevel = getIntent().getIntExtra("playerLevel", 0);
        enemyChoice = getIntent().getStringExtra("enemyChoice");
        if (enemyChoice == "Orc") {
            Orc orc = new Orc();
        }
        else {
                if (enemyChoice == "Dragon") {
                    Dragon dragon = new Dragon();
                }
                else {
                    Goblin goblin = new Goblin();
                }
            }



        // Set the monster's details from the goblin we made above called Bob.
        monsterName = goblin.getMonsterName();
        armorClass = goblin.getArmorClass();
        baseDamage = goblin.getBaseDamage();
        maximumHealth = goblin.getMaximumHealth();
        maximumMana = goblin.getMaximumMana();
        currentHealth = goblin.getCurrentHealth();
        currentMana = goblin.getCurrentMana();
        monsterExperience = goblin.getExperience();




        //Create strings of the player information and monster information to make sure it's correct in testing.
        String playerData = Singleton.getInstance().receivePlayerData(playerName, playerClass, playerStrength, playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP, pArmorClass, playerExperience, playerLevel, playerGold);

        TextView confirmPlayerAgility = (TextView) findViewById(R.id.playerCurrentAgility);
        confirmPlayerAgility.setText(String.valueOf(playerAgility));


        TextView confirmPlayerStrength = (TextView) findViewById(R.id.playerCurrentStrength);
        confirmPlayerStrength.setText(String.valueOf(playerStrength));

        //Set final TextView to have the goblin's current health.
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

        TextView confirmPlayerLevel = (TextView) findViewById(R.id.playerLevel);
        confirmPlayerLevel.setText(String.valueOf(playerLevel));

        Button endLevel = (Button) findViewById(R.id.completeLevel);

    }

    //Perform battle to compare goblins' AC vs player's roll to see if damage is done.
    public void fight(View view) {
        if (currentHealth < 1){

            displayGoblinDefinitelydead();
            endLevel(view);
        }
        else {int x = battle.combatWarrior(playerStrength, playerAgility, playerClass, armorClass, currentHealth);
            int damageDone = x;
            currentHealth = (currentHealth - x);
            if (currentHealth < 1){
                displayGoblinDead(view);
                levelComplete = 1;
            }
            else {String goblinMessage = "You did " + String.valueOf(damageDone) + " damage to the Goblin";
                goblinMessage += "\n They have " + String.valueOf(currentHealth) + " health left";
                displayGoblinHealth(goblinMessage); }

            int y = battle.combatEnemy(baseDamage, pArmorClass, currentHealth, playerCurrentHP, goblinRoll);
            playerCurrentHP = playerCurrentHP - y;
            if (playerCurrentHP < 1){
                Intent confirmIntent = new Intent(level1.this, youDead.class);

                startActivity(confirmIntent);

            }
            else {
                String damageReport = "You were hit for " + String.valueOf(y) + " damage, and now you have " + playerCurrentHP + " left";
                displayGoblinDamage(damageReport);
                displayPlayerHealth();
            }
        }}


    //Method to update the TextView showing goblin's HP.
    public void displayGoblinHealth(String goblinDamage){
        TextView goblinHPTest = (TextView) findViewById(R.id.attackResults2);
        goblinHPTest.setText(String.valueOf(goblinDamage));
    }

    public void displayGoblinDead(View view){
        TextView goblinHPTest = (TextView) findViewById(R.id.attackResults2);
        int goblinXP = goblin.getExperience();
        int goblinGold = goblin.getGold();
        levelComplete = 1;
        String x = "The Goblin's dead Dave. You gained " + String.valueOf(goblinXP) + " experience";
        goblinHPTest.setText(x);
        int experienceNeeded = levelUp.experienceNeeded(playerLevel);
        playerOldExperience = playerExperience;
        playerExperience += goblinXP;
        playerGold += goblinGold;
        Button endLevel = (Button) findViewById(R.id.completeLevel);
        if ((goblinXP + playerExperience) > experienceNeeded ){
            playerLevel +=1;
            displayLevelUp();}

    }

    public void displayGoblinDamage(String x){
        TextView returnDamage = (TextView) findViewById(R.id.attackResults);
        returnDamage.setText(x);
    }

    public void displayGoblinDefinitelydead(){
        TextView leaveItalone = (TextView) findViewById(R.id.attackResults2);
        String x = "HES DEAD STOP HITTING HIM";
        leaveItalone.setText(x);
        Button endLevel = (Button) findViewById(R.id.completeLevel);
        endLevel.setBackgroundColor(0xFFFF0000);
    }

    public void displayPlayerDead(){
        TextView returnDamage = (TextView) findViewById(R.id.attackResults);
        String x = "You are Dead";
        returnDamage.setText(x);
    }

    public void displayPlayerHealth(){
        TextView confirmPlayerCurrentHP = (TextView) findViewById(R.id.playerCurrentHealth);
        confirmPlayerCurrentHP.setText(String.valueOf(playerCurrentHP));
    }

    public void displayLevelUp() {
        TextView confirmLevelUp = (TextView) findViewById(R.id.Enemy);
        confirmLevelUp.setText("Level up!");
        displayLevel();
    }

    public void displayLevel() {
        TextView confirmPlayerLevel = (TextView) findViewById(R.id.playerLevel);
        confirmPlayerLevel.setText(String.valueOf(playerLevel));
    }

    public void endLevel(View view) {
        if (levelComplete == 1){
            Intent confirmIntent = new Intent(level1.this, levelComplete.class);
            confirmIntent.putExtra("playerStrength", playerStrength);
            confirmIntent.putExtra("playerAgility", playerAgility);
            confirmIntent.putExtra("playerIntellect", playerIntellect);
            confirmIntent.putExtra("playerMaxHP", playerMaxHP);
            confirmIntent.putExtra("playerMaxMP", playerMaxMP);
            confirmIntent.putExtra("playerCurrentHP", playerCurrentHP);
            confirmIntent.putExtra("playerCurrentMP", playerCurrentMP);
            confirmIntent.putExtra("playerClass", playerClass);
            confirmIntent.putExtra("playerName", playerName);
            confirmIntent.putExtra("playerOldExperience", playerOldExperience);
            confirmIntent.putExtra("playerExperience", playerExperience);
            confirmIntent.putExtra("playerLevel", playerLevel);
            confirmIntent.putExtra("playerGold", playerGold);
            if (confirmIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(confirmIntent); }
        }
    }


}
