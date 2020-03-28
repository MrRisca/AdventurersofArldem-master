package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class level1Activity extends AppCompatActivity implements spellListFragment.Listener {


    public String playerName;
    public String playerClass;
    public String spellChoice;
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
    public int playerGold;
    public int monsterAttackTurn = 1;
    public int valueOfMonsterAttack = 0;
    public String enemyChoice;
    List<Ability> spellList = Player.getInstance().getSpellList();
    public int playerTarget;

    public int positionX = Singleton.getInstance().playerPositionX;
    public int positionY = Singleton.getInstance().playerPositionY;

    public int playerOldExperience;
    public int monsterRoll = 4;
    private Monster monster;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);


        //Import the Player's name, class and stats from where they just entered them

        playerName = Player.getInstance().getCharacterName();
        playerClass = Player.getInstance().getPlayerClass();
        playerStrength = Player.getInstance().getStrength();
        playerAgility = Player.getInstance().getAgility();
        playerIntellect = Player.getInstance().getIntellect();
        playerMaxHP = Player.getInstance().getMaximumHealth();
        playerMaxMP = Player.getInstance().getMaximumMana();
        playerCurrentHP = Player.getInstance().getCurrentHealth();
        playerCurrentMP = Player.getInstance().getCurrentMana();
        pArmorClass = Player.getInstance().getArmorClass();
        playerExperience = Player.getInstance().getExperience();
        playerLevel = Player.getInstance().getPlayerLevel();
        enemyChoice = getIntent().getStringExtra("enemyChoice");
        playerGold = Player.getInstance().getPlayerGold();
        enemyChoice = "Goblin";
