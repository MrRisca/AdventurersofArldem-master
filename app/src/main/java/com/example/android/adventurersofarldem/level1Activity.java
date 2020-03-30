package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Fragment;

import com.example.android.adventurersofarldem.Abilities.Ability;
import com.example.android.adventurersofarldem.Abilities.MeleeStrike;
import com.example.android.adventurersofarldem.Characters.Monster;
import com.example.android.adventurersofarldem.Characters.Player;

import java.util.List;
import java.util.Random;


public class level1Activity extends AppCompatActivity implements spellListFragment.Listener {



    public int levelComplete = 0;

    public String enemyChoice;
    List<Ability> spellList = Player.getInstance().getSpellList();
    public int playerTarget;
    public int positionX = Player.getInstance().getPosX();
    public int positionY = Player.getInstance().getPosY();
    public int playerOldExperience;
    public int playerNewExperience;
    public int playerOldGold;
    public int playerNewGold;
    public int monsterRoll = 4;
    private Monster monster;
    public Monster toBePicked;
    public int playerOldLevel;
    public int playerNewLevel;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        playerOldExperience = Player.getInstance().getExperience();
        playerOldGold = Player.getInstance().getGold();
        playerOldLevel = Player.getInstance().getLevel();

        //Import the Player's name, class and stats from where they just entered them
        monster = Player.getInstance().getNextEnemy();



        TextView confirmEnemyType = (TextView) findViewById(R.id.Enemy);
        confirmEnemyType.setText(String.valueOf(monster.getCharacterName()));


        //Create strings of the player information and monster information to make sure it's correct in testing.

        TextView confirmPlayerAgility = (TextView) findViewById(R.id.playerCurrentAgility);
        confirmPlayerAgility.setText(String.valueOf(Player.getInstance().getAgility()));


        TextView confirmPlayerStrength = (TextView) findViewById(R.id.playerCurrentStrength);
        confirmPlayerStrength.setText(String.valueOf(Player.getInstance().getStrength()));

        //Set final TextView to have the monster's current health.
        TextView confirmPlayerIntellect = (TextView) findViewById(R.id.playerCurrentIntellect);
        confirmPlayerIntellect.setText(String.valueOf(Player.getInstance().getIntellect()));

        TextView confirmPlayerMaxHP = (TextView) findViewById(R.id.playerMaxHealth);
        confirmPlayerMaxHP.setText(String.valueOf(Player.getInstance().getMaximumHealth()));

        TextView confirmPlayerCurrentHP = (TextView) findViewById(R.id.playerCurrentHealth);
        confirmPlayerCurrentHP.setText(String.valueOf(Player.getInstance().getCurrentHealth()));

        TextView confirmPlayerMaxMP = (TextView) findViewById(R.id.playerMaxMana);
        confirmPlayerMaxMP.setText(String.valueOf(Player.getInstance().getMaximumMana()));

        TextView confirmPlayerCurrentMP = (TextView) findViewById(R.id.playerCurrentMana);
        confirmPlayerCurrentMP.setText(String.valueOf(Player.getInstance().getCurrentMana()));

        TextView confirmPlayerArmorClass = (TextView) findViewById(R.id.playerCurrentArmor);
        confirmPlayerArmorClass.setText(String.valueOf(Player.getInstance().getArmorClass()));

        TextView confirmPlayerLevel = (TextView) findViewById(R.id.playerLevel);
        confirmPlayerLevel.setText(String.valueOf(Player.getInstance().getLevel()));

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


