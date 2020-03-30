package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.android.adventurersofarldem.Abilities.Fireball;
import com.example.android.adventurersofarldem.Abilities.Frostbolt;
import com.example.android.adventurersofarldem.Abilities.HolyStrike;
import com.example.android.adventurersofarldem.Abilities.MeleeStrike;
import com.example.android.adventurersofarldem.Characters.Goblin;
import com.example.android.adventurersofarldem.Characters.Player;

public class CharacterSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);

        mButton = (Button) findViewById(R.id.confirm);

    }

    Button mButton;
    String playerClass = "";
    int playerSt = 0;
    int playerAg = 0;
    int playerIn = 0;
    int playerMHP = 0;
    int playerCHP = 0;
    int playerMMP = 0;
    int playerCMP = 0;
    int playerExperience = 0;
    int playerLevel = 0;


    public void submitPlayer(View view){
        EditText pName = (EditText) findViewById(R.id.addName);
        String playerName = pName.getText().toString();
        Player.getInstance().setStrength(playerSt);
        Player.getInstance().setCharacterName(playerName);
        Player.getInstance().setAgility(playerAg);
        Player.getInstance().setCharacterClass(playerClass);
        Player.getInstance().setIntellect(playerIn);
        Player.getInstance().setCurrentHealth(playerCHP);
        Player.getInstance().setMaximumHealth(playerMHP);
        Player.getInstance().setCurrentMana(playerCMP);
        Player.getInstance().setMaximumMana(playerMMP);
        Player.getInstance().setExperience(playerExperience);
        Player.getInstance().setLevel(playerLevel);
        Player.getInstance().setNextEnemy(new Goblin());
        Player.getInstance().setPosX(18);
        Player.getInstance().setPosY(18);

        Button confirm = findViewById(R.id.confirm);
                Intent creationIntent = new Intent(CharacterSelection.this, level1Activity.class);
                startActivity(creationIntent);
        }




    public void playerSelectedWizard(View view){
        ImageView wizardClass;
            wizardClass = (ImageView) findViewById(R.id.Wizard);
            wizardClass.setImageResource(R.drawable.wizardyes);

        ImageView rangerClass;
            rangerClass = (ImageView) findViewById(R.id.Ranger);
            rangerClass.setImageResource(R.drawable.ranger);

        ImageView warriorClass;
            warriorClass = (ImageView) findViewById(R.id.Warrior);
            warriorClass.setImageResource(R.drawable.warrior);

        playerClass = "Wizard";
        playerSt = 8;
        playerAg = 8;
        playerIn = 12;
        playerMHP = 6;
        playerCHP = 6;
        playerMMP = 20;
        playerCMP = 20;
        playerExperience = 1;
        playerLevel = 1;

        Player.getInstance().setSpellList(new Frostbolt(1), new Fireball(2), new HolyStrike(3), new Frostbolt(4) );

    }

    public void playerSelectedWarrior(View view) {
        ImageView wizardClass;
            wizardClass = (ImageView) findViewById(R.id.Wizard);
            wizardClass.setImageResource(R.drawable.wizard);

        ImageView rangerClass;
            rangerClass = (ImageView) findViewById(R.id.Ranger);
            rangerClass.setImageResource(R.drawable.ranger);

        ImageView warriorClass;
            warriorClass = (ImageView) findViewById(R.id.Warrior);
            warriorClass.setImageResource(R.drawable.warrioryes);

        playerClass = "Warrior";
        playerSt = 12;
        playerAg = 8;
        playerIn = 8;
        playerMHP = 8;
        playerCHP = 8;
        playerMMP = 4;
        playerCMP = 4;
        playerExperience = 1;
        playerLevel = 1;

        Player.getInstance().setSpellList(new MeleeStrike(1), new MeleeStrike(2), new MeleeStrike(3), new MeleeStrike(4) );


    }

    public void playerSelectedRanger(View view){
        ImageView wizardClass;
            wizardClass = (ImageView) findViewById(R.id.Wizard);
            wizardClass.setImageResource(R.drawable.wizard);

        ImageView rangerClass;
            rangerClass = (ImageView) findViewById(R.id.Ranger);
            rangerClass.setImageResource(R.drawable.rangeryes);

        ImageView warriorClass;
            warriorClass = (ImageView) findViewById(R.id.Warrior);
            warriorClass.setImageResource(R.drawable.warrior);

        playerClass = "Ranger";
        playerSt = 8;
        playerAg = 12;
        playerIn = 8;
        playerMHP = 7;
        playerCHP = 7;
        playerMMP = 4;
        playerCMP = 4;
        playerExperience = 1;
        playerLevel = 1;

        Player.getInstance().setSpellList(new MeleeStrike(1), new Frostbolt(2), new MeleeStrike(3), new Frostbolt(4) );
    }

}