//        if (enemyChoice.equals("Orc")) {
//            monster = new Orc();
//
//        } else {
//            if (enemyChoice.equals("Dragon")) {
//                monster = new Dragon();
//
//            } else {
//                monster = new Goblin();
//
//
//            }
//        }
        monster = new Goblin();

        //Create strings of the player information and monster information to make sure it's correct in testing.
        String playerData = Singleton.getInstance().receivePlayerData(playerName, playerClass, playerStrength, playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP, pArmorClass, playerExperience, playerLevel, playerGold);

        TextView confirmPlayerAgility = (TextView) findViewById(R.id.playerCurrentAgility);
        confirmPlayerAgility.setText(String.valueOf(playerAgility));


        TextView confirmPlayerStrength = (TextView) findViewById(R.id.playerCurrentStrength);
        confirmPlayerStrength.setText(String.valueOf(playerStrength));

        //Set final TextView to have the monster's current health.
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

        TextView playerSpell1 = (TextView) findViewById(R.id.playerSpell1);
        playerSpell1.setText(spellList.get(0).getName());

        TextView playerSpell2 = (TextView) findViewById(R.id.playerSpell2);
        playerSpell2.setText(spellList.get(1).getName());

        TextView playerSpell3 = (TextView) findViewById(R.id.playerSpell3);
        playerSpell3.setText(spellList.get(2).getName());

        TextView playerSpell4 = (TextView) findViewById(R.id.playerSpell4);
        playerSpell4.setText(spellList.get(3).getName());

        TextView monsterCurrentHealth = findViewById(R.id.monsterCurrentHealth);
        monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));

        TextView monsterMaximumHealth = findViewById(R.id.monsterMaxHealth);
        monsterMaximumHealth.setText(String.valueOf(monster.getMaximumHealth()));

    }

    //Perform battle to compare goblins' AC vs player's roll to see if damage is done.


    //Method to update the TextView showing Monster's HP.
    public void displayMonsterHealth(String monsterDamage) {
        TextView monsterHPTest = (TextView) findViewById(R.id.attackResults2);
        monsterHPTest.setText(String.valueOf(monsterDamage));
    }

    public void displayMonsterDead(View view) {
        levelUp levelUp = new levelUp(monster.getExperience(), playerExperience, playerLevel);

        TextView monsterHPTest = (TextView) findViewById(R.id.attackResults2);
        levelComplete = 1;
        String x = "The Monster's dead Dave. You gained " + String.valueOf(monster.getExperience()) + " experience";
        monsterHPTest.setText(x);
        int experienceNeeded = levelUp.experienceNeeded(playerLevel);
        playerOldExperience = playerExperience;
        playerExperience += monster.getExperience();
        playerGold += monster.getGold();
        Button endLevel = (Button) findViewById(R.id.completeLevel);
        if ((monster.getExperience() + playerExperience) > experienceNeeded) {
            playerLevel += 1;
            displayLevelUp();
        }

    }

    public void attackOne(View view){
        Random rand = new Random();
        int attackerRoll = rand.nextInt((20) + 1) + 1;
        int defenderRoll = rand.nextInt((20) + 1) + 1;
        int attackerMod = Player.getInstance().determineMod();
        int defenderMod = monster.determineMod();
        Ability abilityToCast = spellList.get(0);
        RollDice didHit = new RollDice(attackerRoll, defenderRoll, attackerMod, defenderMod);
        if (didHit.isSuccessful()){
            abilityToCast.toAttack().applyTo(monster);
            TextView monsterCurrentHealth = findViewById(R.id.monsterCurrentHealth);
            monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));
        }
    }

    public void attackTwo(View view){
        Ability abilityToCast = new Fireball(1);
        abilityToCast.toAttack().applyTo(monster);
        TextView monsterCurrentHealth = findViewById(R.id.monsterCurrentHealth);
        monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));
        Log.d("abilityTag", String.valueOf(abilityToCast));
        Log.d("damageTakenTag", String.valueOf(monster.currentHealth));
        }

    public void attackThree(View view){
        Random rand = new Random();
        int attackerRoll = rand.nextInt((20) + 1) + 1;
        int defenderRoll = rand.nextInt((20) + 1) + 1;
        int attackerMod = Player.getInstance().determineMod();
        int defenderMod = monster.determineMod();
        Ability abilityToCast = spellList.get(2);
        RollDice didHit = new RollDice(attackerRoll, defenderRoll, attackerMod, defenderMod);
        if (didHit.isSuccessful()){
            abilityToCast.toAttack().applyTo(monster);
            TextView monsterCurrentHealth = findViewById(R.id.monsterCurrentHealth);
            monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));

        }
    }

    public void attackFour(View view){
        Random rand = new Random();
        int attackerRoll = rand.nextInt((20) + 1) + 1;
        int defenderRoll = rand.nextInt((20) + 1) + 1;
        int attackerMod = Player.getInstance().determineMod();
        int defenderMod = monster.determineMod();
        Ability abilityToCast = spellList.get(3);
        RollDice didHit = new RollDice(attackerRoll, defenderRoll, attackerMod, defenderMod);
        if (didHit.isSuccessful()){
            abilityToCast.toAttack().applyTo(monster);
            TextView monsterCurrentHealth = findViewById(R.id.monsterCurrentHealth);
            monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));

        }
    }



    public void displayMonsterDamage(String x) {
        TextView returnDamage = (TextView) findViewById(R.id.attackResults);
        returnDamage.setText(x);
    }

    public void displayMonsterDefinitelydead() {
        TextView leaveItalone = (TextView) findViewById(R.id.attackResults2);
        String x = "HES DEAD STOP HITTING HIM";
        leaveItalone.setText(x);
        Button endLevel = (Button) findViewById(R.id.completeLevel);
        endLevel.setBackgroundColor(0xFFFF0000);
    }

    public void displayPlayerDead() {
        TextView returnDamage = (TextView) findViewById(R.id.attackResults);
        String x = "You are Dead";
        returnDamage.setText(x);
    }

    public void displayPlayerHealth() {
        TextView confirmPlayerCurrentHP = (TextView) findViewById(R.id.playerCurrentHealth);
        confirmPlayerCurrentHP.setText(String.valueOf(playerCurrentHP));
        TextView confirmPlayerCurrentMP = (TextView) findViewById(R.id.playerCurrentMana);
        confirmPlayerCurrentMP.setText(String.valueOf(playerCurrentMP));
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
        if (levelComplete == 1) {
            Intent confirmIntent = new Intent(level1Activity.this, levelComplete.class);
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
                startActivity(confirmIntent);
            }
        }
    }








    @Override
    public void spellListDidSelectSpell(String selectedSpellName) {

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof spellListFragment) {
            spellListFragment spellListFragment = (spellListFragment) fragment;
            spellListFragment.setListener(this);
        }

    }}