package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class fight_launcher extends AppCompatActivity {

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
    public int playerGold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_launcher);
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
        playerGold = getIntent().getIntExtra("playerGold", playerGold);
        TextView confirmPlayerGold = (TextView) findViewById(R.id.playerGold);
        confirmPlayerGold.setText(String.valueOf(playerGold));

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
    }

    public void refreshStats(){
        TextView confirmPlayerGold = (TextView) findViewById(R.id.playerGold);
        confirmPlayerGold.setText(String.valueOf(playerGold));

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
    }


    public void heal(View view){
        if (playerGold > 2){
            playerCurrentHP = playerMaxHP;
            playerCurrentMP = playerMaxMP;
            playerGold -= 3;
            refreshStats();
            TextView status = (TextView) findViewById(R.id.status);
            status.setText("You have healed to full health for 10 GP");
        }
        else {
            TextView status = (TextView) findViewById(R.id.status);
            status.setText("You don't have enough gold");
        }

    }

    public void addFiveHealth(View view){
        if (playerGold > 4){
            playerCurrentHP += 5;
            playerMaxHP += 5;
            playerGold -= 5;
            refreshStats();
            TextView status = (TextView) findViewById(R.id.status);
            status.setText("You have gained 5 HP");
        }
        else {
            TextView status = (TextView) findViewById(R.id.status);
            status.setText("You don't have enough gold");

        }
    }

    public void addTenHealth(View view){
        if (playerGold > 7){
            playerCurrentHP += 10;
            playerMaxHP += 10;
            playerGold -= 8;
            refreshStats();
            TextView status = (TextView) findViewById(R.id.status);
            status.setText("You have gained 10 HP");
        }
        else {
            TextView status = (TextView) findViewById(R.id.status);
            status.setText("You don't have enough gold");

        }
    }

    public void addOneStrength(View view){
        if (playerGold > 9){
            playerStrength += 1;
            playerGold -= 10;
            refreshStats();
            TextView status = (TextView) findViewById(R.id.status);
            status.setText("You have gained 1 Strength");
        }
        else {
            TextView status = (TextView) findViewById(R.id.status);
            status.setText("You don't have enough gold");

        }
    }

    public void addOneAgility(View view){
        if (playerGold > 9){
            playerAgility += 1;
            playerGold -= 10;
            refreshStats();
            TextView status = (TextView) findViewById(R.id.status);
            status.setText("You have gained 1 Agility");
        }
        else {
            TextView status = (TextView) findViewById(R.id.status);
            status.setText("You don't have enough gold");

        }
    }

    public void addOneIntellect(View view){
        if (playerGold > 9){
            playerIntellect += 1;
            playerGold -= 10;
            refreshStats();
            TextView status = (TextView) findViewById(R.id.status);
            status.setText("You have gained 1 Intellect");
        }
        else {
            TextView status = (TextView) findViewById(R.id.status);
            status.setText("You don't have enough gold");

        }
    }

    public void fightOrc(View view){
            Intent confirmIntent = new Intent(fight_launcher.this, level1Activity.class);
            confirmIntent.putExtra("playerStrength", playerStrength);
            confirmIntent.putExtra("playerAgility", playerAgility);
            confirmIntent.putExtra("playerIntellect", playerIntellect);
            confirmIntent.putExtra("playerMaxHP", playerMaxHP);
            confirmIntent.putExtra("playerMaxMP", playerMaxMP);
            confirmIntent.putExtra("playerCurrentHP", playerCurrentHP);
            confirmIntent.putExtra("playerCurrentMP", playerCurrentMP);
            confirmIntent.putExtra("playerClass", playerClass);
            confirmIntent.putExtra("playerName", playerName);
            confirmIntent.putExtra("playerExperience", playerExperience);
            confirmIntent.putExtra("playerLevel", playerLevel);
            confirmIntent.putExtra("playerGold", playerGold);
            confirmIntent.putExtra("enemyChoice", "Orc");
            Button button = (Button)findViewById(R.id.fight_orc_button);
            final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
            button.startAnimation(myAnim);

            // Use bounce interpolator with amplitude 0.2 and frequency 20
            MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
            myAnim.setInterpolator(interpolator);

            button.startAnimation(myAnim);
            if (confirmIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(confirmIntent); }
        }


    public void fightGoblin(View view){
        Intent confirmIntent = new Intent(fight_launcher.this, level1Activity.class);
        confirmIntent.putExtra("playerStrength", playerStrength);
        confirmIntent.putExtra("playerAgility", playerAgility);
        confirmIntent.putExtra("playerIntellect", playerIntellect);
        confirmIntent.putExtra("playerMaxHP", playerMaxHP);
        confirmIntent.putExtra("playerMaxMP", playerMaxMP);
        confirmIntent.putExtra("playerCurrentHP", playerCurrentHP);
        confirmIntent.putExtra("playerCurrentMP", playerCurrentMP);
        confirmIntent.putExtra("playerClass", playerClass);
        confirmIntent.putExtra("playerName", playerName);
        confirmIntent.putExtra("playerExperience", playerExperience);
        confirmIntent.putExtra("playerLevel", playerLevel);
        confirmIntent.putExtra("playerGold", playerGold);
        confirmIntent.putExtra("enemyChoice", "Goblin");
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }
    }

    public void fightDragon(View view){
        Intent confirmIntent = new Intent(fight_launcher.this, level1Activity.class);
        confirmIntent.putExtra("playerStrength", playerStrength);
        confirmIntent.putExtra("playerAgility", playerAgility);
        confirmIntent.putExtra("playerIntellect", playerIntellect);
        confirmIntent.putExtra("playerMaxHP", playerMaxHP);
        confirmIntent.putExtra("playerMaxMP", playerMaxMP);
        confirmIntent.putExtra("playerCurrentHP", playerCurrentHP);
        confirmIntent.putExtra("playerCurrentMP", playerCurrentMP);
        confirmIntent.putExtra("playerClass", playerClass);
        confirmIntent.putExtra("playerName", playerName);
        confirmIntent.putExtra("playerExperience", playerExperience);
        confirmIntent.putExtra("playerLevel", playerLevel);
        confirmIntent.putExtra("playerGold", playerGold);
        confirmIntent.putExtra("enemyChoice", "Dragon");
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }
    }

    public void nextLevel(View view){
        Intent confirmIntent = new Intent(fight_launcher.this, spellSelectActivity.class);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }
        }
    }


