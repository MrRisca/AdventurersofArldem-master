package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import org.w3c.dom.Text;

import java.util.ArrayList;


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
    public String enemyChoice = "Goblin";
    ArrayList<String> spellList;
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
        spellList = getIntent().getStringArrayListExtra("spellList");


        //Import the Player's name, class and stats from where they just entered them

        playerName = Player.name;
        playerClass = Player.playerClass;
        playerStrength = Player.strength;
        playerAgility = Player.agility;
        playerIntellect = Player.intellect;
        playerMaxHP = Player.maximumHealth;
        playerMaxMP = Player.maximumMana;
        playerCurrentHP = Player.currentHealth;
        playerCurrentMP = Player.currentMana;
        pArmorClass = ((10 + (playerAgility / 2)) - 5);
        playerExperience = Player.playerXP;
        playerLevel = Player.playerLevel;
        enemyChoice = getIntent().getStringExtra("enemyChoice");
        playerGold = Player.playerGold;
        if (enemyChoice.equals("Orc")) {
            monster = new Orc();

        } else {
            if (enemyChoice.equals("Dragon")) {
                monster = new Dragon();

            } else {
                monster = new Goblin();


            }
        }


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
        playerSpell1.setText(Singleton.getInstance().playerSpellList.get(0));

        TextView playerSpell2 = (TextView) findViewById(R.id.playerSpell2);
        playerSpell2.setText(Singleton.getInstance().playerSpellList.get(1));

        TextView playerSpell3 = (TextView) findViewById(R.id.playerSpell3);
        playerSpell3.setText(Singleton.getInstance().playerSpellList.get(2));

        TextView playerSpell4 = (TextView) findViewById(R.id.playerSpell4);
        playerSpell4.setText(Singleton.getInstance().playerSpellList.get(3));

    }

    //Perform battle to compare goblins' AC vs player's roll to see if damage is done.
    public void fight(View view) {
        Battle battle = new Battle(playerStrength, monster.getBaseDamage(), pArmorClass, monster.getMaximumHealth(), monster.getMaximumMana(), monster.getCurrentHealth(), monster.getCurrentMana(), playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP, playerClass);

        if (monster.getCurrentHealth() < 1) {

            displayMonsterDefinitelydead();
            endLevel(view);
        } else {
            int x = battle.combatWarrior(playerStrength, playerAgility, playerClass, monster.getArmorClass(), monster.getCurrentHealth());

            int damageDone = x;
            monster.setCurrentHealth((monster.getCurrentHealth() - x));
            monsterSpecial();
//            int y = battle.combatEnemy(monster.getBaseDamage(), pArmorClass, monster.getCurrentHealth(), playerCurrentHP, monsterRoll);
//            playerCurrentHP = playerCurrentHP - y;
            if (monster.getCurrentHealth() < 1) {
                displayMonsterDead(view);
                levelComplete = 1;
            } else {
                String monsterMessage = "You did " + String.valueOf(damageDone) + " damage to the Monster";
                monsterMessage += "\n They have " + String.valueOf(monster.getCurrentHealth()) + " health left";
                displayMonsterHealth(monsterMessage);
            }

            if (playerCurrentHP < 1) {
                String damageReport = "You were hit for " + String.valueOf(valueOfMonsterAttack) + " damage, and now you have " + playerCurrentHP + " left";
                displayMonsterDamage(damageReport);
                displayPlayerHealth();

                Intent confirmIntent = new Intent(level1Activity.this, youDead.class);

                startActivity(confirmIntent);

            } else {
                String damageReport = "You were hit for " + String.valueOf(valueOfMonsterAttack) + " damage, and now you have " + playerCurrentHP + " left";
                displayMonsterDamage(damageReport);
                displayPlayerHealth();
            }
        }
    }


    public void lightFight(View view) {
        Battle battle = new Battle(playerStrength, monster.getBaseDamage(), pArmorClass, monster.getMaximumHealth(), monster.getMaximumMana(), monster.getCurrentHealth(), monster.getCurrentMana(), playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP, playerClass);

        if (monster.getCurrentHealth() < 1) {

            displayMonsterDefinitelydead();
            endLevel(view);
        } else {
            int x = battle.combatLight(playerStrength, playerAgility, playerClass, monster.getArmorClass(), monster.getCurrentHealth());

            int damageDone = x;
            monster.setCurrentHealth((monster.getCurrentHealth() - x));
            int y = battle.combatEnemy(monster.getBaseDamage(), pArmorClass, monster.getCurrentHealth(), playerCurrentHP, monsterRoll);
            playerCurrentHP = playerCurrentHP - y;
            if (monster.getCurrentHealth() < 1) {
                displayMonsterDead(view);
                levelComplete = 1;
            } else {
                String monsterMessage = "You did " + String.valueOf(damageDone) + " damage to the Monster";
                monsterMessage += "\n They have " + String.valueOf(monster.getCurrentHealth()) + " health left";
                displayMonsterHealth(monsterMessage);
            }

            if (playerCurrentHP < 1) {
                String damageReport = "You were hit for " + String.valueOf(y) + " damage, and now you have " + playerCurrentHP + " left";
                displayMonsterDamage(damageReport);
                displayPlayerHealth();

                Intent confirmIntent = new Intent(level1Activity.this, youDead.class);

                startActivity(confirmIntent);

            } else {
                String damageReport = "You were hit for " + String.valueOf(y) + " damage, and now you have " + playerCurrentHP + " left";
                displayMonsterDamage(damageReport);
                displayPlayerHealth();
            }
        }
    }

    public void heavyFight(View view) {
        Battle battle = new Battle(playerStrength, monster.getBaseDamage(), pArmorClass, monster.getMaximumHealth(), monster.getMaximumMana(), monster.getCurrentHealth(), monster.getCurrentMana(), playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP, playerClass);

        if (monster.getCurrentHealth() < 1) {

            displayMonsterDefinitelydead();
            endLevel(view);
        } else {
            int x = battle.combatHeavy(playerStrength, playerAgility, playerClass, monster.getArmorClass(), monster.getCurrentHealth());

            int damageDone = x;
            monster.setCurrentHealth((monster.getCurrentHealth() - x));
            int y = battle.combatEnemy(monster.getBaseDamage(), pArmorClass, monster.getCurrentHealth(), playerCurrentHP, monsterRoll);
            playerCurrentHP = playerCurrentHP - y;
            if (monster.getCurrentHealth() < 1) {
                displayMonsterDead(view);
                levelComplete = 1;
            } else {
                String monsterMessage = "You did " + String.valueOf(damageDone) + " damage to the Monster";
                monsterMessage += "\n They have " + String.valueOf(monster.getCurrentHealth()) + " health left";
                displayMonsterHealth(monsterMessage);
            }

            if (playerCurrentHP < 1) {
                String damageReport = "You were hit for " + String.valueOf(y) + " damage, and now you have " + playerCurrentHP + " left";
                displayMonsterDamage(damageReport);
                displayPlayerHealth();

                Intent confirmIntent = new Intent(level1Activity.this, youDead.class);

                startActivity(confirmIntent);

            } else {
                String damageReport = "You were hit for " + String.valueOf(y) + " damage, and now you have " + playerCurrentHP + " left";
                displayMonsterDamage(damageReport);
                displayPlayerHealth();
            }
        }
    }

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

    public void magicClick(View view) {
        Battle battle = new Battle(playerStrength, monster.getBaseDamage(), pArmorClass, monster.getMaximumHealth(), monster.getMaximumMana(), monster.getCurrentHealth(), monster.getCurrentMana(), playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP, playerClass);

        if (monster.getCurrentHealth() < 1) {

            displayMonsterDefinitelydead();
            endLevel(view);
        } else if ((playerCurrentMP > 5)) {
            int damageDone = (10 + (playerIntellect / 4));
            monster.setCurrentHealth((monster.getCurrentHealth() - damageDone));
            int y = battle.combatEnemy(monster.getBaseDamage(), pArmorClass, monster.getCurrentHealth(), playerCurrentHP, monsterRoll);
            playerCurrentHP = playerCurrentHP - y;
            playerCurrentMP = playerCurrentMP - 10;
            if (monster.getCurrentHealth() < 1) {
                displayMonsterDead(view);
                levelComplete = 1;
            } else {
                String monsterMessage = "You did " + String.valueOf(damageDone) + " damage to the Monster";
                monsterMessage += "\n They have " + String.valueOf(monster.getCurrentHealth()) + " health left";
                displayMonsterHealth(monsterMessage);
            }

            if (playerCurrentHP < 1) {
                String damageReport = "You were hit for " + String.valueOf(y) + " damage, and now you have " + playerCurrentHP + " left";
                displayMonsterDamage(damageReport);
                displayPlayerHealth();

                Intent confirmIntent = new Intent(level1Activity.this, youDead.class);

                startActivity(confirmIntent);

            } else {
                String damageReport = "You were hit for " + String.valueOf(y) + " damage, and now you have " + playerCurrentHP + " left";
                displayMonsterDamage(damageReport);
                displayPlayerHealth();
            }
        }

    }

    public void attackOne(View view) {
        if (Singleton.getInstance().playerSpellList.get(0).equals("Normal Attack")) {
            fight(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(0).equals("Heavy Attack")){
            heavyFight(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(0).equals("Block")){
            lightFight(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(0).equals("Fireball"))  {
            magicClick(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(0).equals("Frostbolt")) {
            magicClick(view);
        }
        playerTarget = 0;



    }

    public void attackTwo(View view) {
        if (Singleton.getInstance().playerSpellList.get(1).equals("Normal Attack")) {
            fight(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(1).equals("Heavy Attack")){
            heavyFight(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(1).equals("Block")){
            lightFight(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(1).equals("Fireball"))  {
            magicClick(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(1).equals("Frostbolt")) {
            magicClick(view);
        }
    }

    public void attackThree(View view) {
        if (Singleton.getInstance().playerSpellList.get(2).equals("Normal Attack")) {
            fight(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(2).equals("Heavy Attack")) {
            heavyFight(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(2).equals("Block")) {
            lightFight(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(2).equals("Fireball")) {
            magicClick(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(2).equals("Frostbolt")) {
            magicClick(view);
        }
    }

    public void attackFour(View view) {
        if (Singleton.getInstance().playerSpellList.get(3).equals("Normal Attack")) {
            fight(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(3).equals("Heavy Attack")) {
            heavyFight(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(3).equals("Block")){
            lightFight(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(3).equals("Fireball"))  {
            magicClick(view);
        }
        else if (Singleton.getInstance().playerSpellList.get(3).equals("Frostbolt")) {
            magicClick(view);
        }
    }

    public void monsterSpecial() {
        Battle battle = new Battle(playerStrength, monster.getBaseDamage(), pArmorClass, monster.getMaximumHealth(), monster.getMaximumMana(), monster.getCurrentHealth(), monster.getCurrentMana(), playerAgility, playerIntellect, playerMaxHP, playerMaxMP, playerCurrentHP, playerCurrentMP, playerClass);
        if (monsterAttackTurn == 3){
            castMonsterSpecial();

        }
        else {
            valueOfMonsterAttack = battle.combatEnemy(monster.getBaseDamage(), pArmorClass, monster.getCurrentHealth(), playerCurrentHP, monsterRoll);
            playerCurrentHP = playerCurrentHP - valueOfMonsterAttack;
        }
        monsterAttackTurn += 1;

    }

    public void castMonsterSpecial() {

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
            confirmIntent.putStringArrayListExtra("spellList", spellList);
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