    public void attackOne(View view){
        Random rand = new Random();
        int attackerRoll = rand.nextInt((20) + 1) + 1;
        int defenderRoll = rand.nextInt((20) + 1) + 1;
        int attackerMod = Player.getInstance().determineMod();
        int defenderMod = monster.determineMod();
        Ability abilityToCast = spellList.get(0);
        RollDice didHit = new RollDice(attackerRoll, defenderRoll, attackerMod, defenderMod);
        if (didHit.isSuccessful()){
            abilityToCast.toAttack(Player.getInstance()).applyTo(monster);
            TextView monsterCurrentHealth = findViewById(R.id.monsterCurrentHealth);
            monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));
        }
        TextView resultsString = findViewById(R.id.attackResults);
        resultsString.setText(new StringBuilder().append("You = ").append((attackerMod + attackerRoll)).append("Gob = ").append((defenderMod + defenderRoll)).toString());
        TextView resultsString2 = findViewById(R.id.attackResults2);
        resultsString2.setText(new StringBuilder().append("Gob roll + mod = ").append((defenderMod + defenderRoll)).toString());
        endTurn();
    }

    public void attackTwo(View view){
        Random rand = new Random();
        int attackerRoll = rand.nextInt((20) + 1) + 1;
        int defenderRoll = rand.nextInt((20) + 1) + 1;
        int attackerMod = Player.getInstance().determineMod();
        int defenderMod = monster.determineMod();
        Ability abilityToCast = spellList.get(1);
        RollDice didHit = new RollDice(attackerRoll, defenderRoll, attackerMod, defenderMod);
        if (didHit.isSuccessful()){
            abilityToCast.toAttack(Player.getInstance()).applyTo(monster);
            TextView monsterCurrentHealth = findViewById(R.id.monsterCurrentHealth);
            monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));
        }
        TextView resultsString = findViewById(R.id.attackResults);
        resultsString.setText(new StringBuilder().append("You = ").append((attackerMod + attackerRoll)).append("Gob = ").append((defenderMod + defenderRoll)).toString());
        TextView resultsString2 = findViewById(R.id.attackResults2);
        resultsString2.setText(new StringBuilder().append("Gob roll + mod = ").append((defenderMod + defenderRoll)).toString());
        endTurn();
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
            abilityToCast.toAttack(Player.getInstance()).applyTo(monster);
            TextView monsterCurrentHealth = findViewById(R.id.monsterCurrentHealth);
            monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));
        }
        TextView resultsString = findViewById(R.id.attackResults);
        resultsString.setText(new StringBuilder().append("You = ").append((attackerMod + attackerRoll)).append("Gob = ").append((defenderMod + defenderRoll)).toString());
        TextView resultsString2 = findViewById(R.id.attackResults2);
        resultsString2.setText(new StringBuilder().append("Gob roll + mod = ").append((defenderMod + defenderRoll)).toString());
        endTurn();
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
            abilityToCast.toAttack(Player.getInstance()).applyTo(monster);
            TextView monsterCurrentHealth = findViewById(R.id.monsterCurrentHealth);
            monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));
        }
        TextView resultsString = findViewById(R.id.attackResults);
        resultsString.setText(new StringBuilder().append("You = ").append((attackerMod + attackerRoll)).append("Gob = ").append((defenderMod + defenderRoll)).toString());
        TextView resultsString2 = findViewById(R.id.attackResults2);
        resultsString2.setText(new StringBuilder().append("Gob roll + mod = ").append((defenderMod + defenderRoll)).toString());
        endTurn();
    }


    public boolean checkIfMonsterDead(){
        return monster.getCurrentHealth() < 1;
    }

    public void characterKillGains(){
        playerNewExperience = Player.getInstance().experience + monster.getExperience();
        playerNewGold = Player.getInstance().gold + monster.getGold();
        Player.getInstance().setExperience(playerNewExperience);
        Player.getInstance().setGold(playerNewGold);
        levelUp check = new levelUp(playerNewExperience, Player.getInstance().getExperience());
        int experienceNeeded = check.experienceNeeded(Player.getInstance().level);
        if (experienceNeeded < Player.getInstance().getExperience()){
            Player.getInstance().setLevel(Player.getInstance().getLevel() + 1);
            Player.getInstance().setAvailablePoints(Player.getInstance().getAvailablePoints() + 5);
        }

    }

    public void endTurn(){
        if (checkIfMonsterDead()){
           displayMonsterDefinitelydead();
           characterKillGains();
        }
            else {
            Random rand = new Random();
            int attackerRoll = rand.nextInt(20 + 1) + 1;
            int defenderRoll = rand.nextInt((20) + 1) + 1;
            int attackerMod = monster.determineMod();
            int defenderMod = Player.getInstance().determineMod();
            Ability abilityToCast = new MeleeStrike(1);
            RollDice didHit = new RollDice(attackerRoll, defenderRoll, attackerMod, defenderMod);
            TextView resultsString2 = findViewById(R.id.attackResults2);
            resultsString2.setText(new StringBuilder().append("You = ").append((defenderMod + defenderRoll)).append("Gob = ").append((attackerMod + attackerRoll)).toString());
            if (didHit.isSuccessful()){
                abilityToCast.toAttack(monster).applyTo(Player.getInstance());
                TextView playerCurrentHealth = findViewById(R.id.playerCurrentHealth);
                playerCurrentHealth.setText(String.valueOf(Player.getInstance().getCurrentHealth()));
                TextView resultsString3 = findViewById(R.id.attackResults2);
                resultsString3.setText(new StringBuilder().append("Your roll + mod = ").append((defenderMod + defenderRoll)).append("You took ").append(monster.baseDamage).toString());
                if (checkIfPlayerDead()){
                    displayPlayerDead();
                    new youDead();
                }
            }
        }



    }

    public boolean checkIfPlayerDead(){
        return Player.getInstance().getCurrentHealth() < 1;
    }

    public void displayMonsterDamage(String x) {
        TextView returnDamage = (TextView) findViewById(R.id.attackResults);
        returnDamage.setText(x);
    }

    public void displayMonsterDefinitelydead() {
        TextView leaveItalone = (TextView) findViewById(R.id.attackResults2);
        String x = "The Monster's dead Dave. You gained " + String.valueOf(monster.getExperience()) + " experience";
        leaveItalone.setText(x);
        levelComplete = 1;
        Button endLevel = (Button) findViewById(R.id.completeLevel);
        endLevel.setBackgroundColor(0xFFFF0000);
    }

    public void displayPlayerDead() {
        TextView returnDamage = (TextView) findViewById(R.id.attackResults);
        String x = "You are Dead";
        returnDamage.setText(x);
        setContentView(R.layout.activity_you_dead);
    }

    public void displayPlayerHealth() {
        TextView confirmPlayerCurrentHP = (TextView) findViewById(R.id.playerCurrentHealth);
        confirmPlayerCurrentHP.setText(String.valueOf(Player.getInstance().getCurrentHealth()));
        TextView confirmPlayerCurrentMP = (TextView) findViewById(R.id.playerCurrentMana);
        confirmPlayerCurrentMP.setText(String.valueOf(Player.getInstance().getCurrentMana()));
    }

    public void displayLevelUp() {
        TextView confirmLevelUp = (TextView) findViewById(R.id.Enemy);
        confirmLevelUp.setText("Level up!");
        displayLevel();
    }

    public void displayLevel() {
        TextView confirmPlayerLevel = (TextView) findViewById(R.id.playerLevel);
        confirmPlayerLevel.setText(String.valueOf(Player.getInstance().getLevel()));
    }

    public void endLevel(View view) {
        if (levelComplete == 1) {
            int goldDifference = playerNewGold - playerOldGold;
            int experienceDifference = playerNewExperience - playerOldExperience;
            Intent confirmIntent = new Intent(level1Activity.this, levelComplete.class);
            confirmIntent.putExtra("playerGold", goldDifference);
            confirmIntent.putExtra("playerExperience", experienceDifference);
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